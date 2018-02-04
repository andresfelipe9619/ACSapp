package com.example.hp.acsapp.actividades;

/**
 * Created by HP on 1/9/2018.
 */

public class ActividadesPresenter implements ActividadesContract.Presenter{

    private final ActividadesContract.View vistaActividades;

    public ActividadesPresenter(ActividadesContract.View view){
        vistaActividades = view;
    }
    @Override
    public void start() {
        vistaActividades.setPresenter(this);
    }

    @Override
    public void openActividadDetail() {

    }

    @Override
    public void openAddActividad() {

    }

    @Override
    public void loadBaseActividades() {
        //    vistaActividades.showBaseActividades();
    }

    @Override
    public void loadUserActividaes() {

    }
}
