package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.ACSDatabase;

import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_FK_USER;
import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.ACSDatabase.COLUMNA_TELEFONO;
import static com.example.hp.acsapp.datasource.ACSDatabase.TABLA_CIUDAD;
import static com.example.hp.acsapp.datasource.ACSDatabase.TABLA_CONTACTOS;

/**
 * Created by camilojcr on 25/01/18.
 */

public class Contacto {

    private int id;
    private String nombre;
    private String telefono;
    private Usuario user;

    public Contacto(int id, String nombre, String telefono, Usuario user) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.user = user;
    }

    public Contacto(String nombre, String telefono, Usuario user) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.user = user;
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public int insert(Context context){

        int newRowId;

        ACSDatabase db = new ACSDatabase(context);


        ContentValues values = new ContentValues();
//      llenar valores
        values.put(COLUMNA_NOMBRE, this.getNombre());
        values.put(COLUMNA_TELEFONO, this.getTelefono());
        values.put(COLUMNA_FK_USER, this.getUser().getId());

        newRowId = db.insert_record(TABLA_CONTACTOS, values);
        return newRowId;

    }
}
