package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjecitoTest {
    @Test
    public void testNumeroDeTropasDeEjercito(){
        Ejercito ejercito = new Ejercito(3);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
    }

    @Test
    public void testReducirNumeroDeTropas(){
        Ejercito ejercito = new Ejercito(3);
        ejercito.reducirTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 2);
    }

    @Test
    public void testAumentarNumeroDeTropas(){
        Ejercito ejercito = new Ejercito(3);
        ejercito.aumentarTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 4);
    }
}
