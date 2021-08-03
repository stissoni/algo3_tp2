package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MazoPaises {
    ArrayList<CartaPais> mazoDeTarjetas;

    public MazoPaises() {
        mazoDeTarjetas = new ArrayList<CartaPais>();
    }

    void agregarCarta(CartaPais nuevaCarta) {
        mazoDeTarjetas.add(nuevaCarta);
    }

    public int numeroDeCartas(){
        return this.mazoDeTarjetas.size();
    }

    public CartaPais obtenerSiguienteCarta(){
        return this.mazoDeTarjetas.remove(0);
    }

    public void agregarAlFondo(CartaPais carta){
        this.mazoDeTarjetas.add(carta);
    }
}
