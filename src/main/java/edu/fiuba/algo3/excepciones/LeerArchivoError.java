package edu.fiuba.algo3.excepciones;

public class LeerArchivoError extends Throwable {
    public LeerArchivoError(String nombreArchivo) {
        super("Error al leer el archivo: " + nombreArchivo);
    }
}
