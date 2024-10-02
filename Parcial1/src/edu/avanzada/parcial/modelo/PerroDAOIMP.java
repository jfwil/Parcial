package edu.avanzada.parcial.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PerroDAOIMP implements PerroDAO {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public PerroDAOIMP() {
        con = null;
        st = null;
        rs = null;
    }
    
    public void insertarPerro(Perro perro) throws SQLException {
        
        String insertar = "INSERT INTO Perros (raza, pais, grupoFCI, seccionFCI, apariencia, pelo, color, espalda, lomo, cola, pecho)";
        
    }
    
    @Override
    public Perro consultarPerro(String codigo) {
        Perro perro = null;
        String consulta = "";
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                perro = new Perro();
                perro.setRaza(rs.getString("Raza"));
                perro.setPais(rs.getString("Pais"));
                perro.setGrupoFCI(rs.getString("Grupo"));
                perro.setSeccionFCI(rs.getString("Seccion"));
                perro.setPelo(rs.getString("Pelo"));
                perro.setColor(rs.getString("Color"));
                perro.setEspalda(rs.getString("Espalda"));
                perro.setLomo(rs.getString("Lomo"));
                perro.setCola(rs.getString("Cola"));
                perro.setPecho(rs.getString("Pecho"));
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return perro;
    }
    public ArrayList<Perro> listaDePerros() {
        ArrayList<Perro> misPerros = new ArrayList<Perro>();
        String consulta = "SELECT * FROM Estudiantes";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Perro perro = new Perro();
                perro.setRaza(rs.getString("Raza"));
                perro.setPais(rs.getString("Pais"));
                perro.setGrupoFCI(rs.getString("Grupo"));
                perro.setSeccionFCI(rs.getString("Seccion"));
                perro.setPelo(rs.getString("Pelo"));
                perro.setColor(rs.getString("Color"));
                perro.setEspalda(rs.getString("Espalda"));
                perro.setLomo(rs.getString("Lomo"));
                perro.setCola(rs.getString("Cola"));
                perro.setPecho(rs.getString("Pecho"));
                misPerros.add(perro);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return misPerros;
    }
}