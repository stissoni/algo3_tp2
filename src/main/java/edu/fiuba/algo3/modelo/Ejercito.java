package edu.fiuba.algo3.modelo;

public class Ejercito {
    private int numeroDeTropas;

    public Ejercito(int nuevoNumeroDeTropas){
        this.numeroDeTropas = nuevoNumeroDeTropas;
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

    public void atacar(int numeroDeTropas, Ejercito otroEjercito){
        Batalla batalla = new Batalla(this, numeroDeTropas, otroEjercito);
    }
}
