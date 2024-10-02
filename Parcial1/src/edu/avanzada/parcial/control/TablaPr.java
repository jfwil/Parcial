package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TablaPr {

    private static final String URL = "jdbc:sqlite:src/data/perros.db";  
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS perros (" +
                                                   "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                   "raza TEXT NOT NULL, " +
                                                   "origen TEXT NOT NULL)";
    private static final String INSERT_SQL = "INSERT INTO perros (raza, origen) VALUES (?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void crearTabla() {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(CREATE_TABLE_SQL)) {
            stmt.execute();
            System.out.println("Tabla 'perros' creada o ya existe.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarPerro(String raza, String origen) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, raza);
            stmt.setString(2, origen);
            stmt.executeUpdate();
            System.out.println("Perro insertado en la base de datos: Raza = " + raza + ", Origen = " + origen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cargarPropiedadesEnBaseDeDatos(Properties propiedades) {
        propiedades.forEach((clave, valor) -> {
            String claveStr = (String) clave;
            String valorStr = (String) valor;

            if (claveStr.startsWith("Raza")) {
                String numero = claveStr.substring(4);
                String origenClave = "Origen" + numero;

                String origen = propiedades.getProperty(origenClave);
                if (origen != null) {
                    insertarPerro(valorStr, origen);
                }
            }
        });
    }
}