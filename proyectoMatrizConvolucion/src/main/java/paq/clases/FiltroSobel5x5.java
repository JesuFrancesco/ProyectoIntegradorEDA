package paq.clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import paq.interfaces.*;

/*
 * @author Jesu
 */
public class FiltroSobel5x5 extends ConvolucionImagen implements KernelSobel5x5{
    private int[][] matrizEscalaDeGrises;
    
    
    public FiltroSobel5x5(BufferedImage imagen){    
        super(imagen);
        this.matrizEscalaDeGrises = obtenerEscalaGris();
    }
    
    public FiltroSobel5x5(String rutaString) {
        super(rutaString);
    }
    
    // Métodos
    private int[][] obtenerEscalaGris(){
        if (!esNula(getMatrizRGB())) {
            int[][] matrizEscalaGrises = new int[getAlto()][getAncho()];
            for (int y = 0; y < getAlto(); y++) {
                for (int x = 0; x < getAncho(); x++) {
                    int pixelRGB = getMatrizRGB()[y][x];
                    int a = (pixelRGB>>24)&0xff;
                    int r = (pixelRGB>>16)&0xff;   //Canal Red
                    int g = (pixelRGB>>8)&0xff;    //Canal Green
                    int b = pixelRGB&0xff;         //Canal Blue
                    int promedio = (r+g+b)/3;
                    matrizEscalaGrises[y][x] = (a<<24) | (promedio<<16) | (promedio<<8) | promedio;
                }
            }
            return matrizEscalaGrises;
        } else {
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
            return null;
        }
    }
    
    // Implementación del método abstracto generarConvolucion()
    @Override
    public int[][] generarConvolucion() {
        // Validación de datos
        if (esNula(getMatrizConvolucion()) || esNula(getMatrizRGB())){
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
            return null;
        }
        
        // Inicio de algoritmo
        int[][] matrizRGBext = extenderMatrizConCeros(obtenerEscalaGris());
        int[][] matrizResultado = new int[getAlto()][getAncho()];
        
        int n = getMatrizConvolucion().length;
        // Para recorrer la imagen
        for (int y = getExtension()/2; y < getAlto()+getExtension()/2; y++) {
            for (int x = getExtension()/2; x < getAncho()+getExtension()/2; x++) {
                if(x < getExtension() || y < getExtension() || x >= getAncho() || y >= getAlto()) {
                    matrizResultado[y-getExtension()/2][x-getExtension()/2] = 0;
                    continue;
                }
                // Para analizar submatrices y multiplicarlas por la matriz de convolución
                int sumaProd = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sumaProd += (matrizRGBext[y-(getExtension()/2)+i][x-(getExtension()/2)+j]&0xFF) * getMatrizConvolucion()[i][j];
                    }
                }
                matrizResultado[y-getExtension()/2][x-getExtension()/2] = sumaProd;
            }
        }
        return matrizResultado;
    }
    
    // Métodos
    public BufferedImage deteccionBordes(int gradiente) {
        // Inicio
        if (getImagen()==null) {return null;}
        BufferedImage imagen = getImagen();
        // Cargar matrices resultantes
        cargarMatrizConvolucion(MATRIZGX);
        int[][] Mx = generarConvolucion();
        cargarMatrizConvolucion(MATRIZGY);
        int[][] My = generarConvolucion();
        
        int alto = Mx.length, ancho = Mx[0].length, pixel;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixel = (int) Math.sqrt(Mx[y][x] * Mx[y][x] + My[y][x] * My[y][x]);
                if (pixel > gradiente)
                    pixel = (255<<16) | (255<<8) | 255;
                else 
                    pixel = (0<<16) | (0<<8) | 0;
                imagen.setRGB(x, y, pixel);
            }
        }
        return imagen;
    }
    
    public void filtroX(String rutaImagen, int gradiente){
        // Inicio
        BufferedImage imagen = ConvolucionImagen.cargarImagen(rutaImagen);
        if (imagen==null) {return;}
        
        // Cargar matrices resultantes
        cargarMatrizConvolucion(MATRIZGX);
        int[][] Mx = generarConvolucion();
        
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
    public void filtroY(String rutaImagen, int gradiente){
        // Inicio
        BufferedImage imagen = ConvolucionImagen.cargarImagen(rutaImagen);
        if (imagen==null) {return;}
        
        // Cargar matrices resultantes
        cargarMatrizConvolucion(MATRIZGY);
        int[][] My = generarConvolucion();
        
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

    public int[][] getMatrizEscalaDeGrises() {
        return matrizEscalaDeGrises;
    }

    public void setMatrizEscalaDeGrises(int[][] matrizEscalaDeGrises) {
        this.matrizEscalaDeGrises = matrizEscalaDeGrises;
    }
    
}
