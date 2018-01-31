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
    public static final  String TABLA_ACTIVIDADES = "actividad";
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
    public static final String COLUMNA_FK_CIUDAD = "id_ciudad";

    private static final String SQL_CREATE_USUARIO = "CREATE TABLE "
            + TABLA_USUARIO + "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_FK_CIUDAD + "INTEGER NOT NULL, "
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

    //define tabla tecnicas de relajacion
    public static final String TABLA_TECNICAS_RELAJACION = "tecnicas_relajacion";
    public static final String COLUMNA_URL_RECURSO = "url_recurso";

    private static final String SQL_CREATE_TECNICAS = "CREATE TABLE "
            + TABLA_TECNICAS_RELAJACION + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL,"
            + COLUMNA_URL_RECURSO + " TEXT NOT NULL,"
            + COLUMNA_DESCRIPCION + " TEXT NOT NULL);";

    //define tabla centro_emergencia
    public static final String TABLA_CENTROS_EMERGENCIA = "centro_emergencia";
    public static final String COLUMNA_TELEFONO = "telefono";
    public static final String COLUMNA_DIRECCION = "direccion";

    private static final String SQL_CREATE_CENTROS = "CREATE TABLE "
            + TABLA_CENTROS_EMERGENCIA + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL,"
            + COLUMNA_TELEFONO + " TEXT NOT NULL,"
            + COLUMNA_DIRECCION + " TEXT NOT NULL);";

    //define tabla ciudad
    public static final  String TABLA_CIUDAD = "ciudad";

    private static final String SQL_CREATE_CIUDAD = "CREATE TABLE "
            + TABLA_CIUDAD + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL);";

    //define tabla contacto
    public static final String TABLA_CONTACTOS = "contacto";

    private static final String SQL_CREATE_CONTACTOS = "CREATE TABLE "
            + TABLA_CONTACTOS + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL"
            + COLUMNA_TELEFONO + " TEXT NOT NULL,"
            + COLUMNA_FK_USER + " INTEGER NOT NULL);";

    //define tabla mensaje_motivacional
    public static final String TABLA_MENSAJES = "mensaje_motivacional";
    public static final String COLUMNA_TITULO = "titulo";
    public static final String COLUMNA_AUTOR = "autor";


    private static final String SQL_CREATE_MENSAJES = "CREATE TABLE "
            + TABLA_MENSAJES +  "("
            + COLUMNA_ID + "INTEGER primary key autoincrement, "
            + COLUMNA_TITULO + " TEXT NOT NULL, "
            + COLUMNA_AUTOR + " TEXT NOT NULL, "
            + COLUMNA_DESCRIPCION + " TEXT NOT NULL);";

    //define tabla ver_mensaje_motivacional
    public static final String TABLA_VER_MENSAJES = "visualiza_mensaje";
    public static final String COLUMNA_FK_MENSAJES = "id_mensaje";

    private static final String SQL_CREATE_VER_MENSAJES = "CREATE TABLE "
            + TABLA_VER_MENSAJES + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_FK_MENSAJES + " INTEGER NOT NULL"
            + COLUMNA_FK_USER + " INTEGER NOT NULL);";

    //define tabla ver_tecnica
    public static final String TABLA_VER_TECNICAS = "visualiza_tecnica";
    public static final String COLUMNA_FK_TECNICAS = "id_tecnica";

    private static final String SQL_CREATE_VER_TECNICAS = "CREATE TABLE "
            + TABLA_VER_TECNICAS + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_FK_TECNICAS + " INTEGER NOT NULL"
            + COLUMNA_FK_USER + " INTEGER NOT NULL);";

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
        sqLiteDatabase.execSQL(SQL_CREATE_CENTROS);
        sqLiteDatabase.execSQL(SQL_CREATE_CIUDAD);
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTOS);
        sqLiteDatabase.execSQL(SQL_CREATE_VER_MENSAJES);
        sqLiteDatabase.execSQL(SQL_CREATE_VER_TECNICAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    //Metodos de manejo de base de datos


    public int insert_record(String nombreTabla, ContentValues values){
        long newRowId;
        SQLiteDatabase database = this.getWritableDatabase();
        newRowId = database.insert(nombreTabla,null,values);
        database.close();
        return (int) newRowId;
    }

}
