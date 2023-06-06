package paq.pruebas;

import paq.clases.FiltroSobel5x5;

/*
 * @author Jesu
 */
public class Prueba {
    public static void main(String[] args) {
        String rutaImagen = "C:\\Users\\Jesu\\Downloads\\imagenPrueba.png";
        new FiltroSobel5x5(rutaImagen).deteccionBordes(30);
        
    }
}
