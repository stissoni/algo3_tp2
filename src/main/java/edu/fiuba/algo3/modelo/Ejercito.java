package edu.fiuba.algo3.modelo;

public class Ejercito {
    private int numeroDeTropas;
    private Jugador jugador;

    public Ejercito(int nuevoNumeroDeTropas, Jugador jugador){
        this.numeroDeTropas = nuevoNumeroDeTropas;
        this.jugador = jugador;
    }

    public void reducirTropas(int numeroDeTropasARestar){
        this.numeroDeTropas = this.numeroDeTropas - numeroDeTropasARestar;
    }

    public void aumentarTropas(int numeroDeTropasASumar){
        this.numeroDeTropas = this.numeroDeTropas + numeroDeTropasASumar;
    }

    public int obtenerNumeroTotalDeTropas(){
        return this.numeroDeTropas;
    }

    public void vencer(Ejercito otroEjercito){
        otroEjercito.reducirTropas(1);
    }

    public Jugador obtenerJugador(){
        return this.jugador;
    }

    public void controlarPais(Pais elPaisAControlar){
        elPaisAControlar.entregarControlAlEjercito(this);
    }
}
