package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PartidaTest {
    @Test
    public void testColocarEjercitos() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();

        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);

        int numeroTropas = 3;
        unaPartida.colocarEjercitos("Argentina", numeroTropas);
        unaPartida.siguienteJugador();
        unaPartida.colocarEjercitos("Chile", numeroTropas);

        // Pablo me mata cuando vea esto...
        assertEquals(jugador1, unaPartida.obtenerMapa().obtenerUnPais("Argentina").obtenerJugadorEnControl());
        assertEquals(jugador2, unaPartida.obtenerMapa().obtenerUnPais("Chile").obtenerJugadorEnControl());
    }
}
