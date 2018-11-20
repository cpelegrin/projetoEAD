package br.com.cpelegrin.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView dataDiaSemana;
        TextView min;
        TextView max;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dataDiaSemana = itemView.findViewById(R.id.dateText);
            min = itemView.findViewById(R.id.minText);
            max = itemView.findViewById(R.id.maxText);
            description = itemView.findViewById(R.id.descriptionText);
        }
    }

    private ArrayList<Forecast> listaDadosTempo;
    public ListAdapter(DadosTempo dados) {
        listaDadosTempo = dados.getLista();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_tempo, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Forecast itemPosition = listaDadosTempo.get(position);

        viewHolder.dataDiaSemana.setText(itemPosition.getDate() + " - " + itemPosition.getWeekday());
        viewHolder.description.setText(itemPosition.getDescription());
        viewHolder.max.setText(itemPosition.getMax());
        viewHolder.min.setText(itemPosition.getMin());
    }

    @Override
    public int getItemCount() {
        return listaDadosTempo.size();
    }

}
