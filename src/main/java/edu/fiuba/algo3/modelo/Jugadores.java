package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.LinkedList;

public class Jugadores {
    LinkedList<Jugador> listaDeJugadores;

    public Jugadores(){
        listaDeJugadores = new LinkedList<>();
    }

    public void agregarJugador(Jugador unJugador){
        listaDeJugadores.add(unJugador);
    }

    public Jugador devolverUnJugadorParaAsignar(){
        Jugador jugadorADevolver = listaDeJugadores.pop();
        listaDeJugadores.add(jugadorADevolver);
        return jugadorADevolver;
    }

    public int cantidadDeJugadores(){
        return listaDeJugadores.size();
    }

    public void mezclarJugadores(){
        Collections.shuffle(listaDeJugadores);
    }
}
