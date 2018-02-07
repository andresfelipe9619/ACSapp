package com.example.hp.acsapp.emergencia;

import android.content.Context;

import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.datasource.model.Ciudad;
import com.example.hp.acsapp.datasource.sqlite.controllers.CentroEmergenciaController;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public class EmergenciaPresenter implements EmergenciaContract.Presenter{

    private EmergenciaContract.View vistaEmergencias;
    private CentroEmergenciaController mController;

    public EmergenciaPresenter(EmergenciaContract.View vistaEmergencias) {
        this.vistaEmergencias = vistaEmergencias;
        //mController = new CentroEmergenciaController();
        vistaEmergencias.setPresenter(this);
    }

    @Override
    public void start() {
        loadCentrosEmergencia();
    }

    @Override
    public void loadLocalEmergencias(Ciudad ciudad) {

    }

    @Override
    public void loadCentrosEmergencia() {

        try {
            List<CentroEmergencia> centrosListos = mController.listar_centros();
            proccessEmergencias(centrosListos);

        }catch (Exception e){

        }
    }

    public void proccessEmergencias(List<CentroEmergencia> centros){
        if(centros.isEmpty()){
            vistaEmergencias.showNoCentrosEmergencia();
        }else{
            vistaEmergencias.showCentrosEmergencia(centros);
        }
    }

    @Override
    public void openMapsOption(String direccion) {

    }

    @Override
    public void openCallOption(int celnumber) {

    }

    @Override
    public void openCentroEmergenciaDetail(CentroEmergencia centro) {

    }

    @Override
    public void openLocalCountryCentros(List<CentroEmergencia> centros) {

    }
}
