package com.example.hp.acsapp.motivaciones;

import com.example.hp.acsapp.motivaciones.domain.model.Motivacion;
import com.example.hp.acsapp.motivaciones.domain.usecase.GetMotivaciones;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public class MotivacionesPresenter implements MotivacionesContract.Presenter {

    private final MotivacionesContract.View vistaMotivaciones;
//    private final GetMotivaciones getMotivaciones;

    public MotivacionesPresenter(MotivacionesContract.View view) {
        vistaMotivaciones = view;
//        this.getMotivaciones = getMotivaciones;
    }

    @Override
    public void start() {
        vistaMotivaciones.setPresenter(this);
    }

    @Override
    public void loadMotivaciones() {
        //List<Motivacion> motivaciones = getMotivaciones.execute();
       // proccessMotivaciones(motivaciones);
       // vistaMotivaciones.showMotivaciones();
    }


//    private void proccessMotivaciones(List<Motivacion> motivaciones) {
//        if (motivaciones.isEmpty()) {
//            // Show a message indicating there are no motivaciones for that filter type.
//            processEmptyMotivaciones();
//        } else {
//            // Show the list of motivaciones
//            vistaMotivaciones.showMotivaciones(motivaciones);
//        }
//
//    }

    private void processEmptyMotivaciones() {


    }
}
