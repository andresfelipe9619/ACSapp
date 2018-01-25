package com.example.hp.acsapp.contactos;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;

/**
 * Created by HP on 1/24/2018.
 */

public interface ContactoContract {
    interface Presenter extends BasePresenter{
       void AddNewContacto();
       void showContactoDetail();
    }

    interface View extends BaseView<Presenter>{
        void openAddContacto();
        void openContactoDetail();
    }
}
