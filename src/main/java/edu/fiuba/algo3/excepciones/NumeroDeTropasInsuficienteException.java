package edu.fiuba.algo3.excepciones;

public class NumeroDeTropasInsuficienteException extends Exception{
    private final int id = 1;
    private final String mensajeError = "No hay suficientes topas.";

    public String obtenerMensajeError(){
        return this.mensajeError;
    }

    public int obtenerCodigoError(){
        return this.id;
    }
}
