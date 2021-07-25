package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.*;

public class Partida {
    private ArrayList<Jugador> jugadores;
    private Mapa mapaDelJuego;
    private Fase faseActual;
    private Turno turno;

    public Partida(){
        this.jugadores = new ArrayList<Jugador>();
    }

    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }

    public void iniciarPartida() throws Throwable{
        this.turno = new Turno(this.jugadores, 0);
        this.faseActual = new FaseInicial();
        this.faseActual.asignarPartida(this);
        this.faseActual.iniciarFase();
    }

    public void reiniciarTurno(){
        this.turno.reiniciar();
    }

    public void crearMapa() throws IOException{
        Director director = new Director();
        MapaBuilder builder = new MapaBuilder();
        director.crearMapa(builder);
        this.mapaDelJuego = builder.obtenerResultado();
    }

    public void asignarFase(Fase unaFase){
        this.faseActual = unaFase;
    }

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable{
        this.faseActual.ejecutarMovimiento(unMovimiento);
    }

    public Turno obtenerTurnero(){
        return this.turno;
    }

    public int obtenerNumeroJugadores(){
        return this.turno.obtenerNumeroJugadores();
    }

    public Jugador obtenerJugadorActual(){
        return this.turno.jugadorTurno();
    }

    public void siguienteTurno(){
        this.turno.siguienteTurno();
    }

    public ArrayList<Pais> obtenerPaises(){
        return this.mapaDelJuego.obtenerPaises();
    }

    public Mapa obtenerMapa(){
        return this.mapaDelJuego;
    }
}

