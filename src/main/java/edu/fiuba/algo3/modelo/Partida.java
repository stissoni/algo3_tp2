package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class Partida {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pais> paises;

    public Partida(ArrayList<Jugador> listaDeJugadores){
        this.jugadores = new ArrayList<Jugador>();
    }

    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }

    public void agregarPais(Pais unPais){
        this.paises.add(unPais);
    }

    public void agregarEjercito(Ejercito unEjercito, Pais unPais) throws EjercitosDeJugadoresDiferentesException{
        unPais.agregarEjercito(unEjercito);
    }
}
