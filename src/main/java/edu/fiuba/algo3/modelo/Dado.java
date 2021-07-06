package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado implements Comparable<Dado> {
    private int numeroDeLaTirada;

    public Dado(int numero){
        this.numeroDeLaTirada = numero;
    }

    public Dado(){
        
    }

    public void tirarDado(){
        Random numerosAleatorios = new Random();
        this.numeroDeLaTirada = (1 + numerosAleatorios.nextInt(6));
    }

    public int obtenerNumeroDeTirada(){
        return this.numeroDeLaTirada;
    }

    public boolean esMayorQue(Dado otroDado){
        return (this.obtenerNumeroDeTirada() > otroDado.obtenerNumeroDeTirada());
    }

    public int compareTo(Dado otroDado){
        if (this.obtenerNumeroDeTirada() == otroDado.obtenerNumeroDeTirada()){
            return 0;
        }
        if (this.obtenerNumeroDeTirada() > otroDado.obtenerNumeroDeTirada()){
            return 1;
        }
        else {
            return -1;
        }
    }
}
