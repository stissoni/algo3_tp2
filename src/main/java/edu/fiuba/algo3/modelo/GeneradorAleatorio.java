package edu.fiuba.algo3.modelo;

import java.util.Random;

public class GeneradorAleatorio {
    public int generar(){
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(6) + 1;
    }

    public int generar(int inicial, int ultimo){
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(ultimo) + inicial;
    }
}
