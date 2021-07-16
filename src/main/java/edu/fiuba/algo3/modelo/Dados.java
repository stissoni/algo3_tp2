package edu.fiuba.algo3.modelo;

public class Dados {

    private static final Dados dados = new Dados();

    public static Dados obtenerDados() {
        return dados;
    }

    public TiradaDeDados tirarUnaCantidadDe(int cantidadDeDados) {
        return new TiradaDeDados(cantidadDeDados);
    }
}
