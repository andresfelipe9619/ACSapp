package com.example.hp.acsapp.emergencia;

import android.content.Context;
import android.util.Log;

import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.datasource.model.Ciudad;
import com.example.hp.acsapp.datasource.sqlite.controllers.CentroEmergenciaController;
import com.example.hp.acsapp.motivaciones.MotivacionesPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public class EmergenciaPresenter implements EmergenciaContract.Presenter{
    private static final String TAG = MotivacionesPresenter.class.getSimpleName() ;

    private EmergenciaContract.View vistaEmergencias;
    private CentroEmergenciaController mController;

    public EmergenciaPresenter(EmergenciaContract.View view) {
        this.vistaEmergencias = view;
        //mController = new CentroEmergenciaController();
        vistaEmergencias.setPresenter(this);
    }

    @Override
    public void start() {
        Log.d(TAG,"PRESENTER EMERGENCIA S STARTED");
        loadCentrosEmergencia();
    }

    @Override
    public void loadLocalEmergencias(Ciudad ciudad) {

    }

    @Override
    public void loadCentrosEmergencia() {

        try {
            List<CentroEmergencia> centrosListos = new ArrayList<>();
            centrosListos.add(new CentroEmergencia("LINEA GRATUITA NACIONAL","141","####"));
            centrosListos.add(new CentroEmergencia("LINEA NACIONAL DE EMERGENCIAS", "123","####"));
            centrosListos.add(new CentroEmergencia("LINEA GRATUITA", "106","####"));
            proccessEmergencias(centrosListos);

        }catch (Exception e){

        }
    }

    public void proccessEmergencias(List<CentroEmergencia> centros){
        if(centros.isEmpty()){
            vistaEmergencias.showNoCentrosEmergencia();
        }else{
            Log.d(TAG,"SI hay CENTROS EMERGENCIA");

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
