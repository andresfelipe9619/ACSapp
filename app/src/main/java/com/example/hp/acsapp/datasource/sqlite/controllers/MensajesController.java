package com.example.hp.acsapp.datasource.sqlite.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.hp.acsapp.datasource.model.MensajeMotivacional;
import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_AUTOR;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_TITULO;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_MENSAJES;

/**
 * Created by camilojcr on 3/02/18.
 */

public class MensajesController {

    private ACSDatabase db;
    Context context;
    private static final String TAG = MensajesController.class.getSimpleName();

    public MensajesController(Context Mcontext) {
        this.context = Mcontext;
        this.db = new ACSDatabase(context);
    }

    public ArrayList<MensajeMotivacional> listar_mensajes(){

        ArrayList<MensajeMotivacional> mensajes = new ArrayList<>();

        String query = "SELECT * FROM " + TABLA_MENSAJES;
        Cursor resultado = db.get_records(query, null);

        try {
            while (resultado.moveToNext()) {
//                String id = resultado.getString(0);
//                String titulo = resultado.getString(1);
//                String descripcion = resultado.getString(2);
//                String autor = resultado.getString(3);
//                MensajeMotivacional mensaje = new MensajeMotivacional(id, titulo,descripcion,autor);
                String mensaje = "0: " + resultado.getString(0);
                mensaje += "1: " + resultado.getString(1);
                mensaje += "2: " + resultado.getString(2);
                mensaje += "3: " + resultado.getString(3);
                Log.d(TAG, mensaje);
            }
        } finally {
            resultado.close();
        }

        return mensajes;
    };

    public boolean insert(MensajeMotivacional mensaje){

        boolean newRowId;

        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_TITULO, mensaje.getTitulo());
        values.put(COLUMNA_DESCRIPCION, mensaje.getDescripcion());
        values.put(COLUMNA_AUTOR, mensaje.getAutor());

        newRowId = db.insert_record(TABLA_MENSAJES, values);
        return newRowId;

    }

    public MensajeMotivacional getMotivacionDetail (int id){

        String query = "SELECT * FROM " + TABLA_MENSAJES;
        Cursor resultado = db.get_records(query, null);
        //RECORRER CURSOR Y LLENAR OBJETO
        resultado.moveToFirst();
        String titulo = resultado.getString(0);
        String descripcion = resultado.getString(1);
        String autor = resultado.getString(2);

        MensajeMotivacional mensaje = new MensajeMotivacional(id, titulo,descripcion,autor);
        return mensaje;
    }
}
