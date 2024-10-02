package edu.avanzada.parcial.modelo;

import java.io.Serializable;


public class Perro implements Serializable {

    public Perro() {
    }

    public Perro(String raza, String pais, String grupoFCI, String seccionFCI, String pelo, String color, String espalda, String lomo, String cola, String pecho) {
        this.raza = raza;
        this.pais = pais;
        this.grupoFCI = grupoFCI;
        this.seccionFCI = seccionFCI;
        this.pelo = pelo;
        this.color = color;
        this.espalda = espalda;
        this.lomo = lomo;
        this.cola = cola;
        this.pecho = pecho;
    }

    private String raza;
    private String pais;
    private String grupoFCI;
    private String seccionFCI;

    private transient String pelo;
    private transient String color;
    private transient String espalda;
    private transient String lomo;
    private transient String cola;
    private transient String pecho;

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setGrupoFCI(String grupoFCI) {
        this.grupoFCI = grupoFCI;
    }

    public String getGrupoFCI() {
        return grupoFCI;
    }

    public void setSeccionFCI(String seccionFCI) {
        this.seccionFCI = seccionFCI;
    }

    public String getSeccionFCI() {
        return seccionFCI;
    }

    //Getters y setters de atributos no serializables
    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public String getPelo() {
        return pelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setEspalda(String espalda) {
        this.espalda = espalda;
    }

    public String getEspalda() {
        return espalda;
    }

    public void setLomo(String lomo) {
        this.lomo = lomo;
    }

    public String getLomo() {
        return lomo;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public String getCola() {
        return cola;
    }

    public void setPecho(String pecho) {
        this.pecho = pecho;
    }

    public String getPecho() {
        return pecho;
    }

}