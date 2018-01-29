package com.example.hp.acsapp.actividades;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;
import com.example.hp.acsapp.datasource.model.Actividad;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public interface ActividadesContract {

    interface View extends BaseView<Presenter>{
        void showAddActividad();
        void showActividadDetail(String actividadId);
        void showBaseActividades(List<Actividad> actividades);
        void showUserActividades(List<Actividad> actividads);
        void showNoUserActividades();

        void showActividadMarkedComplete();

    }

    interface Presenter extends BasePresenter{
        void openActividadDetail();
        void openAddActividad();
        void loadBaseActividades();
        void loadUserActividaes();


    }
}
