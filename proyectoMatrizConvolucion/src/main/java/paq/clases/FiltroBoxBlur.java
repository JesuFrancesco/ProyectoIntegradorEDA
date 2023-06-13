package paq.clases;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import paq.interfaces.*;
/**
 *
 * @author diana
 */
public class FiltroBoxBlur extends ConvolucionImagen implements KernelConvolucion{

    public FiltroBoxBlur(BufferedImage imagen) {
        super(imagen);
    }
    public FiltroBoxBlur(String rutaString) {
        super(rutaString);
    }

    public BufferedImage desenfoque(int radio, int iteraciones){
        // Verificación
        if (getImagen() == null) {
            return null;
        }
    
        BufferedImage imagenFinal = getImagen();
        double kernel[][] = generarKernel(radio);
        cargarMatrizConvolucion(kernel);
    
        // Obtener la convolución de la imagen por la matriz
        int[][] M = getMatrizRGB();
        
        //Iteraciones
        for (int i = 0; i < iteraciones; i++) {
            M = generarConvolucion(M);
        }
        
        // Colocar los valores a la imagen resultante
        int alto = M.length, ancho = M[0].length;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                imagenFinal.setRGB(x, y, M[y][x]);
            }
        }
        return imagenFinal;
    }
    
    public double[][] generarKernel(int r){
        double kernel[][] = new double[2*r+1][2*r+1];
        double num = 1f/((2f*r+1f)*(2f*r+1f));
        for (double[] filaKernel : kernel) {
            for (int j = 0; j < kernel[0].length; j++) {
                filaKernel[j] = num;
            }
        }
        return kernel;
    }
    
//    @Override
//    protected int[][] extenderMatrizConCeros(int[][] matriz) {
//        int matrizAlto, matrizAncho;
//        // En caso se desee usar el atributo matrizRGB en lugar de una matriz alterna.
//        if (!esNula(matriz)){
//            matrizAlto = matriz.length;
//            matrizAncho = matriz[0].length;
//        } else {
//            matriz = getMatrizRGB();
//            matrizAlto = getAlto();
//            matrizAncho = getAncho();
//        }
//
//        int ext = getExtension();
//        int[][] matrizExtendida = new int[matrizAlto + ext][matrizAncho + ext];
//        for (int i = 0; i < matrizExtendida.length; i++) {
//            for (int j = 0; j < matrizExtendida[0].length; j++) {
//                matrizExtendida[i][j] = (255<<24) | (255<<16) | (255<<8) | (255);
//            }
//        }
//        // Recorrer la imagen por sus valores ARGB.
//        for(int y = ext/2; y < matrizAlto + (ext/2); y++){
//            for(int x = ext/2; x < matrizAncho + (ext/2); x++){
//                int p = matriz[y-ext/2][x-ext/2];
//                matrizExtendida[y][x] = p;
//            }
//        }
//        return matrizExtendida;
//    }
    
    @Override
    public int[][] generarConvolucion(int[][] matrizEnEscalaDeGrises) {
        // Validación de datos
        if (esNula(getMatrizConvolucion()) || esNula(getMatrizRGB())){
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
            return null;
        }
        
        int[][] matrizExtendida = extenderMatrizConCeros(matrizEnEscalaDeGrises);
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
