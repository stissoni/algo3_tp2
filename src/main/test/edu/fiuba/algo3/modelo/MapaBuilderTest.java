package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class MapaBuilderTest {
    @Test
    public void testCreacionDeMapa() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();
        mapaBuilder.asignarPaisesLimitrofes();

        Mapa mapa = mapaBuilder.obtenerResultado();
        
        assertEquals(50, mapa.numeroPaises());
        assertEquals(6, mapa.numeroContinentes());

        Pais chile = mapa.obtenerUnPais("Chile");

        assertEquals("Chile", chile.obtenerNombrePais());
        assertEquals(3, chile.obtenerNumeroDePaisesLimitrofes());
        for (Pais paisLimitrofe: chile.obtenerLimitrofes()){
            System.out.println(paisLimitrofe.obtenerNombrePais());
        }
    }

    @Test
    public void testPaisesLimitrofes() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();
        mapaBuilder.asignarPaisesLimitrofes();

        Mapa mapa = mapaBuilder.obtenerResultado();

        Pais siberia = mapa.obtenerUnPais("Siberia");
        Pais tartaria = mapa.obtenerUnPais("Tartaria");

        assertTrue(siberia.esLimitrofeDe(tartaria));
        assertTrue(tartaria.esLimitrofeDe(siberia));
    }

    @Test
    public void testPaisesEnSusContinentes() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();
        mapaBuilder.asignarPaisesLimitrofes();
        mapaBuilder.asignarPaisesAContinentes();

        Mapa mapa = mapaBuilder.obtenerResultado();

        Continente europa = mapa.obtenerUnContinente("Europa");

        assertEquals(9, europa.obtenerPaises().size());

        Pais islandia = europa.obtenerPaises().get(0);
        Pais suecia = europa.obtenerPaises().get(8);

        assertTrue(islandia.esLimitrofeDe(suecia));
    }

    @Test
    public void testTropasAdicionalesDePaises() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();
        mapaBuilder.asignarPaisesLimitrofes();
        mapaBuilder.asignarPaisesAContinentes();

        Mapa mapa = mapaBuilder.obtenerResultado();
        Continente europa = mapa.obtenerUnContinente("Europa");
        Continente asia = mapa.obtenerUnContinente("Asia");
        Continente americaSur = mapa.obtenerUnContinente("America Del Sur");

        assertEquals(5, europa.tropasAdicionales());
        assertEquals(7, asia.tropasAdicionales());
        assertEquals(3, americaSur.tropasAdicionales());
    }
}
