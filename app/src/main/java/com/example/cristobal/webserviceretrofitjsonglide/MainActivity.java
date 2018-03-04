package com.example.cristobal.webserviceretrofitjsonglide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnConsultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConsultar = findViewById(R.id.btnConsultar);
        et = findViewById(R.id.etNumPokm);


        //añadimos en el boton un listener
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pasamos al siguiente activity para despues invocar al webservice
                Intent intent = new Intent(MainActivity.this, ListPokemonActivity.class);
                String numPokemon = et.getText().toString();
                //pasamos el numero de pokemon, para ello hemos creado un string que hace referencia
                intent.putExtra(getResources().getString(R.string.clave_num_pokemon), numPokemon);
                startActivity(intent);
            }
        });
    }
}
