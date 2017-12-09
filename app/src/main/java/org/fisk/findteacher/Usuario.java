package org.fisk.findteacher;

import java.io.Serializable;

/**
 * Created by Kelvin on 8/11/2017.
 */

public class Usuario implements Serializable{

    String name;
    String profesion;
    int resourceId;
    String precio;
    String descripcion;
    String foto;

    public Usuario() {
    }

    public Usuario(String name, String profesion, int resourceId, String precio, String descripcion, String foto) {
        this.name = name;
        this.profesion = profesion;
        this.resourceId = resourceId;
        this.precio = precio;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getNombre() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String description) {
        this.profesion = description;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
