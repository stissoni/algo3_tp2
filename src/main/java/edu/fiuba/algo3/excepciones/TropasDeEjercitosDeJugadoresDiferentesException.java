package edu.fiuba.algo3.excepciones;

public class TropasDeEjercitosDeJugadoresDiferentesException {
    private final int id = 3;
    private final String mensajeError = "No se pueden reagrupar ejercitos de jugadores diferentes.";

    public String obtenerMensajeError(){
        return this.mensajeError;
    }

    public int obtenerCodigoError(){
        return this.id;
    }
}
