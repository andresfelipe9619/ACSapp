package com.example.hp.acsapp.datasource.sqlite.controllers;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.datasource.model.Actividad;
import com.example.hp.acsapp.datasource.sqlite.DAO.DAOActividades;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_URL;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_ACTIVIDADES;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DESCRIPCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_URL;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_ACTIVIDADES;

/**
 * Created by camilojcr on 3/02/18.
 */

public class ActividadesController {

    private DAOActividades daoActividades;
    Context context;
    private static final String TAG = ActividadesController.class.getSimpleName();

    public ActividadesController(Context Mcontext) {
        this.context = Mcontext;
        this.daoActividades = new DAOActividades(context);
    }

    public boolean insert(Actividad actividad){
        return daoActividades.insert(actividad);
    }

    public ArrayList<Actividad> listar_actividades(){
        return daoActividades.listar_actividades();
    }




}
