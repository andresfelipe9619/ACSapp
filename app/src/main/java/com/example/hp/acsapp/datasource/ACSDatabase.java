package com.example.hp.acsapp.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hp.acsapp.datasource.model.Actividad;
import com.example.hp.acsapp.datasource.model.DatabaseTables;

/**
 * Created by camilojcr on 24/01/18.
 */

public class ACSDatabase extends SQLiteOpenHelper {
    //define db
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ACSDatabase.db";
    private static final String TAG = ACSDatabase.class.getSimpleName();

    //Constructor
    public ACSDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_ACTIVIDADES);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_USUARIO);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_AGENDA);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_MENSAJES);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_TECNICAS);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_CENTROS);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_CIUDAD);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_CONTACTOS);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_VER_MENSAJES);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_VER_TECNICAS);
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_MENSAJES_ERROR);
//        ContentValues values = new ContentValues();
//
//        values.put("id", 0);
//        values.put("mensaje", "No se encuentran registros");
//
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    //Metodos de manejo de base de datos

    public boolean insert_record(String nombreTabla, ContentValues values){
        long newRowId;
        SQLiteDatabase database = this.getWritableDatabase();
        newRowId = database.insert(nombreTabla,null,values);
        if(newRowId == -1){
            Log.d(TAG, "failed to save data!");
            database.close();
            return false;
        }else{
            Log.d(TAG, "save data successful");
            database.close();
            return true;
        }
    }

    public Cursor get_records(String query, String[] args){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor retorno = database.rawQuery(query,args);

        if(retorno != null){
            database.close();
            return retorno;
        }else{
            retorno = database.rawQuery("SELECT mensaje FROM mensaje_error WHERE id = 0", null);
            database.close();
            return retorno;
        }
    }
}
