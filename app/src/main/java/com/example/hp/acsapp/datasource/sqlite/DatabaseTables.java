package com.example.hp.acsapp.datasource.sqlite;

/**
 * Created by HP on 2/2/2018.
 */

public class DatabaseTables {

    //define tabla actividades
    public static final  String TABLA_ACTIVIDADES = "actividad";
    public static final  String COLUMNA_ID = "_id";
    public static final  String COLUMNA_NOMBRE = "nombre";
    public static final  String COLUMNA_DESCRIPCION = "descripcion";
    public static final  String COLUMNA_URL = "icon_url";

    public static final String SQL_CREATE_ACTIVIDADES = "CREATE TABLE "
            + TABLA_ACTIVIDADES + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL, "
            + COLUMNA_DESCRIPCION + " TEXT NOT NULL,"
            + COLUMNA_URL +" TEXT);";

    //define tabla usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String COLUMNA_FK_CIUDAD = "id_ciudad";

    public static final String SQL_CREATE_USUARIO = "CREATE TABLE "
            + TABLA_USUARIO + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_FK_CIUDAD + " INTEGER NOT NULL, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL); ";

    //define tabla agenda_actividades
    public static final String TABLA_AGENDA_ACTIVIDADES = "agenda_actividades";
    public static final String COLUMNA_FK_USER = "id_usuario";
    public static final String COLUMNA_FK_ACTIVIDAD = "id_actividad";
    public static final String COLUMNA_HORA = "hora";
    public static final String COLUMNA_FECHA = "fecha";
    public static final String COLUMNA_LUGAR = "lugar";

    public static final String SQL_CREATE_AGENDA = "CREATE TABLE "
            + TABLA_AGENDA_ACTIVIDADES + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_FK_USER + " INTEGER NOT NULL, "
            + COLUMNA_FK_ACTIVIDAD + " INTEGER NOT NULL, "
            + COLUMNA_HORA + " TEXT NOT NULL, "
            + COLUMNA_FECHA + " TEXT NOT NULL,"
            + COLUMNA_LUGAR + " TEXT NOT NULL); ";

    //define tabla tecnicas de relajacion
    public static final String TABLA_TECNICAS_RELAJACION = "tecnicas_relajacion";
    public static final String COLUMNA_URL_RECURSO = "url_recurso";

    public static final String SQL_CREATE_TECNICAS = "CREATE TABLE "
            + TABLA_TECNICAS_RELAJACION + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL,"
            + COLUMNA_URL_RECURSO + " TEXT NOT NULL,"
            + COLUMNA_DESCRIPCION + " TEXT NOT NULL);";

    //define tabla centro_emergencia
    public static final String TABLA_CENTROS_EMERGENCIA = "centro_emergencia";
    public static final String COLUMNA_TELEFONO = "telefono";
    public static final String COLUMNA_DIRECCION = "direccion";

    public static final String SQL_CREATE_CENTROS = "CREATE TABLE "
            + TABLA_CENTROS_EMERGENCIA + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL,"
            + COLUMNA_TELEFONO + " TEXT NOT NULL,"
            + COLUMNA_DIRECCION + " TEXT NOT NULL);";

    //define tabla ciudad
    public static final  String TABLA_CIUDAD = "ciudad";

    public static final String SQL_CREATE_CIUDAD = "CREATE TABLE "
            + TABLA_CIUDAD + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL);";

    //define tabla contacto
    public static final String TABLA_CONTACTOS = "contacto";

    public static final String SQL_CREATE_CONTACTOS = "CREATE TABLE "
            + TABLA_CONTACTOS + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL"
            + COLUMNA_TELEFONO + " TEXT NOT NULL,"
            + COLUMNA_FK_USER + " INTEGER NOT NULL);";

    //define tabla mensaje_motivacional
    public static final String TABLA_MENSAJES = "mensaje_motivacional";
    public static final String COLUMNA_TITULO = "titulo";
    public static final String COLUMNA_AUTOR = "autor";


    public static final String SQL_CREATE_MENSAJES = "CREATE TABLE "
            + TABLA_MENSAJES +  "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_TITULO + " TEXT NOT NULL, "
            + COLUMNA_AUTOR + " TEXT NOT NULL, "
            + COLUMNA_DESCRIPCION + " TEXT NOT NULL);";

    //define tabla ver_mensaje_motivacional
    public static final String TABLA_VER_MENSAJES = "visualiza_mensaje";
    public static final String COLUMNA_FK_MENSAJES = "id_mensaje";

    public static final String SQL_CREATE_VER_MENSAJES = "CREATE TABLE "
            + TABLA_VER_MENSAJES + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_FK_MENSAJES + " INTEGER NOT NULL"
            + COLUMNA_FK_USER + " INTEGER NOT NULL);";

    //define tabla ver_tecnica
    public static final String TABLA_VER_TECNICAS = "visualiza_tecnica";
    public static final String COLUMNA_FK_TECNICAS = "id_tecnica";

    public static final String SQL_CREATE_VER_TECNICAS = "CREATE TABLE "
            + TABLA_VER_TECNICAS + "("
            + COLUMNA_ID + " INTEGER primary key autoincrement, "
            + COLUMNA_FK_TECNICAS + " INTEGER NOT NULL"
            + COLUMNA_FK_USER + " INTEGER NOT NULL);";

    //define tabla mensajes_error

    public static final String SQL_CREATE_MENSAJES_ERROR = "CREATE TABLE mensaje_error(id INTEGER primary key, mensaje TEXT)";


}
