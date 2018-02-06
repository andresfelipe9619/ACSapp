package com.example.hp.acsapp.datasource.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_DIRECCION;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_ID;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_NOMBRE;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.COLUMNA_TELEFONO;
import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.TABLA_CENTROS_EMERGENCIA;

/**
 * Created by camilojcr on 4/02/18.
 */

public class DAOCentroEmergencia {
    private ACSDatabase db;
    Context context;

    public DAOCentroEmergencia(Context Mcontext) {
        this.context = Mcontext;
        this.db = new ACSDatabase(context);
    }

    public boolean insert(CentroEmergencia centro){
        ContentValues values = new ContentValues();

        values.put(COLUMNA_NOMBRE, centro.getNombre());
        values.put(COLUMNA_TELEFONO, centro.getTelefono());
        values.put(COLUMNA_DIRECCION, centro.getDireccion());

        return db.insert_record(TABLA_CENTROS_EMERGENCIA, values);
    }

    public ArrayList<CentroEmergencia> listar_centros(){
        ArrayList<CentroEmergencia> centros = new ArrayList<>();

        String query = "SELECT * FROM " + TABLA_CENTROS_EMERGENCIA + ";";

        Cursor resultado = db.get_records(query, null);

        try {
            while (resultado.moveToNext()) {
                String id = resultado.getString(0);
                String nombre = resultado.getString(1);
                String telefono = resultado.getString(2);
                String direccion = resultado.getString(3);

                CentroEmergencia centro = new CentroEmergencia(Integer.parseInt(id),nombre,telefono,direccion);
                centros.add(centro);
                //PRUEBA
//                String mensaje = "0: " + resultado.getString(0);
//                mensaje += "1: " + resultado.getString(1);
//                mensaje += "2: " + resultado.getString(2);
//                mensaje += "3: " + resultado.getString(3);
//                Log.d(TAG, mensaje);
            }
        } finally {
            resultado.close();
        }

        return centros;
    }

    public CentroEmergencia getCentroDetail(int id){

        String query = "SELECT * FROM " + TABLA_CENTROS_EMERGENCIA + " WHERE "+ COLUMNA_ID + " = " + id + ";";

        Cursor resultado = db.get_records(query, null);

        String nombre = resultado.getString(1);
        String telefono = resultado.getString(2);
        String direccion = resultado.getString(3);

        CentroEmergencia centro = new CentroEmergencia(id,nombre,telefono,direccion);

        return centro;
    }

    public boolean update(CentroEmergencia centro){
        ContentValues values = new ContentValues();

        values.put(COLUMNA_ID, centro.getId());
        values.put(COLUMNA_NOMBRE, centro.getNombre());
        values.put(COLUMNA_TELEFONO, centro.getTelefono());
        values.put(COLUMNA_DIRECCION, centro.getDireccion());

        return db.update_record(TABLA_CENTROS_EMERGENCIA, values);
    }

    public boolean delete(int id){
        return db.delete_record(TABLA_CENTROS_EMERGENCIA,id);
    }

}
