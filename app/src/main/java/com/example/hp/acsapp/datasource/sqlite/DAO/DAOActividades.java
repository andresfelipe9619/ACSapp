package com.example.hp.acsapp.datasource.sqlite.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.hp.acsapp.datasource.model.Actividad;
import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_ID;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_URL;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_ACTIVIDADES;

/**
 * Created by camilojcr on 4/02/18.
 */

public class DAOActividades {

    private ACSDatabase db;
    Context context;

    public DAOActividades(Context Mcontext) {
        this.context = Mcontext;
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

    public ArrayList<Actividad> listar_actividades(){
        ArrayList<Actividad> actividades = new ArrayList<>();

        String query = "SELECT * FROM "+ TABLA_ACTIVIDADES;
        Cursor resultado = db.get_records(query, null);

        try {
            while (resultado.moveToNext()) {
                String id = resultado.getString(0);
                String nombre = resultado.getString(1);
                String descripcion = resultado.getString(2);
                String url = resultado.getString(3);
                Actividad actividad = new Actividad(Integer.parseInt(id),nombre,descripcion,url);
                actividades.add(actividad);
            }
        } finally {
            resultado.close();
        }

        return actividades;
    }

    public Actividad getActividadDetail(int id){

        String query = "SELECT * FROM " + TABLA_ACTIVIDADES + " WHERE "+ COLUMNA_ID + " = " + id + ";";
        Cursor resultado = db.get_records(query, null);
        resultado.moveToFirst();

        String nombre = resultado.getString(1);
        String descripcion = resultado.getString(2);
        String url = resultado.getString(3);

        Actividad actividad = new Actividad(id, nombre,descripcion,url);
        return actividad;

    }

    public boolean update(Actividad actividad){
        ContentValues values = new ContentValues();
        values.put(COLUMNA_ID, actividad.getId());
        values.put(COLUMNA_NOMBRE, actividad.getNombre());
        values.put(COLUMNA_DESCRIPCION, actividad.getDescripcion());
        values.put(COLUMNA_URL, actividad.getIcon_url());

        return db.update_record(TABLA_ACTIVIDADES, values);
    }

    public boolean delete(int id){
        return db.delete_record(TABLA_ACTIVIDADES, id);
    }

}
