package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.ACSDatabase;

import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.ACSDatabase.TABLA_CIUDAD;

/**
 * Created by camilojcr on 25/01/18.
 */

public class Ciudad {

    private int id;
    private String nombre;

    public Ciudad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
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

    public int insert(Context context){

        int newRowId;

        ACSDatabase db = new ACSDatabase(context);


        ContentValues values = new ContentValues();
//      llenar valores
        values.put(COLUMNA_NOMBRE, this.getNombre());

        newRowId = db.insert_record(TABLA_CIUDAD, values);
        return newRowId;

    }
}
