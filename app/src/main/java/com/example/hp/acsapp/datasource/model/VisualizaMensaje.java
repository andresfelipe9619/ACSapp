package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;

/**
 * Created by camilojcr on 25/01/18.
 */

public class VisualizaMensaje {

    private int id;
    private int id_mensaje;
    private int id_usuario;

    public VisualizaMensaje(int id, int id_mensaje, int id_usuario) {
        this.id = id;
        this.id_mensaje = id_mensaje;
        this.id_usuario = id_usuario;
    }

    public VisualizaMensaje(int id_mensaje, int id_usuario) {
        this.id_mensaje = id_mensaje;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean insert(Context context){

        boolean newRowId;

        ACSDatabase db = new ACSDatabase(context);


        ContentValues values = new ContentValues();
//      llenar valores
        values.put(COLUMNA_FK_MENSAJES, this.getId_mensaje());
        values.put(COLUMNA_FK_USER, this.getId_usuario());

        newRowId = db.insert_record(TABLA_VER_MENSAJES, values);
        return newRowId;

    }
}
