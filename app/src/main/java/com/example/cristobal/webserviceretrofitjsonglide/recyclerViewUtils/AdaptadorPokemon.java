package com.example.cristobal.webserviceretrofitjsonglide.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cristobal.webserviceretrofitjsonglide.R;

import java.util.ArrayList;

/**
 * Created by cristobal on 05/02/2018.
 */

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.vhPokemon> implements View.OnClickListener {

    private ArrayList<ItemPokemon> datos;
    private View.OnClickListener listener;


    public AdaptadorPokemon(ArrayList<ItemPokemon> datos) {
        this.datos = datos;
    }

    //Creamos la clase interna
    public static class vhPokemon extends  RecyclerView.ViewHolder{
        private TextView tvCodigo;
        private TextView tvNombre;

        public vhPokemon(View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvNombre = itemView.findViewById(R.id.tvNombre);
        }

        public TextView getTvCodigo() {
            return tvCodigo;
        }

        public TextView getTvNombre() {
            return tvNombre;
        }
    }

    @Override
    public vhPokemon onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        view.setOnClickListener(this);
        vhPokemon vhp  = new vhPokemon(view);
        return vhp;
    }

    @Override
    public void onBindViewHolder(vhPokemon holder, int position) {
        holder.tvCodigo.setText(datos.get(position).getCodigo());
        holder.tvNombre.setText(datos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }

    }
}
