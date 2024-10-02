package edu.avanzada.parcial.modelo;
import java.sql.SQLException;
import edu.avanzada.parcial.modelo.Perro;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface PerroDAO {
    void insertarPerro(Perro perro) throws SQLException;
    Perro consultarPerro(String nombre) throws SQLException;
    List<Perro> consultarTodosPerros() throws SQLException;
    boolean eliminarPerro(String raza) throws SQLException;
    void modificarPerro(Perro perro) throws SQLException;
}

