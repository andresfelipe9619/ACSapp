package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_DIRECCION;
import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.ACSDatabase.COLUMNA_TELEFONO;

/**
 * Created by camilojcr on 25/01/18.
 */


public class CentroEmergencia {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;

    public CentroEmergencia(int id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public CentroEmergencia(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int insert(Context context){

        int newRowId;

        ACSDatabase db = new ACSDatabase(context);

        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_NOMBRE, this.getNombre());
        values.put(COLUMNA_TELEFONO, this.getTelefono());
        values.put(COLUMNA_DIRECCION, this.getDireccion());

        newRowId = db.insert_record(ACSDatabase.TABLA_CENTROS_EMERGENCIA, values);
        return newRowId;

    }
}
