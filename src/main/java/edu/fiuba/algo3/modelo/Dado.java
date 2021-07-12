package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dado implements Comparable<Dado> {
    private int numero;

    public Dado(int num) {
        this.numero = num;
    }

    public Dado(){
        tirar();
    }

    public static ArrayList<Dado> tirar(int cantidad) {
        ArrayList<Dado> dados = new ArrayList<>();
        for (int i=0; i<cantidad; ++i) dados.add(new Dado());
        return dados;
    }

    public void tirar() {
        Random numeroAleatorio = new Random();
        this.numero = numeroAleatorio.nextInt(6) + 1;
    }

    public int obtenerValor() {
        return this.numero;
    }

    public boolean esMayorQue(Dado unDado) {
        return this.numero > unDado.numero;
    }

    public int compareTo(Dado otroDado){
        return this.numero - otroDado.numero;
    }
}
