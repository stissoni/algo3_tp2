package edu.fiuba.algo3.excepciones;

public class EjercitoYaVencidoException extends Throwable {
    private final int id = 4;
    private final String mensajeError = "No se pueden reagrupar ejercitos de jugadores diferentes.";

    public String obtenerMensajeError(){
        return this.mensajeError;
    }

    public int obtenerCodigoError(){
        return this.id;
    }
}