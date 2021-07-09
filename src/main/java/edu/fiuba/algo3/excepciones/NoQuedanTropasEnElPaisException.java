package edu.fiuba.algo3.excepciones;

public class NoQuedanTropasEnElPaisException extends Throwable {
    private final int id = 2;
    private final String mensajeError = "No quedaron tropas en el pais atacante.";

    public String obtenerMensajeError(){
        return this.mensajeError;
    }

    public int obtenerCodigoError(){
        return this.id;
    }
}
