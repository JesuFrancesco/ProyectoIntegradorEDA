
package paq.clases;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import static paq.clases.Matriz.esNula;
import paq.interfaces.KernelConvolucion;
import static paq.interfaces.Mensajes.ERRORMATRIZNULA_STRING;

/*
 * @author Jesu
 */
public class FiltroGauss5x5 extends ConvolucionImagen implements KernelConvolucion {
    private int[][] matrizTemporal;
    private int[][] matrizEscalaDeGrises;
    
    public FiltroGauss5x5(BufferedImage imagen){    
        super(imagen);
        this.matrizEscalaDeGrises = obtenerEscalaGris();
    }
    
    public FiltroGauss5x5(String rutaString) {
        super(rutaString);
        this.matrizEscalaDeGrises = obtenerEscalaGris();
    }
    
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
    
    public BufferedImage desenfoque(){
        // Verificación
        if (getImagen() == null) {
            return null;
        }
        BufferedImage imagenFinal = getImagen();
        cargarMatrizConvolucion(GAUSSIAN5x5);
        
        int[][] M = getMatrizEscalaDeGrises();
        
        for (int i = 0; i < 3; i++) {
            M = generarConvolucion(M);
        }
        
        int alto = M.length, ancho = M[0].length;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                imagenFinal.setRGB(x, y, M[y][x]);
            }
        }
        return imagenFinal;
    }

    @Override
    public int[][] generarConvolucion(int[][] matrizEnEscalaDeGrises) {
        // Validación de datos
        if (esNula(getMatrizConvolucion()) || esNula(getMatrizRGB())){
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
            return null;
        }
        
        // Inicio de algoritmo
        int[][] matrizExtendida = extenderMatrizConCeros(matrizEnEscalaDeGrises);
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
                sumaProd = (255<<24) | (sumaProd<<16) | (sumaProd<<8) | sumaProd;
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
