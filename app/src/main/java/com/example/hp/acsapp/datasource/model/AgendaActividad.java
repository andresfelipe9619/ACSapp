package com.example.hp.acsapp.datasource.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;

/**
 * Created by camilojcr on 25/01/18.
 */

public class AgendaActividad {
    private int id;
    private int id_usuario;
    private int id_actividad;
    private String hora;
    private String fecha;
    private String lugar;

    public AgendaActividad(int id_usuario, int id_actividad, String hora, String lugar, String fecha) {
        this.id_usuario = id_usuario;
        this.id_actividad = id_actividad;
        this.hora = hora;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean insert(Context context){

        boolean newRowId;

        ACSDatabase db = new ACSDatabase(context);


        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_FK_USER, this.getId_usuario());
        values.put(COLUMNA_FK_ACTIVIDAD, this.getId_actividad());
        values.put(COLUMNA_HORA, this.getHora());
        values.put(COLUMNA_FECHA, this.getFecha());
        values.put(COLUMNA_LUGAR, this.getLugar());


        newRowId = db.insert_record(TABLA_AGENDA_ACTIVIDADES, values);
        return newRowId;

    }
}
