package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void jugadorEligeCorrectamenteUnPaisDeLosQueControla(){
        Pais argentina = new Pais("Argentina");
        argentina.ocuparPor(unJugador);

        assertEquals(argentina,unJugador.elegirPais("Argentina"));
    }

    @Test
    public void jugadorIntentaElegirPaisQueNoControla(){
        assertNull(unJugador.elegirPais("Argentina"));
    }
}
