package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class MapaBuilderTest {
    @Test
    public void testCreacionDeMapa() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();

        Mapa mapa = mapaBuilder.obtenerResultado();
        
        assertEquals(50, mapa.numeroPaises());
        assertEquals(6, mapa.numeroContinentes());

        Pais argentina = mapa.obtenerUnPais("Argentina");

        assertEquals("Argentina", argentina.obtenerNombrePais());
    }
}
