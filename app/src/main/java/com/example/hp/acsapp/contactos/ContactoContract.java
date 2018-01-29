package com.example.hp.acsapp.contactos;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;
import com.example.hp.acsapp.datasource.model.Contacto;

import java.util.List;

/**
 * Created by HP on 1/24/2018.
 */

public interface ContactoContract {
    interface Presenter extends BasePresenter{
        void openAddContacto();
        void openContactoDetail(Contacto contacto);
        void loadContactos();
        void openCalling();
    }

    interface View extends BaseView<Presenter>{
        void showAddContacto();
        void showContactoDetail(String contactoId);
        void showCallingState();
        void showContactos(List<Contacto> contactos);
        void showSuccesfullySaved();
    }
}
