package com.example.hp.acsapp.datasource.sqlite.controllers;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.model.Actividad;
import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_URL;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_ACTIVIDADES;

/**
 * Created by camilojcr on 3/02/18.
 */

public class ActividadesController {

    private ACSDatabase db;
    Context context;
    private static final String TAG = ActividadesController.class.getSimpleName();

    public ActividadesController(Context context) {
        this.context = context;
        this.db = new ACSDatabase(context);
    }

    public boolean insert(Actividad actividad){

        boolean newRowId;

        ContentValues values = new ContentValues();

        values.put(COLUMNA_NOMBRE, actividad.getNombre());
        values.put(COLUMNA_DESCRIPCION, actividad.getDescripcion());
        values.put(COLUMNA_URL, actividad.getIcon_url());

        newRowId = db.insert_record(TABLA_ACTIVIDADES, values);
        return newRowId;

    }
}
