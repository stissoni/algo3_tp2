package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.LinkedList;

public class Jugadores {
    private final LinkedList<Jugador> listaDeJugadores;

    public Jugadores(){
        listaDeJugadores = new LinkedList<>();
    }

    /**Agrega unJugador a la lista de jugadores*/
    public void agregarJugador(Jugador unJugador){
        listaDeJugadores.add(unJugador);
    }

    /**Devuelve el primer jugador de la lista y lo re-acomoda al final de la misma*/
    public Jugador siguienteJugador(){
        Jugador jugadorADevolver = listaDeJugadores.pop();
        listaDeJugadores.add(jugadorADevolver);
        return jugadorADevolver;
    }
    /**Devuelve la cantidad de jugadores de la lista*/
    public int cantidadDeJugadores(){
        return listaDeJugadores.size();
    }

    /**Mezcla al azar la lista de jugadores*/
    public void mezclarJugadores(){
        Collections.shuffle(listaDeJugadores);
    }

    /**Determina si algun jugador de la lista tiene tropas disponibles para colocar*/
    public boolean tienenTropasDisponibles() {
        for (Jugador jugador : listaDeJugadores){
            if (jugador.tieneTropasDisponibles()) return true;
        }
        return false;
    }
}
