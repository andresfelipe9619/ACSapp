package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_AUTOR;
import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_URL_RECURSO;
import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.TABLA_TECNICAS_RELAJACION;

/**
 * Created by camilojcr on 25/01/18.
 */

public class TecnicaRelajacion {

    private int id;
    private String nombre;
    private String autor;
    private String url_recurso;
    private String descripcion;

    public TecnicaRelajacion(int id, String nombre, String descripcion, String autor, String url_recurso) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.url_recurso = url_recurso;
        this.descripcion = descripcion;
    }

    public TecnicaRelajacion(String nombre, String descripcion, String autor, String url_recurso) {
        this.nombre = nombre;
        this.autor = autor;
        this.url_recurso = url_recurso;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUrl_recurso() {
        return url_recurso;
    }

    public void setUrl_recurso(String url_recurso) {
        this.url_recurso = url_recurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int insert(Context context){

        int newRowId;

        ACSDatabase db = new ACSDatabase(context);

        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_NOMBRE, this.getNombre());
        values.put(COLUMNA_DESCRIPCION, this.getDescripcion());
        values.put(COLUMNA_AUTOR, this.getAutor());
        values.put(COLUMNA_URL_RECURSO, this.getUrl_recurso());

        newRowId = db.insert_record(TABLA_TECNICAS_RELAJACION, values);
        return newRowId;

    }
}
