package edu.fiuba.algo3.modelo;

public class Dado implements Comparable<Dado> {
    private int numero;

    public Dado(int numeroTirada){
        this.numero = numeroTirada;
    }

    public int obtenerValor() {
        return this.numero;
    }

    public boolean esMayorQue(Dado unDado) {
        return this.numero > unDado.numero;
    }

    public boolean esIgualQue(Dado unDado) {
        return this.numero == unDado.numero;
    }

    public int compareTo(Dado otroDado){
        return this.numero - otroDado.numero;
    }
}
