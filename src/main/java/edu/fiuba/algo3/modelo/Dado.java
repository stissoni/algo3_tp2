package edu.fiuba.algo3.modelo;

public class Dado implements Comparable<Dado> {
    private int numero;
    private GeneradorAleatorio generador;

    public Dado(GeneradorAleatorio generador){
        this.generador = generador;
    }

    public void tirar() {
        this.numero = this.generador.generar();
    }

    public int obtenerValor() {
        return this.numero;
    }

    public boolean esMayorQue(Dado unDado) {
        return this.numero > unDado.numero;
    }

    public boolean esMayorOIgualQue(Dado unDado) {
        return this.numero >= unDado.numero;
    }

    public int compareTo(Dado otroDado){
        return this.numero - otroDado.numero;
    }
}
