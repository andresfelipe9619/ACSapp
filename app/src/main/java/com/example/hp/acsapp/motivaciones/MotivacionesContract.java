package com.example.hp.acsapp.motivaciones;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;
import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

/**
 * Created by HP on 1/9/2018.
 */

public interface MotivacionesContract {

    interface View extends BaseView<Presenter>{
        void showMotivaciones();
        void showMotivacionDetail(String motivacionId);
        void showMotivacionSeen(String motivacionId);
    }

    interface Presenter extends BasePresenter{
        void loadMotivaciones();
        void openMotivacionDetails(MensajeMotivacional motivacion);
        void setMotivacionSeen(MensajeMotivacional motivacion);

    }

}
