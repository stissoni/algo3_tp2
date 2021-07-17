package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaisTest {

    private Pais unPais;
    private Ejercito unEjercito;
    private Jugador unJugador;

    @BeforeEach                                         
    public void setUp() {
        unJugador = new Jugador("Santiago");
        unEjercito = new Ejercito(3, unJugador);
        unPais = new Pais("Argentina");
    }

    @Test
    public void testNombreDePais(){
        assertEquals("Argentina", unPais.obtenerNombrePais());
    }

    @Test
    public void testPaisEjercitoControlando(){
        unPais.asignarEjercito(unEjercito);
        assertSame(unPais.obtenerEjercito(), unEjercito);

        Jugador otroJugador = new Jugador("Ramiro");
        Ejercito otroEjercito = new Ejercito(2, otroJugador);
        unPais.asignarEjercito(otroEjercito);

        assertSame(unPais.obtenerEjercito(), otroEjercito);
    }

    @Test
    public void testJugadorEnControl(){
        unPais.asignarEjercito(unEjercito);
        assertSame(unJugador, unPais.obtenerJugadorEnControl());
    }

    @Test 
    public void testNumeroDeTropas(){
        unPais.asignarEjercito(unEjercito);
        assertEquals(3, unPais.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testReagruparEjercitoQuePerdioUnaBatalla() throws EjercitosDeJugadoresDiferentesException{
        unPais.asignarEjercito(unEjercito);
        Ejercito ejercitoQuePerdioBatalla = new Ejercito(1, unJugador);
        unPais.reagruparEjercito(ejercitoQuePerdioBatalla);

        assertEquals(4, unPais.obtenerNumeroTotalDeTropas());
        assertSame(unJugador, unPais.obtenerJugadorEnControl());
    }
}
