package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

import java.util.ArrayList;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl;
    private ArrayList<Pais> limitrofes;

    public Pais(String nombrePais){
        this.nombrePais = nombrePais;
        limitrofes = new ArrayList<>();
    }

    public Ejercito obtenerEjercito(){
        return this.ejercitoEnControl;
    }

    public void asignarEjercito(Ejercito nuevoEjercito){
        this.ejercitoEnControl = nuevoEjercito;
    }

    public int obtenerNumeroTotalDeTropas(){
        return this.ejercitoEnControl.obtenerNumeroTotalDeTropas();
    }

    public void agregarPaisLimitrofe(Pais unPais){
        if (!limitrofes.contains(unPais)) limitrofes.add(unPais);
    }

    public Jugador obtenerJugadorEnControl(){
        return this.ejercitoEnControl.obtenerJugador();
    }

    public String obtenerNombrePais(){
        return this.nombrePais;
    }

    public void reagruparEjercito(Ejercito otroEjercito){
        this.ejercitoEnControl.reagruparEjercito(otroEjercito);
    }

    public boolean suEjercitoFueVencido(){
        return this.ejercitoEnControl.obtenerNumeroTotalDeTropas() == 0;
    }

    public boolean tieneElMismoNombre(String nombrePais) {
        return nombrePais.equals(this.nombrePais);
    }

    public void ocuparPor(Jugador unJugador) {
        int numeroDeTropasInicial = 1;
        ejercitoEnControl = new Ejercito(numeroDeTropasInicial,unJugador);
        unJugador.agregarPaisOcupado(this);
    }

    /**Metodo de prueba unicamente*/
    public void ganarControlPor(Ejercito unEjercitoVictorioso) {
        Ejercito ejercitoPerdedor = ejercitoEnControl;
        ejercitoPerdedor.entregarControlDelPais(this);
        ejercitoEnControl = unEjercitoVictorioso;
        unEjercitoVictorioso.obtenerControlDelPais(this);
    }

    /**Metodo de prueba unicamente*/
    public boolean estaOcupadoPor(Jugador unJugador) {
        return ejercitoEnControl.perteneceA(unJugador);
    }

    public void aumentarTropas(int tropasADistribuir) {
        ejercitoEnControl.aumentarTropas(tropasADistribuir);
    }
}
