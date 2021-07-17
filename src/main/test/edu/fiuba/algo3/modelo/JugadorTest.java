package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadorTest {
    Jugador unJugador;

    @BeforeEach
    public void SetUp(){
        unJugador = new Jugador("Santiago");
    }

    @Test
    public void jugadorSeCreaConNombreCorrecto(){
        assertEquals("Santiago", unJugador.getNombreJugador());
    }

    @Test
    public void jugadorNuevoTieneTropasDisponibles(){
        assertTrue(unJugador.tieneTropasDisponibles());
    }
}
