package com.example.hp.acsapp.datasource;

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
    }};

    public static List<Integer> getDefaultActividades(){
        return defaultActividades;
    }



}
