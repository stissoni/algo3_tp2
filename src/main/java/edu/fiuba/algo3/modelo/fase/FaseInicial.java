package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;

public class FaseInicial {
    Jugador jugadorMano;

    public FaseInicial(Jugador jugadorMano) {
        this.jugadorMano = jugadorMano;
    }

    /** Otorga las 3 primeras tropas de la ronda de colocacion*/
    public void otorgarTropasIniciales(){
        int tropasAOtorgar = 3;
        jugadorMano.aumentartropasDisponibles(tropasAOtorgar);
    }

    /** Coloca tropas en un país*/
    public void colocacionTropas(Pais unPais, int cantidadDeTropas){
        unPais.aumentarTropas(cantidadDeTropas);
    }
}
