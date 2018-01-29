package com.example.hp.acsapp.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.acsapp.datasource.model.Actividad;

/**
 * Created by camilojcr on 24/01/18.
 */

public class ACSDatabase extends SQLiteOpenHelper {

    //define db
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ACSDatabase.db";

    //define tabla actividades
    public static final  String TABLA_ACTIVIDADES = "actividades";
    public static final  String COLUMNA_ID = "_id";
    public static final  String COLUMNA_NOMBRE = "nombre";
    public static final  String COLUMNA_DESCRIPCION = "descripcion";
    public static final  String COLUMNA_URL = "icon_url";

    private static final String SQL_CREATE_ACTIVIDADES = "CREATE TABLE "
            + TABLA_ACTIVIDADES + "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + "TEXT NOT NULL, "
            + COLUMNA_DESCRIPCION + "TEXT NOT NULL,"
            + COLUMNA_URL +"TEXT);";

    //define tabla usuario
    public static final String TABLA_USUARIO = "usuario";

    private static final String SQL_CREATE_USUARIO = "CREATE TABLE "
            + TABLA_USUARIO + "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + "TEXT NOT NULL); ";

    //define tabla agenda_actividades
    public static final String TABLA_AGENDA_ACTIVIDADES = "agenda_actividades";
    public static final String COLUMNA_FK_USER = "id_usuario";
    public static final String COLUMNA_FK_ACTIVIDAD = "id_actividad";
    public static final String COLUMNA_HORA = "hora";
    public static final String COLUMNA_FECHA = "fecha";
    public static final String COLUMNA_LUGAR = "lugar";

    private static final String SQL_CREATE_AGENDA = "CREATE TABLE "
            + TABLA_AGENDA_ACTIVIDADES + "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_FK_USER + "INTEGER NOT NULL, "
            + COLUMNA_FK_ACTIVIDAD + "INTEGER NOT NULL, "
            + COLUMNA_HORA + "TEXT NOT NULL, "
            + COLUMNA_FECHA + "TEXT NOT NULL,"
            + COLUMNA_LUGAR + "TEXT NOT NULL); ";

    //define tabla mensaje motivacional
    public static final String TABLA_MENSAJES_MOTIVACIONALES = "mensajes_motivacionales";

    private static final String SQL_CREATE_MENSAJES = "CREATE TABLE "
            + TABLA_MENSAJES_MOTIVACIONALES + "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + "TEXT NOT NULL,"
            + COLUMNA_DESCRIPCION + "TEXT NOT NULL);";

    //define tabla tecnicas de relajacion
    public static final String TABLA_TECNICAS_RELAJACION = "tecnicas_relajacion";

    private static final String SQL_CREATE_TECNICAS = "CREATE TABLE "
            + TABLA_TECNICAS_RELAJACION + "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + "TEXT NOT NULL,"
            + COLUMNA_DESCRIPCION + "TEXT NOT NULL);";


    //Constructor
    public ACSDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ACTIVIDADES);
        sqLiteDatabase.execSQL(SQL_CREATE_USUARIO);
        sqLiteDatabase.execSQL(SQL_CREATE_AGENDA);
        sqLiteDatabase.execSQL(SQL_CREATE_MENSAJES);
        sqLiteDatabase.execSQL(SQL_CREATE_TECNICAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    //Metodos de manejo de base de datos

    public void insert_actividad(Actividad actividad){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNA_ID, actividad.getId());
        values.put(COLUMNA_NOMBRE, actividad.getNombre());
        values.put(COLUMNA_DESCRIPCION, actividad.getDescripcion());
        values.put(COLUMNA_URL, actividad.getIcon_url());

        database.insert(TABLA_ACTIVIDADES,null,values);
        database.close();
    }

    public void insert_usuario(){

    }
}
