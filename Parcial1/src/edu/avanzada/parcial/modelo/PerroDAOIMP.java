package edu.avanzada.parcial.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insertar = "INSERT INTO Perros (raza, pais, grupoFCI, seccionFCI, apariencia, pelo, color, espalda, lomo, cola, pecho)";
            st.executeUpdate(insertar);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
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
        String consulta = "SELECT * FROM PERROS";
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

    public List<Perro> consultarTodosPerros(){
        List<Perro> listaPerros = new ArrayList<>();
        String consulta = "SELECT * FROM Perros";

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
                listaPerros.add(perro);

            }
            st.close();
            Conexion.desconectar();

        } catch (SQLException ex) {
            System.out.println("Error al consultar todos los perros: " + ex.getMessage());
        }

        return listaPerros;
    }

    public boolean eliminarPerro(String raza) {
        String consulta = "DELETE FROM Perros where raza='" + raza + "'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la eliminacion");
        }
        return false;
    }
    
    public void modificarPerro(Perro perro) {
        
        String actualizar = "UPDATE Perros SET pais='" + perro.getPais() + "', grupoFCI='" + perro.getGrupoFCI() + "', seccionFCI='" + perro.getSeccionFCI() + "', "
            + "pelo='" + perro.getPelo() + "', color='" + perro.getColor() + "', espalda='" + perro.getEspalda() + "', lomo='" + perro.getLomo() + "', "
            + "cola='" + perro.getCola() + "', pecho='" + perro.getPecho() + "' WHERE raza='" + perro.getRaza() + "'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(actualizar);
            st.close();
            Conexion.desconectar();
            System.out.println("Modificacion hecha");
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la modifcacion");
        }
    }
    
}