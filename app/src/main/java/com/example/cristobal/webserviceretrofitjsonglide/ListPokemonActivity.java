package com.example.cristobal.webserviceretrofitjsonglide;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristobal.webserviceretrofitjsonglide.dataJson.Pokemon;
import com.example.cristobal.webserviceretrofitjsonglide.dataJson.PokemonResult;
import com.example.cristobal.webserviceretrofitjsonglide.recyclerViewUtils.AdaptadorPokemon;
import com.example.cristobal.webserviceretrofitjsonglide.recyclerViewUtils.ItemPokemon;
import com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils.RestServicePokemon;
import com.example.cristobal.webserviceretrofitjsonglide.retrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListPokemonActivity extends AppCompatActivity {


    private String numPokemon;
    private ProgressBar pb;
    private ArrayList<ItemPokemon> lista;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private AdaptadorPokemon ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);

        pb = findViewById(R.id.idPB);
        pb.setVisibility(View.VISIBLE);
        lista = new ArrayList<ItemPokemon>();
        //Recuperamos lo que viene del intent
        numPokemon = getIntent().getStringExtra(getResources().getString(R.string.clave_num_pokemon));
        //invocamos al webservice
        invocarWS();
        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemPokemon itemSeleccionado = lista.get(rv.getChildAdapterPosition(v));
                Intent intent  = new Intent(ListPokemonActivity.this,PokemonSeleccionado.class );
                intent.putExtra("codigoPokemon", itemSeleccionado.getCodigo());
                startActivity(intent);
            }
        });
    }

    private void configurarRV() {
        rv = findViewById(R.id.rvPokemon);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        ap = new AdaptadorPokemon(lista);
        rv.setAdapter(ap);

    }

    private void invocarWS() {
        if(isNetworkAvailable()){
            Retrofit r = RetrofitClient.getClient(RestServicePokemon.BASE_URL);
            RestServicePokemon rp = r.create(RestServicePokemon.class);
            Call<Pokemon> call = rp.obtenerPokemon(numPokemon);


            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    pb.setVisibility(View.GONE);

                    if(!response.isSuccessful()){
                        Log.e("error", response.code() + "");
                    } else {
                        Pokemon pokeRes = response.body();
                        ItemPokemon obj = null;

                        for(PokemonResult poke: pokeRes.getResults()){
                            obj = new ItemPokemon(obtenerCOdigo(poke.getUrl()), poke.getName());
                            lista.add(obj);
                        }
                    }
                }
                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    pb.setVisibility(View.GONE);
                    Log.e("error", t.toString());
                }
            });
            //configuramos recyclerVIew
            configurarRV();
        } else {
            Toast.makeText(this, "Error de conexión", Toast.LENGTH_LONG).show();
        }
    }

    private String obtenerCOdigo(String url){
        String codigo ="";
        String pokemonAux = "pokemon/";
        int indice = 0; // indice de pokemon\/
        int indiceSiguiente = 0; //ultimo indicede \/

        indice = url.lastIndexOf(pokemonAux) + pokemonAux.length();
        indiceSiguiente = url.lastIndexOf("/");
        codigo = url.substring(indice,indiceSiguiente);

        return  codigo;
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
