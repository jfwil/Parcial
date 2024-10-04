package edu.avanzada.parcial.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PerroDAOIMP implements PerroDAO {

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    //instancia de la clase conexion pr que luego se inicializa en el const
    private ConexionPr conexion;

    public PerroDAOIMP() {
        conn = null;
        st = null;
        rs = null;
        conexion = new ConexionPr();
    }

    public void insertarPerro(Perro perro) throws SQLException {

        try {
            conexion.conectar();
            conn = conexion.conn;
            st = conn.createStatement();
            
            String insertar = "INSERT INTO Perros (Raza, Origen, Grupo, SeccionGrupo, Apariencia, Pelo, Color, Espalda, Lomo, Cola, Pecho)";
            st.executeUpdate(insertar);
            st.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.print("No se pudo realizar la insercion");
        }
    }

    @Override
    public Perro consultarPerro(String Raza) {
        Perro perro = null;
        String consulta = "SELECT * FROM Perros WHERE Raza = '" + Raza + "'";;
        try {
            conexion.conectar();
            conn = conexion.conn;
            st = conn.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                perro = new Perro();
                perro.setRaza(rs.getString("Raza"));
                perro.setOrigen(rs.getString("Origen"));
                perro.setGrupo(rs.getString("Grupo"));
                perro.setSeccionGrupo(rs.getString("SeccionGrupo"));
                perro.setApariencia(rs.getString("Apariencia"));
                perro.setPelo(rs.getString("Pelo"));
                perro.setColor(rs.getString("Color"));
                perro.setEspalda(rs.getString("Espalda"));
                perro.setLomo(rs.getString("Lomo"));
                perro.setCola(rs.getString("Cola"));
                perro.setPecho(rs.getString("Pecho"));
            }
            st.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("No se pudo realizar la consulta");
        }
        return perro;
    }

    public ArrayList<Perro> listaDePerros() {
        ArrayList<Perro> misPerros = new ArrayList<Perro>();
        String consulta = "SELECT * FROM PERROS";
        try {
            conexion.conectar();
            conn = conexion.conn;
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Perro perro = new Perro();
                perro.setRaza(rs.getString("Raza"));
                perro.setOrigen(rs.getString("Origen"));
                perro.setGrupo(rs.getString("Grupo"));
                perro.setSeccionGrupo(rs.getString("SeccionGrupo"));
                perro.setApariencia(rs.getString("Apariencia"));
                perro.setPelo(rs.getString("Pelo"));
                perro.setColor(rs.getString("Color"));
                perro.setEspalda(rs.getString("Espalda"));
                perro.setLomo(rs.getString("Lomo"));
                perro.setCola(rs.getString("Cola"));
                perro.setPecho(rs.getString("Pecho"));
                misPerros.add(perro);
            }
            st.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("No se pudo realizar la consulta");
        }
        return misPerros;
    }

    public List<Perro> consultarTodosPerros() {
        List<Perro> listaPerros = new ArrayList<>();
        String consulta = "SELECT * FROM Perros";

        try {
            conexion.conectar();
            conn = conexion.conn;
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                Perro perro = new Perro();
                perro.setRaza(rs.getString("Raza"));
                perro.setOrigen(rs.getString("Origen"));
                perro.setGrupo(rs.getString("Grupo"));
                perro.setSeccionGrupo(rs.getString("SeccionGrupo"));
                perro.setApariencia(rs.getString("apariencia"));
                perro.setPelo(rs.getString("Pelo"));
                perro.setColor(rs.getString("Color"));
                perro.setEspalda(rs.getString("Espalda"));
                perro.setLomo(rs.getString("Lomo"));
                perro.setCola(rs.getString("Cola"));
                perro.setPecho(rs.getString("Pecho"));
                listaPerros.add(perro);

            }
            st.close();
            conexion.desconectar();

        } catch (SQLException ex) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Error al consultar todos los perros: " + ex.getMessage());
        }

        return listaPerros;
    }

    public boolean eliminarPerro(String Raza) {
        String consulta = "DELETE FROM Perros where raza='" + Raza + "'";
        try {
            conexion.conectar();
            conn = conexion.conn;
            st.executeUpdate(consulta);
            st.close();
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("No se pudo realizar la eliminacion");
        }
        return false;
    }

    public void modificarPerro(Perro perro) {

        String actualizar = "UPDATE Perros SET Origen='" + perro.getOrigen() + "', grupoFCI='" + perro.getGrupo() + "', SeccionFCI='" + perro.getSeccionGrupo() + "', " + "', Apariencia='" + perro.getApariencia() + "', "
                +"Pelo='" + perro.getPelo() + "', Color='" + perro.getColor() + "', Espalda='" + perro.getEspalda() + "', Lomo='" + perro.getLomo() + "', "
                + "Cola='" + perro.getCola() + "', Pecho='" + perro.getPecho() + "' WHERE origen='" + perro.getOrigen() + "'";
        try {
            conexion.conectar();
            conn = conexion.conn;
            st.executeUpdate(actualizar);
            st.close();
            conexion.desconectar();
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("Modificacion hecha");
        } catch (SQLException ex) {
            //ACA PONER IMPLEMENTACION INTERFAZ GRAFICA
            //System.out.println("No se pudo realizar la modifcacion");
        }
    }

}