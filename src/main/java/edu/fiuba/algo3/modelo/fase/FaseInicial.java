package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.Jugador;

public class FaseInicial implements Fase {
    Jugador mano;

    public FaseInicial(Jugador jugadorMano) {
        mano = jugadorMano;
    }

    @Override
    public void iniciar() {

    }
}
