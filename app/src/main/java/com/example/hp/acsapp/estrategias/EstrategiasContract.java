package com.example.hp.acsapp.estrategias;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;

/**
 * Created by HP on 1/9/2018.
 */

public interface EstrategiasContract {
    interface View extends BaseView<Presenter>{
        void showMensajesMotivacionales();
        void showCentrosAtencion();
        void showTecnicasRelajacion();
        void showEstrategias();
    }
    interface Presenter extends BasePresenter{
        void openMensajesMotivacionales();
        void openCentrosAtencion();
        void openTecnicasRelajacion();
    }
}
