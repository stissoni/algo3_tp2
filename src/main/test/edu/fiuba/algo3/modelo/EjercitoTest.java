package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EjercitoTest {
    private Ejercito ejercito;
    private Jugador unJugador;

    @BeforeEach                                         
    public void setUp() throws Exception {
        unJugador = new Jugador("Santiago", 1);
        ejercito = new Ejercito(3, unJugador);
    }

    @Test
    public void testAgruparEjercitos(){
        Ejercito otroEjercito = new Ejercito(4, unJugador);
        ejercito.reagruparEjercito(otroEjercito);

        assertEquals(7, ejercito.obtenerNumeroTotalDeTropas());
    }
    @Test
    public void testNumeroDeTropasDeEjercito(){
        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
    }

    @Test
    public void testReducirNumeroDeTropas(){
        ejercito.reducirTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 2);
    }

    @Test
    public void testAumentarNumeroDeTropas(){
        ejercito.aumentarTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 4);
    }

    @Test
    public void testVencerUnaVezEjercitoRival(){
        Jugador otroJugador = new Jugador("Matias", 2);
        Ejercito otroEjercito = new Ejercito(2, otroJugador);

        ejercito.vencer(otroEjercito);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
        assertEquals(otroEjercito.obtenerNumeroTotalDeTropas(), 1);
    }

    @Test
    public void testEjercitoTomaControlDeUnPais(){
        Pais unPais = new Pais("Italia", new Ejercito(1, new Jugador("Ramiro", 3)));

        ejercito.controlarPais(unPais);

        assertSame(ejercito, unPais.obtenerEjercito());
    }
}
