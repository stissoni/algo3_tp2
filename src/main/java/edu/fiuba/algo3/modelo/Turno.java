package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.fase.FaseAtaque;
import edu.fiuba.algo3.modelo.fase.FaseDistribucion;
import edu.fiuba.algo3.modelo.fase.FaseInicial;

public class Turno {
    private Fase fase;
    private Jugador jugadorActivo;
    private final Jugadores listaDeJugadores;

    public Turno(Jugadores listaDeJugadores){
        this.listaDeJugadores = listaDeJugadores;
        fase = new FaseInicial(jugadorActivo);
        siguienteJugador();
    }

    public void siguienteJugador(){
        jugadorActivo = listaDeJugadores.siguienteJugador();
    }

    public void setFase(Fase unaFase){
        fase = unaFase;
    }

    public void jugar(){
        fase.iniciar();
    }

    public void siguienteTurno(){
        siguienteJugador();
        setFase(new FaseAtaque(jugadorActivo));
    }

    public void distribuirTropas(int tropasADistribuir, Pais unPais) {
        FaseDistribucion faseDist = new FaseDistribucion(tropasADistribuir,unPais);
        setFase(faseDist);
        jugar();
    }

    public void cambiarJugadorActivo(Jugador unJugador) {
        this.jugadorActivo = unJugador;
    }
}
