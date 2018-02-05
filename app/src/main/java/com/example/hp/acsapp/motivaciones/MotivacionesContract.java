package com.example.hp.acsapp.motivaciones;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;
import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public interface MotivacionesContract {

    interface View extends BaseView<Presenter>{
        void showMotivaciones(List<MensajeMotivacional> mensajes);
        void showMotivacionDetail(String motivacionId);
        void showMotivacionSeen(String motivacionId);
        void showNoMotivaciones();
    }

    interface Presenter extends BasePresenter{
        void loadMotivaciones();
        void openMotivacionDetails(MensajeMotivacional motivacion);
        void setMotivacionSeen(MensajeMotivacional motivacion);

    }

}
