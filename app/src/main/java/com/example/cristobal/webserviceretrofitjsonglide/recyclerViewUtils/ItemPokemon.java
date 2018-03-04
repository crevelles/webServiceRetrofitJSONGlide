package com.example.cristobal.webserviceretrofitjsonglide.recyclerViewUtils;

/**
 * Created by cristobal on 05/02/2018.
 */

public class ItemPokemon {
    private String codigo;
    private String nombre;


    public ItemPokemon(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }


}
