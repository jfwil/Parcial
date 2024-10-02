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

                propiedades.setProperty("Raza1a", "PerroPastor");
                propiedades.setProperty("Origen1a", "Alemania");
                propiedades.setProperty("Raza1b", "PerroBoyero");
                propiedades.setProperty("Origen1b", "Australia");
                propiedades.setProperty("Raza2a", "PerroPincher");
                propiedades.setProperty("Origen2a", "Alemania");
                propiedades.setProperty("Raza2b", "PerroSchnauzer");
                propiedades.setProperty("Origen2b", "Alemania");
                propiedades.setProperty("Raza2c", "PerroMolosoide");
                propiedades.setProperty("Origen2c", "Italia");
                propiedades.setProperty("Raza2d", "PerroBoyeroSuizo");
                propiedades.setProperty("Origen2d", "Suiza");

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