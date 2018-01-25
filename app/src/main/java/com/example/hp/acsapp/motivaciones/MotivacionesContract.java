package com.example.hp.acsapp.motivaciones;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;
import com.example.hp.acsapp.motivaciones.domain.model.Motivacion;

import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public interface MotivacionesContract {

    interface View extends BaseView<Presenter>{
        void showMotivaciones();

    }

    interface Presenter extends BasePresenter{
        void loadMotivaciones();
      //  void openMotivacionDetails(Motivacion motivacion);

    }

}
