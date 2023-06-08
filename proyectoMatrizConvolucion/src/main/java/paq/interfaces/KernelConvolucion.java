package paq.interfaces;

/**
 *
 * @author Jesu
 */
public interface KernelConvolucion {
    public final double[][] SOBEL5x5_GX = {
            {+2, +2, +4, +2, +2},
            {+1, +1, +2, +1, +1},
            {0, 0, 0, 0, 0},
            {-1, -1, -2, -1, -1},
            {-2, -2, -4, -2, -2}
        };
    public final double[][] SOBEL5x5_GY = {
            {+2, +1, 0, -1, -2},
            {+2, +1, 0, -1, -2},
            {+4, +2, 0, -2, -4},
            {+2, +1, 0, -1, -2},
            {+2, +1, 0, -1, -2}
        };
    
}
