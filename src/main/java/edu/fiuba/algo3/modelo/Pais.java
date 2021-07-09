package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl; 

    public Pais(String nombrePais, Ejercito ejercito){
        this.nombrePais = nombrePais;
        this.ejercitoEnControl = ejercito;
    }

    public Ejercito obtenerEjercito(){
        return this.ejercitoEnControl;
    }

    public void entregarControlAlEjercito(Ejercito nuevoEjercito){
        this.ejercitoEnControl = nuevoEjercito;
    }

    public int obtenerNumeroTotalDeTropas(){
        return this.ejercitoEnControl.obtenerNumeroTotalDeTropas();
    }

    public void vencer(Pais otroPais) throws EjercitoYaVencidoException{
        this.ejercitoEnControl.vencer(otroPais.obtenerEjercito());
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
}
