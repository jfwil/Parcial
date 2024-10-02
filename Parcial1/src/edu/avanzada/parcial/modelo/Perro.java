/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.parcial.modelo;

import java.io.Serializable;

/**
 *
 * @author asfak
 */
public class Perro implements Serializable{
    
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
    
    public void setRaza() {
        this.raza = raza;
    }
    public String getRaza() {
        return raza;
    }
    
    public void setPais() {
        this.pais = pais;
    }
    public String getPais() {
        return pais;
    }
    
    public void setGrupoFCI() {
        this.grupoFCI = grupoFCI;
    }
    public String getGrupoFCI() {
        return grupoFCI;
    }
    
}
