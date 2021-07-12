package edu.fiuba.algo3.excepciones;

public class VerticeNoExisteError extends Throwable {

    public VerticeNoExisteError(String vertice) {
        super("No existe el vertice: " + vertice);
    }
}
