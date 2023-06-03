package paq.pruebas;

import paq.clases.FiltroSobel;

/*
 * @author Jesu
 */
public class Prueba {
    public static void main(String[] args) {
        String rutaImagen = "C:\\Users\\Jesu\\Downloads\\imagenPrueba.png";
        FiltroSobel.deteccionBordes(rutaImagen, 600);
        FiltroSobel.filtroX(rutaImagen, 600);
        FiltroSobel.filtroY(rutaImagen, 600);
    }
}
