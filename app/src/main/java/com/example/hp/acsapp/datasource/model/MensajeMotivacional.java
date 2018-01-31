package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.ACSDatabase;

import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_AUTOR;
import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_TITULO;
import static com.example.hp.acsapp.datasource.ACSDatabase.TABLA_MENSAJES;

/**
 * Created by HP on 1/23/2018.
 */

public final class MensajeMotivacional {

    private final String id;
    private final String titulo;
    private final String descripcion;
    private final String autor;


    public MensajeMotivacional(String id, String titulo, String descripcion, String autor){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int insert(Context context){

        int newRowId;

        ACSDatabase db = new ACSDatabase(context);

        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_TITULO, this.getTitulo());
        values.put(COLUMNA_DESCRIPCION, this.getDescripcion());
        values.put(COLUMNA_AUTOR, this.getAutor());

        newRowId = db.insert_record(TABLA_MENSAJES, values);
        return newRowId;

    }
}
