
package paq.clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import paq.interfaces.Mensajes;

/*
 * @author Jesu
 */
public abstract class ConvolucionImagen extends Matriz implements Mensajes{
    // Atributos
    private BufferedImage imagen;
    private int alto, ancho;
    private int matrizRGB[][];
    private double matrizConvolucion[][];
    private int extension;
    
    // Constructores
    public ConvolucionImagen(BufferedImage imagen) {        
        // Creación de la matriz
        this.imagen = imagen;
        if (this.imagen != null) {
            this.ancho = imagen.getWidth(); 
            this.alto = imagen.getHeight();
            generarMatrizRGB();
        } else this.matrizRGB = null;
    }
    
    public ConvolucionImagen(String rutaString) {        
        // Creación de la matriz
        this.imagen = cargarImagen(rutaString);
        if (this.imagen != null) {
            this.ancho = imagen.getWidth(); 
            this.alto = imagen.getHeight();
            generarMatrizRGB();
        } else this.matrizRGB = null;
    }
    
    // Métodos    
    public static BufferedImage cargarImagen(String rutaString){
        BufferedImage imagen;
        try {
            File rutaArchivo = new File(rutaString);
            imagen = ImageIO.read(rutaArchivo);
            JOptionPane.showMessageDialog(null, IMAGENCARGADA_STRING, "Matriz Imagen", 1);
        }
        catch (NullPointerException | IOException e) {
            String mensaje = (e instanceof NullPointerException)? ERRORIMAGEN_STRING: ERRORNULLPOINTER_STRING;
            JOptionPane.showMessageDialog(null, e + "\n" + mensaje, "Matriz Imagen", 0);
            return null;
        }
        return imagen;
    }
    
    private void generarMatrizRGB(){
        if (getImagen() != null){
            this.matrizRGB = new int[getAlto()][getAncho()];
            for(int y = 0; y < getAlto(); y++){
                for(int x = 0; x < getAncho(); x++) {
                    int p = getImagen().getRGB(x,y);
                    matrizRGB[y][x] = p;
                }
            }
        } else JOptionPane.showMessageDialog(null, ERRORIMAGEN_STRING, "Matriz Imagen", 0);
        
    }
    
    protected int[][] extenderMatrizConCeros(int[][] matriz){
        int matrizAlto, matrizAncho;
        // En caso se desee usar el atributo matrizRGB en lugar de una matriz alterna.
        if (!esNula(matriz)){
            matrizAlto = matriz.length;
            matrizAncho = matriz[0].length;
        } else {
            matriz = getMatrizRGB();
            matrizAlto = getAlto();
            matrizAncho = getAncho();
        }

        int ext = getExtension();
        int[][] matrizExtendida = new int[matrizAlto + ext][matrizAncho + ext];
        // Recorrer la imagen por sus valores ARGB.
        for(int y = ext/2; y < matrizAlto + (ext/2); y++){
            for(int x = ext/2; x < matrizAncho + (ext/2); x++){
                int p = matriz[y-ext/2][x-ext/2];
                matrizExtendida[y][x] = p;
            }
        }
        return matrizExtendida;
    }
    
    public void cargarMatrizConvolucion(double[][] matrizConvolucion){
        if (!esNula(matrizConvolucion)) {
            if (esMatrizCuadrada(matrizConvolucion)) {
                this.matrizConvolucion = matrizConvolucion;
                this.extension = matrizConvolucion.length-1;
                JOptionPane.showMessageDialog(null, MATRIZCONV_STRING, "Matriz Imagen", 1);
            } else JOptionPane.showMessageDialog(null, ERRORCUADRADO_STRING, "Matriz Imagen: Error", 0);
        } else JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
        
    }
    
    // Método para el filtrado de la imagen: dependiendo del filtro (método abstracto).
    public abstract int[][] generarConvolucion();
    
    // Getters & Setters
    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int[][] getMatrizRGB() {
        return matrizRGB;
    }

    public void setMatrizRGB(int[][] matrizRGB) {
        this.matrizRGB = matrizRGB;
    }

    public double[][] getMatrizConvolucion() {
        return matrizConvolucion;
    }

    public void setMatrizConvolucion(double[][] matrizConvolucion) {
        this.matrizConvolucion = matrizConvolucion;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }
    
}
