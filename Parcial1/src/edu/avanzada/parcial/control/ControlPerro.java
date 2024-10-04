package edu.avanzada.parcial.control;

import edu.avanzada.parcial.modelo.Perro;
import edu.avanzada.parcial.modelo.PerroDAO;
import edu.avanzada.parcial.modelo.PerroDAOIMP;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlPerro {

    private PerroDAO perroDAO;

    public ControlPerro() {
        perroDAO = new PerroDAOIMP(); 
    }
    
    public void agregarPerro(Perro perro) {
        try {
            if (perro != null && !perro.getRaza().isEmpty()) {
                perroDAO.insertarPerro(perro);
                //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
                //System.out.println("Perro agregado exitosamente.");
            } else {
                //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
                //System.out.println("Datos del perro no son válidos.");
            }
        } catch (SQLException e) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Error al agregar perro: " + e.getMessage());
        }
    }

    public Perro buscarPerro(String raza) {
        Perro perro = null;
        try {
            if (raza != null && !raza.isEmpty()) {
                perro = perroDAO.consultarPerro(raza);
            }
        } catch (SQLException e) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Error al consultar perro: " + e.getMessage());
        }
        return perro;
    }

    public boolean eliminarPerro(String raza) {
        try {
            if (raza != null && !raza.isEmpty()) {
                perroDAO.eliminarPerro(raza);
                //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
                //System.out.println("origen eliminada");
            } else {
                //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
                //System.out.println("origen no es valida o no existe en la base de datos");
            }
        } catch (SQLException e) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Error al eliminar perro: " + e.getMessage());
        }
        return true;
    }

    public void actualizarPerro(Perro perro) {
        try {
            if (perro != null && !perro.getOrigen().isEmpty()) {
                perroDAO.modificarPerro(perro);
                //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
                //System.out.println("Perro actualizado exitosamente.");
            } else {
                //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
                //System.out.println("Datos del perro no son válidos para la actualización.");
            }
        } catch (SQLException e) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Error al actualizar perro: " + e.getMessage());
        }
    }

    public List<Perro> obtenerTodosLosPerros() {
        List<Perro> perros = new ArrayList<>();
        try {
            perros = perroDAO.consultarTodosPerros();
        } catch (SQLException e) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Error al obtener lista de perros: " + e.getMessage());
        }
        return perros;
    }
}