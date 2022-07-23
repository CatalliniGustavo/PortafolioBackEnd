package com.catallinigustavo.pgc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imgIcono;
    private String linkIcono;
    @NotNull
    private String nombre;
    private String fechainicio;
    private String fechafin;
    private String lugar;
    @NotNull
    private String titulo;
    @NotNull
    private String descripcion;
    private boolean estado = true;

//    @ManyToOne()
//    @JoinColumn(name = "experiencia_id")
//    private User user;

    public Experiencia() {
    }
   

    public Experiencia(String imgIcono, String linkIcono, String fechainicio, String fechafin, String lugar, String titulo, String descripcion) {
        this.imgIcono = imgIcono;
        this.linkIcono = linkIcono;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.lugar = lugar;
        this.titulo = titulo;
        this.descripcion = descripcion;
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

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}
