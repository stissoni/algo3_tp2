package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {
    Turno unTurno;
    Jugadores listaDePersonas;
    Jugador jugador1;
    Jugador jugador2;

    @BeforeEach
    public void SetUp(){
        listaDePersonas = new Jugadores();
        jugador1 = new Jugador("Matias");
        jugador2 = new Jugador("Santiago");
        listaDePersonas.agregarJugador(jugador1);
        listaDePersonas.agregarJugador(jugador2);
        unTurno = new Turno(listaDePersonas);
    }
}