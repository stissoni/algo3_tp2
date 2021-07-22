package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.*;

public class Partida {
    private ArrayList<Jugador> jugadores;
    private Mapa mapaDelJuego;
    int indexJugadorActual;

    public Partida(){
        this.jugadores = new ArrayList<Jugador>();
        this.indexJugadorActual = 0;
    }

    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }

    public void crearMapa() throws IOException{
        Director director = new Director();
        MapaBuilder builder = new MapaBuilder();
        director.crearMapa(builder);
        this.mapaDelJuego = builder.obtenerResultado();
    }

    public void siguienteJugador(){
        if (this.indexJugadorActual + 1 == this.jugadores.size()){
            this.indexJugadorActual = 0;
        }
        else {
            this.indexJugadorActual = this.indexJugadorActual + 1;
        }
    }

    public void colocarEjercitos(String paisDestino, int numeroTropas) throws Throwable{
        MovimientoColocacion movimiento = new MovimientoColocacion();
        Pais pais = mapaDelJuego.obtenerUnPais(paisDestino);
        Jugador jugadorActual = this.jugadores.get(this.indexJugadorActual);
        Ejercito ejercitoAColocar = new Ejercito(numeroTropas, jugadorActual);

        movimiento.destinoPais(pais);
        movimiento.ejercitoAColocar(ejercitoAColocar);
        movimiento.ejecutar();
    }

    public Mapa obtenerMapa(){
        return this.mapaDelJuego;
    }
}

