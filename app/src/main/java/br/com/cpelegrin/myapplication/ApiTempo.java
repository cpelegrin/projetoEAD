package br.com.cpelegrin.myapplication;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTempo {
    //"https://api.hgbrasil.com/weather/?format=json&woeid=455883&locale=pt"
    @GET("weather/?format=json&woeid=455883&locale=pt")
    Call<ApiPojo> getInfTempo();
}
