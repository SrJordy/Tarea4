package com.example.tarea4.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.tarea4.Adaptador.Adaptador_Imagen;
import com.example.tarea4.Adaptador.Adaptador_Productos;
import com.example.tarea4.Models.Productos;
import com.example.tarea4.R;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;

public class imagenlista extends AppCompatActivity {
    RecyclerView reci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenlista);
        Bundle b=this.getIntent().getExtras();
        reci=(RecyclerView) findViewById(R.id.lstimagen);
        reci.setHasFixedSize(true);
        reci.setLayoutManager(new GridLayoutManager(this,2));
        reci.setItemAnimator(new DefaultItemAnimator());
        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                resId);
        reci.setLayoutAnimation(animation);
        Adaptador_Imagen adaptada = new Adaptador_Imagen(this, b.getStringArrayList("IMAGENES"));
        reci.setAdapter(adaptada);
    }
}