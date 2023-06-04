package paq.pruebas;

import paq.clases.FiltroSobel5x5;

/*
 * @author Jesu
 */
public class Prueba {
    public static void main(String[] args) {
        String rutaImagen = "C:\\Users\\Jesu\\Downloads\\imagenPrueba.png";
        FiltroSobel5x5.deteccionBordes(rutaImagen, 600);
        FiltroSobel5x5.filtroX(rutaImagen, 600);
        FiltroSobel5x5.filtroY(rutaImagen, 600);
    }
}
