package com.example.hp.acsapp.datasource.model;

/**
 * Created by HP on 1/23/2018.
 */

public final class MensajeMotivacional {

    private final String id;
    private final String titulo;
    private final String descripcion;
    private final String autor;


    public MensajeMotivacional(String id, String titulo, String descripcion, String autor){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
