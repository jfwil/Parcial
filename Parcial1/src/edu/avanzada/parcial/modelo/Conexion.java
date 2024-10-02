package edu.avanzada.parcial.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection cn = null;
    private static String URLBD  = "jdbc:mysql://localhost/tabla";
    private static String usuario  = "root";
    private static String contrasena = "";

    public static Connection getConexion() {
        try {
            cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        } catch (SQLException ex) {
            System.out.println("No se puede cargar el controlado");
        }
        return cn;
    }

    public static void desconectar() {
        cn = null;
    }
}