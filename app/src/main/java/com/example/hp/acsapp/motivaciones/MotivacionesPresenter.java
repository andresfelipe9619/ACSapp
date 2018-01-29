package com.example.hp.acsapp.motivaciones;

import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

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
        //List<MensajeMotivacional> motivaciones = getMotivaciones.execute();
       // proccessMotivaciones(motivaciones);
       vistaMotivaciones.showMotivaciones();
    }

    @Override
    public void openMotivacionDetails(MensajeMotivacional motivacion) {

    }

    @Override
    public void setMotivacionSeen(MensajeMotivacional motivacion) {

    }


//    private void proccessMotivaciones(List<MensajeMotivacional> motivaciones) {
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
