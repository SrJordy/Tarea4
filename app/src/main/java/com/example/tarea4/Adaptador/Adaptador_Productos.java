package com.example.tarea4.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea4.Actividades.imagenlista;
import com.example.tarea4.Models.Productos;
import com.example.tarea4.R;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Productos extends RecyclerView.Adapter<Adaptador_Productos.produviewholder>{
    private Context ctx;
    private List<Productos> lstprodu;

    public Adaptador_Productos(Context mCtx, List<Productos> produs){
        this.lstprodu=produs;
        ctx=mCtx;
    }

    @NonNull
    @Override
    public produviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.lycontenedor, null);
        return new Adaptador_Productos.produviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull produviewholder holder, int position) {
        Productos produ=lstprodu.get(position);
        holder.titulo.setText(produ.getTitulo());
        holder.descripcion.setText(produ.getDescripcion());
        holder.precio.setText(produ.getPrecio());
        Glide.with(ctx).load(produ.getImagen()).into(holder.imagen);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, imagenlista.class);
                Bundle b = new Bundle();
                ArrayList<String> urlList = new ArrayList<>(produ.getUrl());
                b.putStringArrayList("IMAGENES", urlList);
                intent.putExtras(b);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstprodu.size();
    }

    class produviewholder extends RecyclerView.ViewHolder {
        TextView titulo, precio, descripcion;
        ImageView imagen;
        public produviewholder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.title);
            precio = itemView.findViewById(R.id.price);
            descripcion = itemView.findViewById(R.id.description);
            imagen = itemView.findViewById(R.id.image);
        }
    }
}
