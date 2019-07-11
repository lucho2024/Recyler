package com.example.recyler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptador2  extends RecyclerView.Adapter<adaptador2.ViewHolderdatos> {

    ArrayList<String> listDePortada;

    public adaptador2(ArrayList<String> listDePortada) {
        this.listDePortada = listDePortada;
    }


    @NonNull
    @Override
    //se llama a los componentes de la interfaz
    public ViewHolderdatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist2,null,false);

        return new adaptador2.ViewHolderdatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderdatos holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listDePortada.size();
    }

    public class ViewHolderdatos extends RecyclerView.ViewHolder {
        Im
        public ViewHolderdatos(@NonNull View itemView) {
            super(itemView);
        }

    }
}
