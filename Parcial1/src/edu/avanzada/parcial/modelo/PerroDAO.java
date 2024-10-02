/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.parcial.control;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import edu.avanzada.parcial.modelo.Perro;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author asfak
 */
public class PerroDAO {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    public void insertarPerro(Perro perro) throws SQLException {
        String consulta = "INSERT INTO Perros (nombre, pais_origen, grupo_FCI, seccion_FCI, apariencia, pelo, color, espalda, lomo, cola, pecho) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
            pstmt.setString(1, perro.getNombre());
            pstmt.setString(2, perro.getPaisOrigen());
            pstmt.setInt(3, perro.getGrupoFCI());
            pstmt.setString(4, perro.getSeccionFCI());
            pstmt.setString(5, perro.getApariencia());
            pstmt.setString(6, perro.getPelo());
            pstmt.setString(7, perro.getColor());
            pstmt.setString(8, perro.getEspalda());
            pstmt.setString(9, perro.getLomo());
            pstmt.setString(10, perro.getCola());
            pstmt.setString(11, perro.getPecho());
            pstmt.executeUpdate();
        }

    }
}
