package com.example.hp.acsapp.datasource.sqlite.controllers;

import android.content.Context;

import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.datasource.sqlite.DAO.DAOCentroEmergencia;

import java.util.ArrayList;

/**
 * Created by camilojcr on 4/02/18.
 */

public class CentroEmergenciaController {
    private DAOCentroEmergencia daoCentroEmergencia;
    Context context;

    public CentroEmergenciaController(Context context) {
        this.context = context;
        this.daoCentroEmergencia = new DAOCentroEmergencia(context);
    }

    public boolean insert(CentroEmergencia centro){
        return daoCentroEmergencia.insert(centro);
    }

    public ArrayList<CentroEmergencia> listar_centros(){
        return daoCentroEmergencia.listar_centros();
    }

    public CentroEmergencia getCentroDetail(int id){
        return daoCentroEmergencia.getCentroDetail(id);
    }

    public boolean update(CentroEmergencia centro){
        return daoCentroEmergencia.update(centro);
    }

    public boolean delete(int id){
        return daoCentroEmergencia.delete(id);
    }
}
