
package paq.clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import paq.interfaces.*;

/*
 * @author Jesu
 */
public abstract class FiltroSobel implements MatricesConvolucion{
    // Métodos
    public static void deteccionBordes(String rutaImagen, int gradiente) throws MalformedURLException, IOException{
        // Inicio
        BufferedImage imagen = ConvolucionImagen.cargarImagen(rutaImagen);
        if (imagen==null) {return;}
        ConvolucionImagen C = new ConvolucionImagen(imagen);
        
        // Cargar matrices resultantes
        C.cargarMatrizConvolucion(MATRIZGX);
        int[][] Mx = C.generarConvolucion();
        C.cargarMatrizConvolucion(MATRIZGY);
        int[][] My = C.generarConvolucion();
        
        // Algoritmo
        int alto = Mx.length, ancho = Mx[0].length, pixel;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixel = (int) Math.sqrt(Mx[y][x] * Mx[y][x] + My[y][x] * My[y][x]);
                if (pixel > gradiente)
                    pixel = (255<<24) | (255<<16) | (255<<8) | 255;
                else 
                    pixel = (255<<24) | (0<<16) | (0<<8) | 0;
                imagen.setRGB(x, y, pixel);
            }
        }
        try {
            File fin = new File("C:\\Users\\Jesu\\Downloads\\output.png");
            ImageIO.write(imagen, "png", fin);
        } catch(IOException e){
            System.out.println(e);
        }
    }
    public static void filtroX(String rutaImagen, int gradiente){
        // Inicio
        BufferedImage imagen = ConvolucionImagen.cargarImagen(rutaImagen);
        if (imagen==null) {return;}
        ConvolucionImagen C = new ConvolucionImagen(imagen);
        
        // Cargar matrices resultantes
        C.cargarMatrizConvolucion(MATRIZGX);
        int[][] Mx = C.generarConvolucion();
        
        // Algoritmo
        int alto = Mx.length, ancho = Mx[0].length, pixel;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixel = Mx[y][x];
                if (pixel > gradiente)
                    pixel = (255<<24) | (255<<16) | (255<<8) | 255;
                else 
                    pixel = (255<<24) | (0<<16) | (0<<8) | 0;
                imagen.setRGB(x, y, pixel);
            }
        }
        try {
            File fin = new File("C:\\Users\\Jesu\\Downloads\\outputX.png");
            ImageIO.write(imagen, "png", fin);
        } catch(IOException e){
            System.out.println(e);
        }
    }
    public static void filtroY(String rutaImagen, int gradiente){
        // Inicio
        BufferedImage imagen = ConvolucionImagen.cargarImagen(rutaImagen);
        if (imagen==null) {return;}
        ConvolucionImagen C = new ConvolucionImagen(imagen);
        
        // Cargar matrices resultantes
        C.cargarMatrizConvolucion(MATRIZGY);
        int[][] My = C.generarConvolucion();
        
        // Algoritmo
        int alto = My.length, ancho = My[0].length, pixel;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixel = My[y][x];
                if (pixel > gradiente)
                    pixel = (255<<24) | (255<<16) | (255<<8) | 255;
                else 
                    pixel = (255<<24) | (0<<16) | (0<<8) | 0;
                imagen.setRGB(x, y, pixel);
            }
        }
        try {
            File fin = new File("C:\\Users\\Jesu\\Downloads\\outputY.png");
            ImageIO.write(imagen, "png", fin);
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
}
