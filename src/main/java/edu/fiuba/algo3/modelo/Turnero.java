package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turnero {
    // SINGLETON
    // Necesidad de Singleton: una unica instancia, esta controlara los turnos
    private static Turnero instancia;
    private ArrayList<Jugador> jugadores;
    private int indexJugadorActual;
    private int indexJugadorInicial;

    private Turnero(){
        this.jugadores = new ArrayList<Jugador>();
    }
    
    public static Turnero getInstance(){
        if (instancia == null){
            return new Turnero();
        }
        else {
            return instancia;
        }
    }
    
    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }

    public void jugadorInicial(int index){
        this.indexJugadorActual = index;
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

    public ArrayList<Jugador> obtenerJugadores(){
        return this.jugadores;
    }
}
