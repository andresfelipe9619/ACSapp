package com.example.hp.acsapp.datasource.sqlite;

import android.content.ContentValues;
import android.content.Context;

import com.example.hp.acsapp.utils.ActividadesAssets;

import java.util.List;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;

/**
 * Created by camilojcr on 3/02/18.
 */

public class StartData {

    Context context;
    ACSDatabase db;
    List<Integer> assets;

    public StartData(Context context) {
        this.context = context;
        assets = ActividadesAssets.getDefaultActividades();
        this.db = new ACSDatabase(context);
        InsertMensajesError();
        InsertMensajes();
    }

    private void InsertMensajesError(){
        ContentValues errorBd = new ContentValues();

        errorBd.put("id", 0);
        errorBd.put("mensaje", "No se encuentran registros");

        db.insert_record("mensaje_error",errorBd);
    }

    private void InsertActividades(){

        ContentValues Actividad_0 = new ContentValues();

        Actividad_0.put(COLUMNA_NOMBRE, "Cocinar");
        Actividad_0.put(COLUMNA_DESCRIPCION, "");
        Actividad_0.put(COLUMNA_URL, String.valueOf(assets.get(0)));

        db.insert_record(TABLA_ACTIVIDADES,Actividad_0);

        ContentValues Actividad_1 = new ContentValues();

        Actividad_1.put(COLUMNA_NOMBRE, "Cocinar");
        Actividad_1.put(COLUMNA_DESCRIPCION, "");
        Actividad_1.put(COLUMNA_URL, String.valueOf(assets.get(1)));

        db.insert_record(TABLA_ACTIVIDADES,Actividad_1);

    }

    private void InsertMensajes(){

        ContentValues Mensaje_1 = new ContentValues();

        Mensaje_1.put(COLUMNA_TITULO, "PRUEBA 1");
        Mensaje_1.put(COLUMNA_DESCRIPCION, "No te mates");
        Mensaje_1.put(COLUMNA_AUTOR, "YO MIMSMO");

        db.insert_record(TABLA_MENSAJES, Mensaje_1);

        ContentValues Mensaje_2 = new ContentValues();

        Mensaje_2.put(COLUMNA_TITULO, "PRUEBA 2");
        Mensaje_2.put(COLUMNA_DESCRIPCION, "No wey");
        Mensaje_2.put(COLUMNA_AUTOR, "YO MIMSMO");

        db.insert_record(TABLA_MENSAJES, Mensaje_2);
    }

}
