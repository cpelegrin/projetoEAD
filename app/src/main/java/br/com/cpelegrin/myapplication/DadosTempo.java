package br.com.cpelegrin.myapplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DadosTempo {
    private String cidade;
    private ArrayList<Forecast> lista = new ArrayList<>();

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Forecast> getLista() {
        return lista;
    }

    public void setLista(List<Forecast> lista) {
        this.lista.addAll(lista);
    }
}
