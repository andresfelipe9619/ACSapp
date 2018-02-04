package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;

/**
 * Created by camilojcr on 25/01/18.
 */

public class VisualizaTecnica {

    private int id;
    private int id_tecnica;
    private int id_usuario;



    public VisualizaTecnica(int id, int id_tecnica, int id_usuario) {
        this.id = id;
        this.id_tecnica = id_tecnica;
        this.id_usuario = id_usuario;
    }

    public VisualizaTecnica(int id_tecnica, int id_usuario) {
        this.id_tecnica = id_tecnica;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tecnica() {
        return id_tecnica;
    }

    public void setId_tecnica(int id_tecnica) {
        this.id_tecnica = id_tecnica;
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
        values.put(COLUMNA_FK_USER, this.getId_usuario());
        values.put(COLUMNA_FK_TECNICAS, this.getId_tecnica());

        newRowId = db.insert_record(TABLA_VER_TECNICAS, values);
        return newRowId;

    }
}
