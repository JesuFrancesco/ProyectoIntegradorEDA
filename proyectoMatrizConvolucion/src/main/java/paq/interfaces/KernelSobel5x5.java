package paq.interfaces;

/**
 *
 * @author Jesu
 */
public interface KernelSobel5x5 {
    public final double[][] MATRIZGX = {
            {+2, +2, +4, +2, +2},
            {+1, +1, +2, +1, +1},
            {0, 0, 0, 0, 0},
            {-1, -1, -2, -1, -1},
            {-2, -2, -4, -2, -2}
        };
    public final double[][] MATRIZGY = {
            {+2, +1, 0, -1, -2},
            {+2, +1, 0, -1, -2},
            {+4, +2, 0, -2, -4},
            {+2, +1, 0, -1, -2},
            {+2, +1, 0, -1, -2}
        };
    
}
