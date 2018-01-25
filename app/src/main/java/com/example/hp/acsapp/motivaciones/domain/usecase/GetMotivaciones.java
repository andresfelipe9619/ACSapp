package com.example.hp.acsapp.motivaciones.domain.usecase;

import com.example.hp.acsapp.datasource.MotivacionRepository;

/**
 * Created by HP on 1/23/2018.
 */

public class GetMotivaciones {

    private final MotivacionRepository repositorioMotivacion;
    //private final Mensajes_motivacionales motivaciones;

    public GetMotivaciones(MotivacionRepository repositorio){
        repositorioMotivacion = repositorio;
    }

    public void execute(){
       // repositorioMotivacion.getMotivaciones();
    }



}
