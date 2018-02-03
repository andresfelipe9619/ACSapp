package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_AUTOR;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_TITULO;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_MENSAJES;

/**
 * Created by HP on 1/23/2018.
 */

public final class MensajeMotivacional {

    private int id;
    private  String titulo;
    private  String descripcion;
    private String autor;

    public MensajeMotivacional(int id, String titulo, String descripcion, String autor){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public MensajeMotivacional(String titulo, String descripcion, String autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
    }



    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
