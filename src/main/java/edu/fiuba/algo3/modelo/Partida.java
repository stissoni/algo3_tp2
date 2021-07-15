package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.*;


public class Partida {
    private final ArrayList<Jugador> listaDeJugadores;
    private Mapa mapa;

    public Partida(ArrayList<Jugador> listaDeJugadores) {
        this.listaDeJugadores = listaDeJugadores; //Limitar a 2-6 jugadores.
        //listaDeJugadores = crearJugadores();
        mapa = new Mapa("src/main/java/edu/fiuba/algo3/modelo/paises.csv");
//        mapa.repartirOcupacionDePaises(listaDeJugadores);
    }

    /*Método de Prueba*/
    public boolean partidaSeCreaConNJugadores(int n){
        int cantJugadores = listaDeJugadores.size();
        return cantJugadores == n;
    }
}
