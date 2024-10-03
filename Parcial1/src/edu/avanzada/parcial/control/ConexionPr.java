package Control;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public class ConexionPr {
    
    //errores en bases de datos
    private static final Logger logger = Logger.getLogger(ConexionPr.class.getName());
    public Connection conn;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "";

    public void conectar() throws SQLException {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            logger.info("Problema:" + e);
        }
    }

    public void desconectar() throws SQLException {
        if (conn != null) {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
    }
    
    public void crearBaseDatos() {
        Properties propiedades = new Properties();

    try {
        FileInputStream entrada = new FileInputStream("C:/Users/Usuario/Documents/NetBeansProjects/Branch3/src/main/java/data/config.properties");
        propiedades.load(entrada);

        // Conectar sin base de datos para crear la BD
        conectar();
        Statement stmt = conn.createStatement();

        // Crear la base de datos si no existe
        String crearBD = "CREATE DATABASE IF NOT EXISTS PerrosDB";
        stmt.executeUpdate(crearBD);
        System.out.println("Base de datos PerrosDB creada o existente");

        // Cerrar la conexión actual y volver a conectarse a la nueva base de datos
        desconectar();
        conn = DriverManager.getConnection(URL + "PerrosDB", USER, PASS);

        // Crear la tabla
        stmt = conn.createStatement();
        String crearTabla = "CREATE TABLE IF NOT EXISTS Razas ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "grupo VARCHAR(255), "
                + "seccionGrupo VARCHAR(255), "
                + "origen VARCHAR(255))";
        stmt.executeUpdate(crearTabla);
        System.out.println("Tabla Razas creada o existente");

        // Insertar los datos desde el archivo de propiedades
        for (int i = 1; i <= 15; i++) { // Hasta 15 grupos
            String grupo = propiedades.getProperty("Raza" + i + ".Grupo");
            if (grupo == null) continue;

            for (int j = 1; j <= 20; j++) { // Hasta 20 subgrupos por grupo
                String seccionGrupo = propiedades.getProperty("Raza" + i + ".SeccionGrupo" + j);
                if (seccionGrupo == null) {
                    break; // Si no hay más secciones, salir del bucle
                }

                // Acceder al origen de la sección, ajustando la clave
                String origen = propiedades.getProperty("Raza" + i + ".SeccionGrupo" + j + "." + seccionGrupo + ".Origen");

                if (origen != null) {
                    String insertarDatos = "INSERT INTO Razas (grupo, seccionGrupo, origen) VALUES ('"
                            + grupo + "', '" + seccionGrupo + "', '" + origen + "')";
                    stmt.executeUpdate(insertarDatos);
                } else {
                    System.out.println("No se encontró el origen para Raza" + i + " SeccionGrupo" + j);
                }
            }
        }

        System.out.println("Datos insertados en la tabla Razas.");

        stmt.close();
        desconectar();

        } catch (IOException | SQLException e) {
        e.printStackTrace();
        //findelpuntoab
        }
    }
}