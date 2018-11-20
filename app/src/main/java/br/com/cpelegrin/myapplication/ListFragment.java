package br.com.cpelegrin.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private static final String TAG = "ListFragment";

    DadosTempo dados;
    TextView cidade;

    public ListFragment() {
        // Required empty public constructor
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        dados = new DadosTempo();

        //Requisição, seta lista

        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://api.hgbrasil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiTempo httpRequest = client.create(ApiTempo.class);

        Call<ApiPojo> call = httpRequest.getInfTempo();

        call.enqueue(callback);

        mAdapter = new ListAdapter(dados);
        mRecyclerView.setAdapter(mAdapter);

        cidade = v.findViewById(R.id.cityText);

        return v;
    }

    private Callback<ApiPojo> callback = new Callback<ApiPojo>() {
        @Override
        public void onResponse(Call<ApiPojo> call, Response<ApiPojo> response) {

            dados.setCidade(response.body().getResults().getCityName());
            dados.setLista(response.body().getResults().getForecast());

            cidade.setText(dados.getCidade());

            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<ApiPojo> call, Throwable t) {
            Log.e(TAG, "Erro na Requisição: "+ t.toString());
        }
    };

}
