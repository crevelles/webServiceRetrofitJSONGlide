package com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils;

import com.example.cristobal.webserviceretrofitjsonglide.dataJson.Pokemon;
import com.example.cristobal.webserviceretrofitjsonglide.dataJson.PokemonResult2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cristobal on 07/02/2018.
 */

public interface RestServicePokemon2 {

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon-form/{fotoPokemon}")
    Call<PokemonResult2> obtenerFotoPokemon(@Path("fotoPokemon") String fotoPokemon);

}
