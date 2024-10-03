package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CargaPr {

    public static void cargarPropiedadesIniciales() {
        Properties propiedades = new Properties();
        OutputStream salida = null;

        try {
            File archivo = new File("C:/Users/Usuario/Documents/NetBeansProjects/Branch3/src/main/java/data/config.properties");

            if (!archivo.exists()) {
                System.out.println("El archivo no existe. Creando con valores predeterminados.");
                salida = new FileOutputStream(archivo);

                propiedades.setProperty("Raza1.Grupo", "Perros de pastor y perros boyeros (menos Boyeros Suizos)");
                propiedades.setProperty("Raza1.SeccionGrupo1", "PerroPastor");
                propiedades.setProperty("Raza1.SeccionGrupo1.PerroPastor.Origen", "Alemania");
                propiedades.setProperty("Raza1.SeccionGrupo2", "PerroBoyero");
                propiedades.setProperty("Raza1.SeccionGrupo2.PerroBoyero.Origen", "Australia");

                propiedades.setProperty("Raza2.Grupo", "Perros Pinscher, Schnauzer, Molosoide y perros Boyeros Suizos");
                propiedades.setProperty("Raza2.SeccionGrupo1", "PerrosPinscher&Schanuzer");
                propiedades.setProperty("Raza2.SeccionGrupo1.PerrosPinscher&Schanuzer.Origen", "Alemania");
                propiedades.setProperty("Raza2.SeccionGrupo2", "PerrosMolosoides");
                propiedades.setProperty("Raza2.SeccionGrupo2.PerrosMolosoides.Origen", "Alemania");
                propiedades.setProperty("Raza2.SeccionGrupo3", "PerrosBoyerosSuizos");
                propiedades.setProperty("Raza2.SeccionGrupo3.PerrosBoyerosSuizos.Origen", "Suiza");

                propiedades.setProperty("Raza3.Grupo", "Perros Terriers");
                propiedades.setProperty("Raza3.SeccionGrupo1", "PerrosTerriersDeTallaGrande&Media");
                propiedades.setProperty("Raza3.SeccionGrupo1.PerrosTerriersDeTallaGrande&Media.Origen", "Inglaterra");
                propiedades.setProperty("Raza3.SeccionGrupo2", "PerrosTerriersDeTallaPequeña");
                propiedades.setProperty("Raza3.SeccionGrupo2.PerrosTerriersDeTallaPequeña.Origen", "Escocia");
                propiedades.setProperty("Raza3.SeccionGrupo3", "PerrosTerriersTipoBull");
                propiedades.setProperty("Raza3.SeccionGrupo3.PerrosTerriersTipoBull.Origen", "Inglaterra");
                propiedades.setProperty("Raza3.SeccionGrupo4", "PerrosTerriersDeCompañia");
                propiedades.setProperty("Raza3.SeccionGrupo4.PerrosTerriersDeCompañia.Origen", "Escocia");

                propiedades.setProperty("Raza4.Grupo", "Perros Dachshund o Teckel");
                propiedades.setProperty("Raza4.SeccionGrupo1", "PerroDachshund");
                propiedades.setProperty("Raza4.SeccionGrupo1.PerroDachshund.Origen", "Alemania");

                propiedades.store(salida, "Propiedades precargadas");
                System.out.println("Archivo creado con valores predeterminados.");
            } else {
                System.out.println("El archivo 'config.properties' ya existe. Leyendo propiedades actuales...");

                FileInputStream entrada = new FileInputStream(archivo);
                propiedades.load(entrada);

                propiedades.forEach((clave, valor) -> {
                    System.out.println(clave + ": " + valor);
                });

                entrada.close();
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