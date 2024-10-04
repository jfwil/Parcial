package edu.avanzada.parcial.modelo;

import java.io.Serializable;


public class Perro implements Serializable {

    public Perro() {
    }

    public Perro(String Raza, String Origen, String Grupo, String SeccionGrupo, String Apariencia,String Pelo, String Color, String Espalda, String Lomo, String Cola, String Pecho) {
        this.Raza = Raza;
        this.Origen = Origen;
        this.Grupo = Grupo;
        this.SeccionGrupo = SeccionGrupo;
        this.Apariencia = Apariencia;
        this.Pelo = Pelo;
        this.Color = Color;
        this.Espalda = Espalda;
        this.Lomo = Lomo;
        this.Cola = Cola;
        this.Pecho = Pecho;
    }

    private String Raza;
    private String Origen;
    private String Grupo;
    private String SeccionGrupo;
    
    private transient String Apariencia;
    private transient String Pelo;
    private transient String Color;
    private transient String Espalda;
    private transient String Lomo;
    private transient String Cola;
    private transient String Pecho;

    public Perro(String Raza, String Origen, String Grupo, String SeccionGrupo,String Pelo, String Color, String Espalda, String Lomo, String Cola, String Pecho) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

 
    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getRaza() {
        return Raza;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setSeccionGrupo(String SeccionGrupo) {
        this.SeccionGrupo = SeccionGrupo;
    }

    public String getSeccionGrupo() {
        return SeccionGrupo;
    }

    //Getters y setters de atributos no serializables
    
    public void setApariencia(String Apariencia) {
        this.Apariencia = Apariencia;
    }

    public String getApariencia() {
        return Apariencia;
    }

    public void setPelo(String Pelo) {
        this.Pelo = Pelo;
    }

    public String getPelo() {
        return Pelo;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getColor() {
        return Color;
    }

    public void setEspalda(String Espalda) {
        this.Espalda = Espalda;
    }

    public String getEspalda() {
        return Espalda;
    }

    public void setLomo(String Lomo) {
        this.Lomo = Lomo;
    }

    public String getLomo() {
        return Lomo;
    }

    public void setCola(String Cola) {
        this.Cola = Cola;
    }

    public String getCola() {
        return Cola;
    }

    public void setPecho(String Pecho) {
        this.Pecho = Pecho;
    }

    public String getPecho() {
        return Pecho;
    }

}