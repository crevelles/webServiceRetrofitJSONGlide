package com.example.cristobal.webserviceretrofitjsonglide;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cristobal.webserviceretrofitjsonglide.dataJson.Pokemon;
import com.example.cristobal.webserviceretrofitjsonglide.dataJson.PokemonResult;
import com.example.cristobal.webserviceretrofitjsonglide.dataJson.PokemonResult2;
import com.example.cristobal.webserviceretrofitjsonglide.recyclerViewUtils.ItemPokemon;
import com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils.RestServicePokemon;
import com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils.RestServicePokemon2;
import com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PokemonSeleccionado extends AppCompatActivity {

    String idPokemon;
    ImageView pokemonSeleccionado;
    ImageView pokemonDetras;
    TextView nombreFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_seleccionado);
        idPokemon = getIntent().getStringExtra("codigoPokemon");
        pokemonSeleccionado = findViewById(R.id.idFotoPokemon);
        pokemonDetras = findViewById(R.id.idFotoPokeDetras);
        nombreFinal = findViewById(R.id.idNombreFinal);
        invocarWS();
    }

    private void invocarWS() {
        if (isNetworkAvailable()) {
            Retrofit r = RetrofitClient.getClient(RestServicePokemon2.BASE_URL);
            RestServicePokemon2 rp = r.create(RestServicePokemon2.class);
            Call<PokemonResult2> call = rp.obtenerFotoPokemon(idPokemon);
            call.enqueue(new Callback<PokemonResult2>() {
                @Override
                public void onResponse(Call<PokemonResult2> call, Response<PokemonResult2> response) {
                    if (!response.isSuccessful()) {
                        Log.e("error", response.code() + "");
                    } else {
                        PokemonResult2 pok = response.body();
                        String urlFoto = pok.getSprites().getFrontDefault();
                        String urlFotoDetras = pok.getSprites().getBackDefault();
                        Glide.with(pokemonSeleccionado.getContext())
                                .load(urlFoto)
                                .into(pokemonSeleccionado);

                        Glide.with(pokemonDetras.getContext())
                                .load(urlFotoDetras)
                                .into(pokemonDetras);

                        nombreFinal.setText(pok.getName());
                    }
                }

                @Override
                public void onFailure(Call<PokemonResult2> call, Throwable t) {

                }
            });
    }
    }


    private boolean isNetworkAvailable() {
        boolean isAvailable=false;
        //Gestor de conectividad
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //Objeto que recupera la información de la red
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        //Si la información de red no es nula y estamos conectados
        //la red está disponible
        if(networkInfo!=null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;

    }
}
