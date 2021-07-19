package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;

public class FaseDistribucion{
    int tropasADistribuir;
    Pais paisReforzado;

    public FaseDistribucion(int tropasADistribuir, Pais unPais) {
        this.tropasADistribuir = tropasADistribuir;
        this.paisReforzado = unPais;
    }
    public void colocacionTropas(Pais unPais, int cantidadDeTropas){
        unPais.aumentarTropas(cantidadDeTropas);
    }
}
