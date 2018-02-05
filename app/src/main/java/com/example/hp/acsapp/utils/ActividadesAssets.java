package com.example.hp.acsapp.utils;

import android.content.res.Resources;

import com.example.hp.acsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/31/2018.
 */

public class ActividadesAssets {

    private static  List<Integer> defaultActividades = new ArrayList<Integer>(){{
        add(R.drawable.corre_ico);
        add(R.drawable.cocina_ico);
        add(R.drawable.montarbici_ico);
        add(R.drawable.viajar_ico);
        add(R.drawable.lectura_ico);
        add(R.drawable.escuchamusica_ico);
        add(R.drawable.tocarinstrumento_ico);
    }};

    public static List<Integer> getDefaultActividades(){
        return defaultActividades;
    }



}
