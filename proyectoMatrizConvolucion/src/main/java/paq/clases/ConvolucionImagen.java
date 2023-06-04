
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
public class ConvolucionImagen extends Matriz implements Mensajes{
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
        this.ancho = imagen.getWidth(); 
        this.alto = imagen.getHeight();
        generarMatrizRGB();
    }
    
    public ConvolucionImagen(String rutaString) {        
        // Creación de la matriz
        this.imagen = cargarImagen(rutaString);
        this.ancho = imagen.getWidth(); 
        this.alto = imagen.getHeight();
        generarMatrizRGB();
    }
    
    // Métodos utilitarios
    private void generarMatrizRGB(){
        this.matrizRGB = new int[getAlto()][getAncho()];
        for(int y = 0; y < getAlto(); y++){
            for(int x = 0; x < getAncho(); x++) {
                int p = getImagen().getRGB(x,y)&0xFF;
                matrizRGB[y][x] = p;
            }
        }
    }
    
    private int[][] extenderMatrizRGB(){
        // Validación de datos
        if (esNula(getMatrizConvolucion()) || esNula(getMatrizRGB())){
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: extender matriz", 0);
            return null;
        }
        int ext = getExtension();
        int[][] matrizExtendida = new int[getAlto()+ext][getAncho()+ext];
        // Recorrer la imagen por sus valores ARGB.
        for(int y = ext/2; y < getAlto()+ext/2; y++){
            for(int x = ext/2; x < getAncho()+ext/2; x++){
                int p = getMatrizRGB()[y-ext/2][x-ext/2];
                matrizExtendida[y][x] = p;
            }
        }
        return matrizExtendida;
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
    
    public void cargarMatrizConvolucion(double[][] matrizConvolucion){
        if (!esNula(matrizConvolucion)) {
            if (esMatrizCuadrada(matrizConvolucion)) {
                this.matrizConvolucion = matrizConvolucion;
                this.extension = matrizConvolucion.length-1;
                JOptionPane.showMessageDialog(null, MATRIZCONV_STRING, "Matriz Imagen", 1);
            } else JOptionPane.showMessageDialog(null, ERRORCUADRADO_STRING, "Matriz Imagen: Error", 0);
        } else JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
        
    }
    
    public int[][] generarConvolucion(){
        // Validación de datos
        if (esNula(getMatrizConvolucion()) || esNula(getMatrizRGB())){
            JOptionPane.showMessageDialog(null, ERRORMATRIZNULA_STRING, "Matriz Imagen: Error", 0);
            return null;
        }
        
        // Inicio de algoritmo
        int[][] matrizRGBext = extenderMatrizRGB();
        int[][] matrizResultado = new int[getAlto()][getAncho()];
        
        int n = getMatrizConvolucion().length;
        // Para recorrer la imagen
        for (int y = getExtension()/2; y < getAlto()+getExtension()/2; y++) {
            for (int x = getExtension()/2; x < getAncho()+getExtension()/2; x++) {
                if(x < getExtension() || y < getExtension() || x >= getAncho() || y >= getAlto()) {
                    matrizResultado[y-getExtension()/2][x-getExtension()/2] = 0;
                    continue;
                }
                // Para analizar submatrices y multiplicarlas por la matriz de convolución
                int sumaProd = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sumaProd += matrizRGBext[y-(getExtension()/2)+i][x-(getExtension()/2)+j] * getMatrizConvolucion()[i][j];
                    }
                }
                matrizResultado[y-getExtension()/2][x-getExtension()/2] = sumaProd;
            }
        }
        return matrizResultado;
    }
    
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
