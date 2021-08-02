package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;
import edu.fiuba.algo3.excepciones.PaisSinEjercitoException;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl;
    private ArrayList<String> paisesLimitrofes;

    public Pais(String nombrePais){
        this.nombrePais = nombrePais;
        this.paisesLimitrofes = new ArrayList<String>();
    }

    public Pais(){
        this.paisesLimitrofes = new ArrayList<String>();
    }

    public void asignarNombre(String unNombre){
        this.nombrePais = unNombre;
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

    public boolean esDominadoPorJugador(Jugador unJugador){
        try{
            return this.obtenerJugadorEnControl().sonElMismoJugador(unJugador);
        }
        catch (PaisSinEjercitoException e) {
            return false;
        }
    }

    public Jugador obtenerJugadorEnControl() throws PaisSinEjercitoException{
        if (this.ejercitoEnControl == null){
            throw new PaisSinEjercitoException("No hay jugador controlando este pais.");
        }
        return this.ejercitoEnControl.obtenerJugador();
    }

    public String obtenerNombrePais(){
        return this.nombrePais;
    }

    public ArrayList<String> obtenerPaisesLimitrofes(){
        return this.paisesLimitrofes;
    }

    public void agregarEjercito(Ejercito unEjercito) throws EjercitosDeJugadoresDiferentesException{
        if (this.ejercitoEnControl == null){
            this.asignarEjercito(unEjercito);
        }
        else {
            this.reagruparEjercito(unEjercito);
        }
    }

    public String obtenerNombrePaisLimitrofe(int posicion) { return paisesLimitrofes.get(posicion); }


    public void agregarPaisLimitrofe(String unPais){
        this.paisesLimitrofes.add(unPais);
    }

    public int cantidadDePaisesLimitrofe(){
        return this.paisesLimitrofes.size();
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
