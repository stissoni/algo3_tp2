package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.modelo.fase.FaseAtaque;
import edu.fiuba.algo3.modelo.fase.FaseDistribucion;

import java.util.ArrayList;

public class Turno {
    private Jugador jugadorActivo;
    private final Jugadores listaDeJugadores;

    public Turno(Jugadores listaDeJugadores){
        this.listaDeJugadores = listaDeJugadores;
        siguienteJugador();
    }

    public void siguienteJugador(){
        jugadorActivo = listaDeJugadores.siguienteJugador();
    }


    public void atacarConNTropasA(Pais paisAtacante, int tropasAtacantes, Pais paisDefensor, ArrayList<Dado> dadosAtaque, ArrayList<Dado> dadosDefensa) throws EjercitoYaVencidoException {
        FaseAtaque faseAtaque = new FaseAtaque(paisAtacante,paisDefensor,tropasAtacantes);
        faseAtaque.atacar(dadosAtaque,dadosDefensa);
    }

    public void distribuirTropas(int tropasADistribuir, Pais unPais) {
        FaseDistribucion faseDist = new FaseDistribucion(tropasADistribuir,unPais);
        faseDist.colocacionTropas(unPais,tropasADistribuir);
    }

    public void cambiarJugadorActivo(Jugador unJugador) {
        this.jugadorActivo = unJugador;
    }
}
