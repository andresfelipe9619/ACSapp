package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;

/**
 * Created by HP on 1/9/2018.
 */

public class Actividad {

    private int id;
    private String nombre;
    private String descripcion;
    private String icon_url;

    public Actividad(int id, String nombre, String descripcion, String icon_url) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icon_url = icon_url;
    }

    public Actividad(String nombre, String descripcion, String icon_url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icon_url = icon_url;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }


}
