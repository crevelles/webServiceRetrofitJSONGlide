package com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils;

import com.example.cristobal.webserviceretrofitjsonglide.dataJson.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cristobal on 05/02/2018.
 */

public interface RestServicePokemon {

    public static final String BASE_URL = " https://pokeapi.co/api/v2/";

    //Recuerda que hay que importar en gradle
    @GET("pokemon/")
    Call<Pokemon> obtenerPokemon(@Query("limit") String limite);
}
