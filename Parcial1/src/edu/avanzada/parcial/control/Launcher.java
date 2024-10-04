package edu.avanzada.parcial.vista;

import edu.avanzada.parcial.control.CargaPr;
import edu.avanzada.parcial.modelo.ConexionPr;



public class Launcher {

    public static void main(String[] args) {
            
        ConexionPr conexionpr = new ConexionPr();
        
        CargaPr.cargarPropiedadesIniciales();
        conexionpr.crearBaseDatos();
        
        VistaPerro vista = new VistaPerro();
        
        vista.mostrarMenu();
        
    }
}
