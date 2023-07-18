package com.example.tarea4.Models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Productos {
    String titulo;
    String descripcion;
    String imagen;
    List<String> url;
    String id;
    String precio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


  public Productos(JSONObject a) throws JSONException{
       titulo=a.getString("title");
       descripcion=a.getString("description");
       precio=a.getString("price");
       imagen=a.getString("thumbnail");
      JSONArray urlArray = a.getJSONArray("images");
      url = new ArrayList<>();
      for(int i=0; i<urlArray.length(); i++){
          url.add(urlArray.getString(i));
          Log.i("URL",urlArray.getString(i));
      }
  }
    public static ArrayList<Productos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Productos> produ = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            produ.add(new Productos(datos.getJSONObject(i)));
        }
        return produ;
    }

}
