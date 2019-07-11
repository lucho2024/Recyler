package com.example.recyler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolderdatos>{
    ArrayList<String> listaDatos;

    public adaptador(ArrayList<String> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolderdatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_list,null,false);

        return new ViewHolderdatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderdatos holder, int position) {
        Picasso
                .get()
                .load(listaDatos.get(position))
                .into( holder.manga_pic );
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderdatos extends RecyclerView.ViewHolder {
        ImageView manga_pic;
        public ViewHolderdatos(@NonNull View itemView) {
            super(itemView);
            manga_pic = itemView.findViewById( R.id.manga_pic );
        }
    }

}
