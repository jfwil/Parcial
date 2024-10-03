package Control;

public class Launcher {

    public static void main(String[] args) {
            
        ConexionPr concon = new ConexionPr();
        
        CargaPr.cargarPropiedadesIniciales();
        concon.crearBaseDatos();
    }
}