package com.example.tarea4.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea4.Models.Productos;
import com.example.tarea4.R;

import java.util.List;

public class Adaptador_Imagen extends RecyclerView.Adapter<Adaptador_Imagen.imagenviewholder>{
    private Context ctx;
    String produ;
    private List<String> lstImagenes;
    public  Adaptador_Imagen(Context mCtx, List<String> imagen){
        this.lstImagenes=imagen;
        ctx=mCtx;
    }

    @NonNull
    @Override
    public imagenviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.lyimagenes, null);
        return new Adaptador_Imagen.imagenviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imagenviewholder holder, int position) {
        produ=lstImagenes.get(position);
        Glide.with(ctx).load(produ).into(holder.imagen);
    }
    @Override
    public int getItemCount() {
        return lstImagenes.size();
    }
    class imagenviewholder extends RecyclerView.ViewHolder {
        ImageView imagen;
        public imagenviewholder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenes);
        }
    }
}
