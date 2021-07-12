package edu.fiuba.algo3.excepciones;

public class EjercitoYaVencidoException extends Throwable {
    public EjercitoYaVencidoException(String mensajeError, Throwable causa){
        super(mensajeError, causa);
    }
}