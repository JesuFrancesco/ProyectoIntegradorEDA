package paq.interfaces;

/**
 *
 * @author Jesu
 */
public interface MatricesConvolucion {
    public final int[][] MATRIZGX = {
            {+2, +2, +4, +2, +2},
            {+1, +1, +2, +1, +1},
            {0, 0, 0, 0, 0},
            {-1, -1, -2, -1, -1},
            {-2, -2, -4, -2, -2}
        };
    public final int[][] MATRIZGY = {
            {+2, +1, 0, -1, -2},
            {+2, +1, 0, -1, -2},
            {+4, +2, 0, -2, -4},
            {+2, +1, 0, -1, -2},
            {+2, +1, 0, -1, -2}
        };
    
}
