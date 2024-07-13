package paq.interfaces;

/**
 *
 * @author Jesu
 */
public interface Mensajes {
    // Confirmación
    public final String IMAGENCARGADA_STRING = "La imagen ha sido cargada de manera exitosa.";
    public final String MATRIZCONV_STRING = "La matriz de convolución ha sido cargada de manera exitosa.";
    
    // Errores
    public final String ERRORNULLPOINTER_STRING = "La ruta propuesta es inválida.";
    public final String ERRORIMAGEN_STRING = "Error al abrir imagen.";
    
    public final String ERRORMATRIZNULA_STRING = "¡La matriz propuesta es nula!";
    public final String ERRORCUADRADO_STRING = "¡La matriz convolutiva no es cuadrada!";
    
}
