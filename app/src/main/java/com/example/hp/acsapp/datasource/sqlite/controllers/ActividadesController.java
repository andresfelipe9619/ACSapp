package com.example.hp.acsapp.datasource.sqlite.controllers;

import android.content.Context;

import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

/**
 * Created by camilojcr on 3/02/18.
 */

public class ActividadesController {

    private ACSDatabase db;
    Context context;
    private static final String TAG = ActividadesController.class.getSimpleName();

    public ActividadesController(Context context) {
        this.context = context;
        this.db = new ACSDatabase(context);
    }
}
