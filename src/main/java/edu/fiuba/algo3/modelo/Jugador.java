package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombreJugador;
    private int idJugador;

    public Jugador(String nombre, int id){
        this.nombreJugador = nombre;
        this.idJugador = id;
    }

    public int obtenerId(){
        return this.idJugador;
    }

    public String obtenerNombre(){
        return this.nombreJugador;
    }

    public boolean sonJugadoresDiferentes(Jugador otroJugador){
        return (this.obtenerId() != otroJugador.obtenerId());
    }
}
