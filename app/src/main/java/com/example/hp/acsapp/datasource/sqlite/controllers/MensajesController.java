package com.example.hp.acsapp.datasource.sqlite.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.hp.acsapp.datasource.model.MensajeMotivacional;
import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;
import com.example.hp.acsapp.datasource.sqlite.DAO.DAOMensajes;

import java.util.ArrayList;
import java.util.List;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_AUTOR;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_TITULO;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_MENSAJES;

/**
 * Created by camilojcr on 3/02/18.
 */

public class MensajesController {

    private DAOMensajes daoMensajes;
    Context context;
    private static final String TAG = MensajesController.class.getSimpleName();

    public MensajesController(Context Mcontext) {
        this.context = Mcontext;
        this.daoMensajes = new DAOMensajes(context);
    }

    public List<MensajeMotivacional> listar_mensajes(){
//        return daoMensajes.listar_mensajes();
    List<MensajeMotivacional> mensajes = new ArrayList<>();
    mensajes.add(new MensajeMotivacional(5,"hola","MUNDO","acs"));
    return mensajes;
    }

    public boolean insert(MensajeMotivacional mensaje) {
        return daoMensajes.insert(mensaje);
    }

    public MensajeMotivacional getMotivacionDetail (int id){
        return daoMensajes.getMotivacionDetail(id);
    }

    public boolean update(MensajeMotivacional mensaje){
        return daoMensajes.update(mensaje);
    }

    public boolean delete(int id){
        return daoMensajes.delete(id);
    }
}
