package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl; 

    public Pais(String nombrePais, Ejercito ejercito){
        this.nombrePais = nombrePais;
        this.ejercitoEnControl = ejercito;
    }

    public void atacarA(Pais otroPais){
        Batalla batallaEntrePaises = new Batalla(this, otroPais);
        batallaEntrePaises.luchar();
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

    public void vencer(Pais otroPais){
        this.ejercitoEnControl.vencer(otroPais.obtenerEjercito());
    }

    public Jugador obtenerJugadorEnControl(){
        return this.ejercitoEnControl.obtenerJugador();
    }

    public String obtenerNombrePais(){
        return this.nombrePais;
    }
}
