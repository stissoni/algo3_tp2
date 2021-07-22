package edu.fiuba.algo3.modelo;

import java.util.Hashtable;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class Mapa {
    private Hashtable<String, Continente> continentes;
    private Hashtable<String, Pais> paises;

    public void asignarPaises(Hashtable<String, Pais> paises){
        this.paises = paises;
    }

    public void asignarContinentes(Hashtable<String, Continente> continentes){
        this.continentes = continentes;
    }

    public Pais obtenerUnPais(String nombrePais){
        return this.paises.get(nombrePais);
    }

    public Continente obtenerUnContinente(String nombreContinente){
        return this.continentes.get(nombreContinente);
    }

    public void colocarEjercitoEn(String nombrePais, Jugador unJugador, int numeroEjercitos) throws EjercitosDeJugadoresDiferentesException{
        Pais unPais = this.obtenerUnPais(nombrePais);
        Ejercito nuevoEjercito = new Ejercito(numeroEjercitos, unJugador);
        unPais.agregarEjercito(nuevoEjercito);
    }
}
