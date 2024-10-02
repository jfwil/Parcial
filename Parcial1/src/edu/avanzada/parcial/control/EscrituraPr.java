package Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class EscrituraPr {
    public static void main(String[] args) {
        CargaPr.cargarPropiedadesIniciales();

        Properties propiedades = new Properties();
        InputStream entrada = null;
        OutputStream salida = null;
        Scanner scanner = new Scanner(System.in);
        String key, value;

        try {
            entrada = new FileInputStream("src/data/config.properties");
            propiedades.load(entrada);
            System.out.println("Propiedades actuales:");
            propiedades.forEach((k, v) -> System.out.println(k + ": " + v));
            entrada.close();

            TablaPr.crearTabla();
            TablaPr.cargarPropiedadesEnBaseDeDatos(propiedades);

            System.out.println("¿Desea agregar nuevas propiedades? (si/no): ");
            String respuesta = scanner.nextLine();

            while (respuesta.equalsIgnoreCase("si")) {
                System.out.println("Ingrese el nombre del grupo de la clave (por ejemplo, 'Raza3a'):");
                key = scanner.nextLine();

                System.out.println("Ingrese el nombre de la raza (por ejemplo 'PerroPincher'):");
                value = scanner.nextLine();

                propiedades.setProperty(key, value);

                System.out.println("¿Desea agregar otra propiedad? (si/no): ");
                respuesta = scanner.nextLine();
            }

            salida = new FileOutputStream("src/data/config.properties");
            propiedades.store(salida, null);

            System.out.println("Propiedades actualizadas y guardadas en el archivo.");

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
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}