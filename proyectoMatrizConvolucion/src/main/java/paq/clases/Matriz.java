package paq.clases;

import java.util.Arrays;

/*
 * @author Jesu
 */
public abstract class Matriz {
    // Métodos utilitarios
    public static boolean esMatrizCuadrada(int[][] matriz){
        int longitudVertical = matriz.length;
        for (int[] filas : matriz) {
            int longitudHorizontal = filas.length;
            if (longitudHorizontal != longitudVertical) {
                return false;
            }
        } return true;
    }
    
    public static boolean esMatrizCuadrada(double[][] matriz){
        int longitudVertical = matriz.length;
        for (double[] filas : matriz) {
            int longitudHorizontal = filas.length;
            if (longitudHorizontal != longitudVertical) {
                return false;
            }
        } return true;
    }
    
    public static boolean esNula(int[][] matriz){
        return matriz == null;
    }
    public static boolean esNula(double[][] matriz){
        return matriz == null;
    }
    
    public static void verMatriz(int[][] M){
        for (int[] is : M) {
            System.out.println(Arrays.toString(is));
        }
    }
}
