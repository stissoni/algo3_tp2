package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl;

    public Pais(String nombrePais){
        this.nombrePais = nombrePais;
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

    public void reducirTropas(int numeroDeTropas) throws Throwable{
        this.ejercitoEnControl.reducirTropas(numeroDeTropas);
    }

    public void reagruparEjercito(Ejercito otroEjercito) throws EjercitosDeJugadoresDiferentesException{
        this.ejercitoEnControl.reagruparEjercito(otroEjercito);
    }

    public boolean suEjercitoFueVencido(){
        return this.ejercitoEnControl.obtenerNumeroTotalDeTropas() == 0;
    }

    public Ejercito ejercitoParaAtacar(int numeroDeTropas) throws Throwable{
        this.reducirTropas(numeroDeTropas);
        return new Ejercito(numeroDeTropas, this.obtenerJugadorEnControl());
    }
}
