package com.catallinigustavo.pgc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Habilidades_duras")
public class Hduras {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nombre;
    @NotNull
    private int progreso;
    @NotNull
    private int tiempoexpe;
    private String imgIcono;

    public Hduras() {
    }

    public Hduras(String nombre, int progreso, int tiempoexpe, String imgIcono) {
        this.nombre = nombre;
        this.progreso = progreso;
        this.tiempoexpe = tiempoexpe;
        this.imgIcono = imgIcono;
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

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    public int getTiempoexpe() {
        return tiempoexpe;
    }

    public void setTiempoexpe(int tiempoexpe) {
        this.tiempoexpe = tiempoexpe;
    }

    public String getImgIcono() {
        return imgIcono;
    }

    public void setImgIcono(String imgIcono) {
        this.imgIcono = imgIcono;
    }

    
}
