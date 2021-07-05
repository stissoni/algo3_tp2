package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JugadorTest {
    
    @Test
    public void testNombreYJugadorId(){
        Jugador unJugador = new Jugador("Santiago", 1);

        assertEquals("Santiago", unJugador.obtenerNombre());
        assertEquals(1, unJugador.obtenerId());
    }
}
