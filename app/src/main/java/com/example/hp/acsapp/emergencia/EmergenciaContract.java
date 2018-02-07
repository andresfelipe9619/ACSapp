package com.example.hp.acsapp.emergencia;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;
import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.datasource.model.Ciudad;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public interface EmergenciaContract {

    interface View extends BaseView<Presenter> {
        void showLocalEmergencias(List<CentroEmergencia> centros);
        void showCentroEmergenciaDetail(String centro);
        void showCallOption();
        void showMapsOption();
        void showNotFoundLocalCentros();
        void showLocalCountryCentros();
        void showNoCentrosEmergencia();
        void showCentrosEmergencia(List<CentroEmergencia> centros);
    }

    interface Presenter extends BasePresenter {
        void loadLocalEmergencias(Ciudad ciudad);
        void loadCentrosEmergencia();
        void openMapsOption(String direccion);
        void openCallOption(int celnumber);
        void openCentroEmergenciaDetail(CentroEmergencia centro);
        void openLocalCountryCentros(List<CentroEmergencia> centros);


    }
}
