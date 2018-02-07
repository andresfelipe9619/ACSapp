package com.example.hp.acsapp.datasource.sqlite.controllers;

import com.example.hp.acsapp.datasource.model.CentroEmergencia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by camilojcr on 4/02/18.
 */

public class CentroEmergenciaController {

    public CentroEmergenciaController() {

    }

    public List<CentroEmergencia> listar_centros(){
        List<CentroEmergencia> centros = new ArrayList<>();
                centros.add(new CentroEmergencia("la 14", "322222", "calle 15"));
                centros.add(new CentroEmergencia("la 14", "322222", "calle 15"));
        return  centros;
    }
}
