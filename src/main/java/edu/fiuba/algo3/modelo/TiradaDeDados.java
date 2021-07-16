package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

;

public class TiradaDeDados {

    private int[] numeros;

    public TiradaDeDados(int unaCantidadDeDados) {
        Random numeroAleatorio = new Random();
        numeros = numeroAleatorio.ints(unaCantidadDeDados, 1, 7).toArray();
    }

    private void ordenar() {
        numeros = Arrays.stream(numeros).sorted().toArray();
    }

    // solo para verificar funcionamiento
    public void imprimirTirada() {
        for(int num: numeros) System.out.println(num);
        System.out.println();
    }

    public int cantidadDeValoresMasAltosQue(TiradaDeDados otraTirada) {
        this.ordenar();
        otraTirada.ordenar();
        int cant = 0;
        for (int i=0; i<numeros.length; ++i) {
            if (numeros[i]>otraTirada.numeros[i]) {
                cant++;
            }
        }
        return cant;
    }
}
