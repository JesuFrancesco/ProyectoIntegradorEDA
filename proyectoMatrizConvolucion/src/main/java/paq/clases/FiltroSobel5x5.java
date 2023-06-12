package paq.clases;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import paq.interfaces.*;

/*
 * @author Jesu
 */
public class FiltroSobel5x5 extends ConvolucionImagen implements KernelConvolucion{
    private int[][] matrizEscalaDeGrises;
    
    public FiltroSobel5x5(BufferedImage imagen){    
        super(imagen);
        this.matrizEscalaDeGrises = obtenerEscalaGris();
    }
    
    public FiltroSobel5x5(String rutaString) {
        super(rutaString);
        this.matrizEscalaDeGrises = obtenerEscalaGris();
    }
    
    // Métodos
    private int[][] obtenerEscalaGris(){
        // Algoritmo de conversión a escala de grises.
        int[][] matrizEscalaGrises = new int[getAlto()][getAncho()];
        for (int y = 0; y < getAlto(); y++) {
            for (int x = 0; x < getAncho(); x++) {
                int pixelRGB = getMatrizRGB()[y][x];
                int a = (pixelRGB>>24)&0xff;    // Canal alfa
                int r = (pixelRGB>>16)&0xff;    // Canal Red
                int g = (pixelRGB>>8)&0xff;     // Canal Green
                int b = pixelRGB&0xff;          // Canal Blue
                int promedio = (r+g+b)/3;
                matrizEscalaGrises[y][x] = (a<<24) | (promedio<<16) | (promedio<<8) | promedio;
            }
        }
        return matrizEscalaGrises;
    }
    
    public BufferedImage deteccionBordes(int gradiente) {
        // Inicio
        if (getImagen() == null) {
            return null;
        }
        BufferedImage imagen = getImagen();
        // Cargar matrices resultantes
        cargarMatrizConvolucion(SOBEL5x5_GX);
        int[][] Mx = generarConvolucion(getMatrizEscalaDeGrises());
        cargarMatrizConvolucion(SOBEL5x5_GY);
        int[][] My = generarConvolucion(getMatrizEscalaDeGrises());
        
        int alto = Mx.length, ancho = Mx[0].length, pixel;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                pixel = (int) Math.sqrt(Mx[y][x] * Mx[y][x] + My[y][x] * My[y][x]);
                if (pixel > gradiente)
                    pixel = 0xff000000 | (255<<16) | (255<<8) | 255;
                else 
                    pixel = 0xff000000 | (0<<16) | (0<<8) | 0;                    
                imagen.setRGB(x, y, pixel);
            }
        }
        return imagen;
    }
    
    // Implementación del método abstracto generarConvolucion()
    @Override
    public int[][] generarConvolucion(int[][] matriz) {
        // Validación de datos
        if (esNula(getMatrizConvolucion()) || esNula(getMatrizRGB())){
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
            return null;
        }
        
        // Inicio de algoritmo
        int[][] matrizExtendida = extenderMatrizConCeros(matriz);
        int[][] matrizResultado = new int[getAlto()][getAncho()];
        int n = getMatrizConvolucion().length, ext = getExtension();
        for (int y = ext/2; y < getAlto() + (ext/2); y++) {
            for (int x = ext/2; x < getAncho() + (ext/2); x++) {
                // Para analizar submatrices y multiplicarlas por la matriz de convolución
                int sumaProd = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sumaProd += (matrizExtendida[y-(ext/2)+i][x-(ext/2)+j]&0xFF) * getMatrizConvolucion()[i][j];
                    }
                }
                matrizResultado[y - (ext/2)][x - (ext/2)] = sumaProd;
            }
        }
        return matrizResultado;
    }

    public int[][] getMatrizEscalaDeGrises() {
        return matrizEscalaDeGrises;
    }

    public void setMatrizEscalaDeGrises(int[][] matrizEscalaDeGrises) {
        this.matrizEscalaDeGrises = matrizEscalaDeGrises;
    }
    
}
