package edu.fiuba.algo3.excepciones;

public class PaisNoExisteError extends Throwable{
    public PaisNoExisteError(String nombrePais) {
        super("No existe el pais: " + nombrePais);
    }
}
