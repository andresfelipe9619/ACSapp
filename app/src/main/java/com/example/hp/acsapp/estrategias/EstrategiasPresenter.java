package com.example.hp.acsapp.estrategias;

/**
 * Created by HP on 1/9/2018.
 */

public class EstrategiasPresenter implements EstrategiasContract.Presenter {

    private EstrategiasContract.View vistaEstrategias;

    public EstrategiasPresenter(EstrategiasContract.View vistaEstrategias){
        this.vistaEstrategias = vistaEstrategias;
        this.vistaEstrategias.setPresenter(this);
    }

    @Override
    public void openMensajesMotivacionales() {

    }

    @Override
    public void openCentrosAtencion() {

    }

    @Override
    public void openTecnicasRelajacion() {
        vistaEstrategias.showTecnicasRelajacion();
    }

    @Override
    public void start() {
        loadEstrategias();
    }


    private void loadEstrategias(){
        vistaEstrategias.showEstrategias();
    }
}
