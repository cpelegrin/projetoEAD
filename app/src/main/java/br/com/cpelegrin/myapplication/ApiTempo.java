package br.com.cpelegrin.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTempo {
    //"https://api.hgbrasil.com/weather/?format=json&woeid=455883&locale=pt"
    @GET("weather/?format=json&woeid=455918&locale=pt")
    Call<ApiPojo> getInfTempo();
}
