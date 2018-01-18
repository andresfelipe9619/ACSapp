package com.example.hp.acsapp;

/**
 * Created by HP on 1/9/2018.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
