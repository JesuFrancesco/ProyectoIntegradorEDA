
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
    
    public static boolean esNula(int[][] matriz){
        return matriz == null;
    }
    
    public static int[][] productoMatricial(int[][] A, int[][] B){
        if (A[0].length != B.length) {
            System.out.println("No se puede realizar el producto.");
            return null;
        }
        int[][] matrizF = new int[A.length][B[0].length];
        for (int i = 0; i < matrizF.length; i++) {
            for (int j = 0; j < matrizF[0].length; j++) {
                // Para calcular los productos unitarios
                int prod = 0;
                for (int k = 0; k < A[0].length; k++) {
                    prod += A[i][k]*B[k][j];
                }
                matrizF[i][j] = prod;
            }
        }
        return matrizF;
    }
    public static String matrizString(int[][] Matriz){
        String x = "";
        for (int[] filas : Matriz) {
            x += (Arrays.toString(filas)) + "\n";
        }
        return x;
    }
}
