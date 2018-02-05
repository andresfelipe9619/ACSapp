package com.example.hp.acsapp.datasource.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        StartData data = new StartData(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //Metodos de manejo de base de datos

    public boolean insert_record(String nombreTabla, ContentValues values) {
        long newRowId;
        SQLiteDatabase database = this.getWritableDatabase();
        newRowId = database.insert(nombreTabla, null, values);
        if (newRowId == -1) {
            Log.d(TAG, "failed to save data!");
            database.close();
            return false;
        } else {
            Log.d(TAG, "save data successful");
            database.close();
            return true;
        }

    }

    public Cursor get_records(String query, String[] args) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor retorno = database.rawQuery(query, args);

        if (retorno != null) {
            database.close();
            return retorno;
        } else {
            retorno = database.rawQuery("SELECT mensaje FROM mensaje_error WHERE id = 0", null);
            database.close();
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
