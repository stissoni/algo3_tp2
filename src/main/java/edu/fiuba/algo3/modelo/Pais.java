package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

import java.util.ArrayList;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl;
    private ArrayList<Pais> vecinos;

    public Pais(String nombrePais){
        this.nombrePais = nombrePais;
        this.vecinos = new ArrayList<>();
    }

    public void agregarVecino(Pais pais) {
        vecinos.add(pais);
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

    public Jugador obtenerJugadorEnControl(){
        return this.ejercitoEnControl.obtenerJugador();
    }

    public String obtenerNombrePais(){
        return this.nombrePais;
    }

    public void reagruparEjercito(Ejercito otroEjercito) throws EjercitosDeJugadoresDiferentesException{
        this.ejercitoEnControl.reagruparEjercito(otroEjercito);
    }

    public boolean suEjercitoFueVencido(){
        return this.ejercitoEnControl.obtenerNumeroTotalDeTropas() == 0;
    }
}
