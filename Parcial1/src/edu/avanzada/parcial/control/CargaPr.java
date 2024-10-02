package Control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CargaPr {

    public static void cargarPropiedadesIniciales() {
        Properties propiedades = new Properties();
        OutputStream salida = null;

        try {
            File archivo = new File("src/data/config.properties");

            if (!archivo.exists()) {
                System.out.println("El archivo no existe. Creando con valores predeterminados.");
                salida = new FileOutputStream(archivo);

                propiedades.setProperty("Raza1.Grupo", "Perros de pastor y perros boyeros (menos Boyeros Suizos)");
                propiedades.setProperty("Raza1.SeccionGrupo", "PerroPastor");
                propiedades.setProperty("Raza1.SeccionGrupo.PerroPastor.Origen", "Alemania");
                propiedades.setProperty("Raza1.SeccionGrupo", "PerroBoyero");
                propiedades.setProperty("Raza1.SeccionGrupo.PerroBoyero.Origen", "Australia");

                propiedades.setProperty("Raza2.Grupo", "Perros Pinscher, Schnauzer, Molosoide y perros Boyeros Suizos");
                propiedades.setProperty("Raza2.SeccionGrupo", "PerrosPinscher&Schanuzer");
                propiedades.setProperty("Raza2.SeccionGrupo.PerrosPinscher&Schanuzer.Origen", "Alemania");
                propiedades.setProperty("Raza2.SeccionGrupo", "PerrosMolosoides");
                propiedades.setProperty("Raza2.SeccionGrupo.PerrosMolosoides.Origen", "Alemania");
                propiedades.setProperty("Raza2.SeccionGrupo", "PerrosBoyerosSuizos");
                propiedades.setProperty("Raza2.SeccionGrupo.PerrosBoyerosSuizos.Origen", "Suiza");

                propiedades.setProperty("Raza3.Grupo", "Perros Terriers");
                propiedades.setProperty("Raza3.SeccionGrupo", "PerrosTerriersDeTallaGrande&Media");
                propiedades.setProperty("Raza3.SeccionGrupo.PerrosTerriersDeTallaGrande&Media.Origen", "Inglaterra");
                propiedades.setProperty("Raza3.SeccionGrupo", "PerrosTerriersDeTallaPequeña");
                propiedades.setProperty("Raza3.SeccionGrupo.PerrosTerriersDeTallaPequeña.Origen", "Escocia");
                propiedades.setProperty("Raza3.SeccionGrupo", "PerrosTerriersTipoBull");
                propiedades.setProperty("Raza3.SeccionGrupo.PerrosTerriersTipoBull.Origen", "Inglaterra");
                propiedades.setProperty("Raza3.SeccionGrupo", "PerrosTerriersDeCompañia");
                propiedades.setProperty("Raza3.SeccionGrupo.PerrosTerriersDeCompañia.Origen", "Escocia");

                propiedades.setProperty("Raza4.Grupo", "Perros Dachshund o Teckel");
                propiedades.setProperty("Raza4.SeccionGrupo", "PerroDachshund");
                propiedades.setProperty("Raza4.SeccionGrupo.PerroDachshund.Origen", "Alemania");

                propiedades.store(salida, "Propiedades precargadas");
                System.out.println("Archivo creado con valores predeterminados.");
            } else {
                System.out.println("El archivo 'config.properties' ya existe.");
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}