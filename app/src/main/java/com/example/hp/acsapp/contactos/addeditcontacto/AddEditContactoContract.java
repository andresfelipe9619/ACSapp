package com.example.hp.acsapp.contactos.addeditcontacto;

import com.example.hp.acsapp.BasePresenter;
import com.example.hp.acsapp.BaseView;

/**
 * Created by HP on 1/24/2018.
 */

public interface AddEditContactoContract {

    interface View extends BaseView<Presenter>{

        void showEmptyCotactoError();
        void setFriendlyName(String name);
        void setNumber(int celNumber);

    }

    interface Presenter extends BasePresenter{
        void saveContacto(String name, int celNumber);
        void cancelEditContacto();
    }

}
