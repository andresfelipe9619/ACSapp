package com.example.hp.acsapp.estrategias;

/**
 * Created by HP on 1/9/2018.
 */

public class EstrategiasPresenter implements EstrategiasContract.Presenter {

    private EstrategiasContract.View vistaEstrategias;

    public EstrategiasPresenter(EstrategiasContract.View vistaEstrategias){
        this.vistaEstrategias = vistaEstrategias;
    }

    @Override
    public void openMensajesMotivacionales() {
        vistaEstrategias.showMensajesMotivacionales();
    }

    @Override
    public void openCentrosAtencion() {

    }

    @Override
    public void start() {
        vistaEstrategias.setPresenter(this);
    }

    @Override
    public void openTecnicasRelajacion() {
        vistaEstrategias.showTecnicasRelajacion();
    }

}
