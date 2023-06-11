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
    public final double[][] GAUSSIAN3x3 = {
        {+1f/16f, +2f/16f, +1f/16f},
        {+2f/16f, +4f/16f, +2f/16f},
        {+1f/16f, +2f/16f, +1f/16f},
    };
    public final double[][] GAUSSIAN5x5 = {
        {+1f/256f, +4f/256f, +6f/256f, +4f/256f, +1f/256f},
        {+4f/256f, +16f/256f, +24f/256f, +16f/256f, +4f/256f},
        {+6f/256f, +24f/256f, +36f/256f, +24f/256f, +6f/256f},
        {+4f/256f, +16f/256f, +24f/256f, +16f/256f, +4f/256f},
        {+1f/256f, +4f/256f, +6f/256f, +4f/256f, +1f/256f},
    };
    
}
