package com.example.toni.pruebatabs;

/**
 * Created by Toni on 08/10/2016.
 */

public class Casilla {

    private String name;

    //Identificador Foto
    private int idThumbnail;

    private String descripcion;

    public Casilla(String name, int idThumbnail) {
        this.name = name;
        this.idThumbnail = idThumbnail;
    }

    public Casilla(String descripcion) {
        this.descripcion = descripcion;
    }

    /* Es el primer elemento de las "listas" */
    //private String urgente; EXTRA

    public Casilla() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdThumbnail() {
        return idThumbnail;
    }

    public void setIdThumbnail(int idThumbnail) {
        this.idThumbnail = idThumbnail;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
