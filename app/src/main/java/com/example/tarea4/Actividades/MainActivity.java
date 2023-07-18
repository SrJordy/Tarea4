package com.example.tarea4.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.tarea4.Adaptador.Adaptador_Productos;
import com.example.tarea4.Models.Productos;
import com.example.tarea4.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView reci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lylistaprodu);
        reci=(RecyclerView) findViewById(R.id.lstimagen);
        reci.setHasFixedSize(true);
        reci.setLayoutManager(new LinearLayoutManager(this));
        reci.setItemAnimator(new DefaultItemAnimator());
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://dummyjson.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        ArrayList<Productos> lstProdu = new ArrayList<Productos> ();
        try {
            //PARSEP
            JSONObject JSONlista = new JSONObject(result);
            JSONArray JSONlistaprodu= JSONlista.getJSONArray("products");
            lstProdu = Productos.JsonObjectsBuild(JSONlistaprodu);
            //FIN DEL PARSEO

            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                    resId);
            reci.setLayoutAnimation(animation);
            Adaptador_Productos adaptada = new Adaptador_Productos(this, lstProdu);
            reci.setAdapter(adaptada);
        }
        catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}