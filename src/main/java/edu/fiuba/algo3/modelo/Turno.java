package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turno {
    // SINGLETON
    // Necesidad de Singleton: una unica instancia, esta controlara los turnos.
    ArrayList<Jugador> jugadores;
    int indexJugadorActual;
    int indexJugadorInicial;

    public Turno(ArrayList<Jugador> jugadores, int jugadorInicial){
        this.jugadores = jugadores;
        this.indexJugadorActual = jugadorInicial;
        this.indexJugadorInicial = jugadorInicial;
    }

    public void siguienteTurno(){
        if (this.indexJugadorActual + 1 == this.jugadores.size()){
            this.indexJugadorActual = 0;
        }
        else {
            this.indexJugadorActual = this.indexJugadorActual + 1;
        }
    }

    public Jugador jugadorTurno(){
        return jugadores.get(indexJugadorActual);
    }

    public int obtenerNumeroJugadores(){
        return this.jugadores.size();
    }

    public void reiniciar(){
        this.indexJugadorActual = this.indexJugadorInicial;
    }
}
