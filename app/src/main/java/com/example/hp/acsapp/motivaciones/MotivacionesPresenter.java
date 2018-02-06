package com.example.hp.acsapp.motivaciones;

import android.content.Context;

import com.example.hp.acsapp.datasource.model.MensajeMotivacional;
import com.example.hp.acsapp.datasource.sqlite.controllers.MensajesController;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public class MotivacionesPresenter implements MotivacionesContract.Presenter {

    private final MotivacionesContract.View vistaMotivaciones;
    private final MensajesController mMensajesController;

    public MotivacionesPresenter(Context context, MotivacionesContract.View view) {
        vistaMotivaciones = view;
        mMensajesController  = new MensajesController(context);
        vistaMotivaciones.setPresenter(this);
    }

    @Override
    public void start() {
        loadMotivaciones();
    }

    @Override
    public void loadMotivaciones() {
       //vistaMotivaciones.showMotivaciones();
        // SE DEBE IMPLEMENTAR CALLBACK PARA EL ACCESO A LOS DATOS
        //ON DATA LOADED Y ON DATA NOT AVAILABLE
        try{
            List<MensajeMotivacional> mensajesListos =  mMensajesController.listar_mensajes();
            proccessMotivaciones(mensajesListos);
        }catch (Exception e){
            //vistaMotivacion.showLoadingError();
        }

    }

    @Override
    public void openMotivacionDetails(MensajeMotivacional motivacion) {

    }

    @Override
    public void setMotivacionSeen(MensajeMotivacional motivacion) {

    }

    private void proccessMotivaciones(List<MensajeMotivacional> mensajes){
        if(mensajes.isEmpty()){
            vistaMotivaciones.showNoMotivaciones();
        }else{
            vistaMotivaciones.showMotivaciones(mensajes);
        }
    }

}
