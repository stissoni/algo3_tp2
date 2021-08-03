package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.excepciones.PaisSinEjercitoException;

public class Continente {
    private ArrayList<Pais> paises;
    private String nombre;

    public Continente(){
        this.paises = new ArrayList<Pais>();
    }

    public void asignarNombre(String unNombre){
        this.nombre = unNombre;
    }

    public void agregarPais(Pais unPais){
        this.paises.add(unPais);
    }

    public String obtenerNombre(){
        return this.nombre;
    }

    public boolean sonElMismoContinente(Continente otroContinente){
        return this.nombre == otroContinente.nombre;
    }

    public boolean esDominadoPorJugador(Jugador unJugador){
        for(Pais pais: this.paises){
            if (!pais.esDominadoPorJugador(unJugador)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Pais> obtenerPaises(){
        return this.paises;
    }

    public int numeroPaisesDominadosPor(Jugador unJugador){
        int numeroPaises = 0;
        for (Pais pais: this.paises){
            try{
                Jugador jugadorControlando = pais.obtenerJugadorEnControl();
                if (jugadorControlando.sonElMismoJugador(unJugador)){
                   numeroPaises = numeroPaises + 1;
                }
            }
            catch (PaisSinEjercitoException e){
                continue;
            }
        }
        return numeroPaises;
    }
}
