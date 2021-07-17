package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.Jugador;

public class FaseAtaque implements Fase {
    Jugador mano;

    public FaseAtaque(Jugador jugadorMano) {
        mano = jugadorMano;
    }

    @Override
    public void iniciar() {

    }
}
