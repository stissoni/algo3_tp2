package edu.fiuba.algo3.modelo;

import java.util.Random;

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

    public void vencer(Ejercito otroEjercito){
        otroEjercito.reducirTropas(1);
    }

    public int tirarDados(){
        Random numerosAleatorios = new Random();
        return numerosAleatorios.nextInt(7);
    }
}
