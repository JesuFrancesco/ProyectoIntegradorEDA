
package paq.clases;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import static paq.clases.Matriz.esNula;
import paq.interfaces.KernelConvolucion;
import static paq.interfaces.Mensajes.ERRORMATRIZNULA_STRING;

/*
 * @author Jesu
 */
public class FiltroGauss3x3 extends ConvolucionImagen implements KernelConvolucion {
    
    public FiltroGauss3x3(BufferedImage imagen){    
        super(imagen);
    }
    
    public FiltroGauss3x3(String rutaString) {
        super(rutaString);
    }
    
    public BufferedImage desenfoque(){
        // Verificación
        if (getImagen() == null) {
            return null;
        }
        BufferedImage imagenFinal = getImagen();
        cargarMatrizConvolucion(GAUSSIAN3x3);
        
        // Obtener la convolución de la imagen por la matriz
        int[][] M = getMatrizRGB();
        M = generarConvolucion(M);
        
        // Colocar los valores a la imagen resultante
        int alto = M.length, ancho = M[0].length;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                imagenFinal.setRGB(x, y, M[y][x]);
            }
        }
        return imagenFinal;
    }

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
                int sumaProdR = 0, sumaProdG = 0, sumaProdB = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // Seleccionar el valor que se encuentra en los ejes X y Y, recorriendo además los ejes i y j para la matriz de convolución.
                        int valorRGB = matrizExtendida[y-(ext/2)+i][x-(ext/2)+j];
                        sumaProdR += ((valorRGB>>16)&0xFF) * getMatrizConvolucion()[i][j];
                        sumaProdG += ((valorRGB>>8)&0xFF) * getMatrizConvolucion()[i][j];
                        sumaProdB += ((valorRGB)&0xFF) * getMatrizConvolucion()[i][j];
                    }
                }
                int sumaProd = (255<<24) | (sumaProdR<<16) | (sumaProdG<<8) | sumaProdB;
                matrizResultado[y - (ext/2)][x - (ext/2)] = sumaProd;
            }
        }
        return matrizResultado;
    }
    
}
