package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final String nombreJugador;
    private int tropasDisponibles;
    private ArrayList<Pais> paisesOcupados;


    public Jugador(String nombre){
        final int tropasIniciales = 5;
        nombreJugador = nombre;
        tropasDisponibles = tropasIniciales;
        paisesOcupados = new ArrayList<>();
    }

    public int getTropasDisponibles() {
        return tropasDisponibles;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public boolean tieneTropasDisponibles() {
        return tropasDisponibles>0;
    }

    public void agregarPaisOcupado(Pais pais) {
        paisesOcupados.add(pais);
    }

    public void quitarPaisPerdido(Pais pais) {
        paisesOcupados.remove(pais);
    }

    public void reducirtropasDisponibles(int numeroDeTropasARestar) {
        tropasDisponibles -= numeroDeTropasARestar;
    }
}
