package com.example.hp.acsapp.datasource.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.hp.acsapp.datasource.model.MensajeMotivacional;
import com.example.hp.acsapp.datasource.sqlite.ACSDatabase;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;


/**
 * Created by camilojcr on 4/02/18.
 */

public class DAOMensajes {

    private ACSDatabase db;
    Context context;

    public DAOMensajes(Context Mcontext) {
        this.context = Mcontext;
        this.db = new ACSDatabase(context);
    }

    public boolean insert(MensajeMotivacional mensaje){
        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_TITULO, mensaje.getTitulo());
        values.put(COLUMNA_DESCRIPCION, mensaje.getDescripcion());
        values.put(COLUMNA_AUTOR, mensaje.getAutor());
        boolean result = db.insert_record(TABLA_MENSAJES, values);

       return result;
    }

    public ArrayList<MensajeMotivacional> listar_mensajes(){

        ArrayList<MensajeMotivacional> mensajes = new ArrayList<>();

        //mensajes = db.listar_mensajes();
        String query = "SELECT * FROM " + TABLA_MENSAJES + ";";
        Cursor resultado = db.get_records(query, null);

         while (resultado.moveToNext()) {
                String id = resultado.getString(0);
                String titulo = resultado.getString(1);
                String descripcion = resultado.getString(2);
                String autor = resultado.getString(3);
                MensajeMotivacional mensaje = new MensajeMotivacional(Integer.parseInt(id), titulo,descripcion,autor);
                mensajes.add(mensaje);
                //PRUEBA
//                String mensaje = "0: " + resultado.getString(0);
//                mensaje += "1: " + resultado.getString(1);
//                mensaje += "2: " + resultado.getString(2);
//                mensaje += "3: " + resultado.getString(3);
//                Log.d(TAG, mensaje);
         }


        return mensajes;
    }

    public MensajeMotivacional getMotivacionDetail (int id){

        String query = "SELECT * FROM " + TABLA_MENSAJES + " WHERE "+ COLUMNA_ID + " = " + id + ";";
        Cursor resultado = db.get_records(query, null);
        //RECORRER CURSOR Y LLENAR OBJETO
        resultado.moveToFirst();
        String titulo = resultado.getString(0);
        String descripcion = resultado.getString(1);
        String autor = resultado.getString(2);

        MensajeMotivacional mensaje = new MensajeMotivacional(id, titulo,descripcion,autor);
        return mensaje;
    }

    public boolean update(MensajeMotivacional mensaje){
        ContentValues values = new ContentValues();
//      llenar valores

        values.put(COLUMNA_ID, mensaje.getId());
        values.put(COLUMNA_TITULO, mensaje.getTitulo());
        values.put(COLUMNA_DESCRIPCION, mensaje.getDescripcion());
        values.put(COLUMNA_AUTOR, mensaje.getAutor());

        boolean retorno = db.update_record(TABLA_MENSAJES, values);
        return retorno;
    }

    public boolean delete(int id){
        boolean retorno = db.delete_record(TABLA_MENSAJES, id);
        return retorno;
    }

}
