package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;

public class PaisTest {

    private Pais unPais;
    private Ejercito unEjercito;
    private Jugador unJugador;

    @BeforeEach                                         
    public void setUp() throws Exception {
        unJugador = new Jugador("Santiago", 1);
        unEjercito = new Ejercito(3, unJugador);
        unPais = new Pais("Argentina", unEjercito);
    }

    @Test
    public void testPaisEjercitoControlando(){
        assertSame(unPais.obtenerEjercito(), unEjercito);

        Jugador otroJugador = new Jugador("Ramiro", 2);
        Ejercito otroEjercito = new Ejercito(2, otroJugador);
        unPais.entregarControlAlEjercito(otroEjercito);

        assertSame(unPais.obtenerEjercito(), otroEjercito);
    }

    @Test
    public void testNombreJugadorEnControl(){
        assertSame(unJugador, unPais.obtenerJugadorEnControl());
    }

    @Test 
    public void testNumeroDeTropas(){
        assertEquals(3, unPais.obtenerNumeroTotalDeTropas());
    }
}
