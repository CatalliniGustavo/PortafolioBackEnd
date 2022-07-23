package com.catallinigustavo.pgc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "proyectos")
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nombre;
    private String imgIcono;
    private String descripcion;
    private String github;

    public Proyectos() {
    }

    public Proyectos(String nombre, String imgIcono, String descripcion, String github) {
        this.nombre = nombre;
        this.imgIcono = imgIcono;
        this.descripcion = descripcion;
        this.github = github;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgIcono() {
        return imgIcono;
    }

    public void setImgIcono(String imgIcono) {
        this.imgIcono = imgIcono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
