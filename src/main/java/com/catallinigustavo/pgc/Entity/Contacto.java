package com.catallinigustavo.pgc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imgIcono;
    private String linkIcono;
    @NotNull
    private String nombre;
    private String enlace;

    public Contacto() {
    }

    public Contacto(String imgIcono, String linkIcono, String nombre, String enlace) {
        this.imgIcono = imgIcono;
        this.linkIcono = linkIcono;
        this.nombre = nombre;
        this.enlace = enlace;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgIcono() {
        return imgIcono;
    }

    public void setImgIcono(String imgIcono) {
        this.imgIcono = imgIcono;
    }

    public String getLinkIcono() {
        return linkIcono;
    }

    public void setLinkIcono(String linkIcono) {
        this.linkIcono = linkIcono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

}
