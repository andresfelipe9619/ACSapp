package com.example.hp.acsapp.datasource.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

import java.util.ArrayList;

import static com.example.hp.acsapp.datasource.sqlite.DatabaseTables.*;

/**
 * Created by camilojcr on 24/01/18.
 */

public class ACSDatabase extends SQLiteOpenHelper {
    //define db
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ACSDatabase.db";
    Context context;
    private static final String TAG = ACSDatabase.class.getSimpleName();

    //Constructor
    public ACSDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "ANTES DE EXECT EN ONCREATE");
        sqLiteDatabase.execSQL(SQL_CREATE_USUARIO);
        sqLiteDatabase.execSQL(SQL_CREATE_AGENDA);
        sqLiteDatabase.execSQL(SQL_CREATE_MENSAJES);
        sqLiteDatabase.execSQL(SQL_CREATE_TECNICAS);
        sqLiteDatabase.execSQL(SQL_CREATE_CENTROS);
        sqLiteDatabase.execSQL(SQL_CREATE_CIUDAD);
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTOS);
        sqLiteDatabase.execSQL(SQL_CREATE_VER_MENSAJES);
        sqLiteDatabase.execSQL(SQL_CREATE_VER_TECNICAS);
        sqLiteDatabase.execSQL(SQL_CREATE_MENSAJES_ERROR);
        sqLiteDatabase.execSQL(SQL_CREATE_ACTIVIDADES);
//

        Log.d(TAG, SQL_CREATE_USUARIO);
        Log.d(TAG, SQL_CREATE_MENSAJES);

        //StartData data = new StartData(context);
        ContentValues Mensaje_1 = new ContentValues();

        Mensaje_1.put(COLUMNA_TITULO, "PRUEBA 1");
        Mensaje_1.put(COLUMNA_DESCRIPCION, "No te mates");
        Mensaje_1.put(COLUMNA_AUTOR, "YO MIMSMO");
        Log.d(TAG, "ANTES");
        sqLiteDatabase.insert(TABLA_MENSAJES,null,Mensaje_1);

//        if(insert_record(TABLA_MENSAJES, Mensaje_1)){
//            Log.d(TAG, "SI");
//        }else{
//            Log.d(TAG, "NO");
//
//        };
        Log.d(TAG, "DESPUES");

        ContentValues Mensaje_2 = new ContentValues();

        Mensaje_2.put(COLUMNA_TITULO, "PRUEBA 2");
        Mensaje_2.put(COLUMNA_DESCRIPCION, "No wey");
        Mensaje_2.put(COLUMNA_AUTOR, "YO MIMSMO");

        sqLiteDatabase.insert(TABLA_MENSAJES,null,Mensaje_2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //Metodos de manejo de base de datos

    public boolean insert_record(String nombreTabla, ContentValues values) {
        long newRowId;
        Log.d(TAG, "ANTES EN INSERTRECORD");

        SQLiteDatabase database = this.getWritableDatabase();
        Log.d(TAG, "DESPUES EN INSERTRECORD");

        newRowId = database.insert(nombreTabla, null, values);
        //database.close();
        if (newRowId == -1) {
            Log.d(TAG, "failed to save data!");
            //
            return false;
        } else {
            Log.d(TAG, "save data successful");
            //database.close();
            return true;
        }

    }

   /* public ArrayList<MensajeMotivacional> listar_mensajes(){

        ArrayList<MensajeMotivacional> mensajes = new ArrayList<>();
//
        String query = "SELECT * FROM " + TABLA_MENSAJES + ";";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor resultado = database.rawQuery(query, null);

         while (resultado.moveToNext()) {
                String id = resultado.getString(0);
                String titulo = resultado.getString(1);
                String descripcion = resultado.getString(2);
                String autor = resultado.getString(3);
                MensajeMotivacional mensaje = new MensajeMotivacional(Integer.parseInt(id), titulo,descripcion,autor);
                mensajes.add(mensaje);
//                //PRUEBA
////                String mensaje = "0: " + resultado.getString(0);
////                mensaje += "1: " + resultado.getString(1);
////                mensaje += "2: " + resultado.getString(2);
////                mensaje += "3: " + resultado.getString(3);
////                Log.d(TAG, mensaje);
         }


        return mensajes;
    }
*/
    public Cursor get_records(String query, String[] args) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor retorno = database.rawQuery(query, args);
//        database.close();
        if (retorno != null) {
          //  database.close();
            return retorno;
        } else {
            retorno = database.rawQuery("SELECT mensaje FROM mensaje_error WHERE id = 0", null);
           // database.close();
            return retorno;
        }
    }

    public boolean update_record(String tabla, ContentValues values) {

        SQLiteDatabase database = this.getReadableDatabase();

        int i = database.update(tabla, values, COLUMNA_ID + " = ?", new String[]{String.valueOf(values.get(COLUMNA_ID))});

        database.close();

        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean delete_record(String tabla, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(tabla,
                    " _id = ?",
                    new String[] { String.valueOf (id) });
            db.close();
            return true;

        }catch(Exception ex){
            return false;
        }
    }
}
