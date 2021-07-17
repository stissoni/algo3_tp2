package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;
import edu.fiuba.algo3.excepciones.NumeroDeTropasInsuficienteException;

public class EjercitoTest {
    private Ejercito ejercito;
    private Jugador unJugador;

    @BeforeEach                                         
    public void setUp(){
        unJugador = new Jugador("Santiago");
        ejercito = new Ejercito(3, unJugador);
    }

    @Test
    public void testAgruparEjercitos() throws EjercitosDeJugadoresDiferentesException{
        Ejercito otroEjercito = new Ejercito(4, unJugador);
        ejercito.reagruparEjercito(otroEjercito);

        assertEquals(7, ejercito.obtenerNumeroTotalDeTropas());
    }
    @Test
    public void testNumeroDeTropasDeEjercito(){
        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
    }

    @Test
    public void testReducirNumeroDeTropas() throws NumeroDeTropasInsuficienteException{
        ejercito.reducirTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 2);
    }

    @Test
    public void testAumentarNumeroDeTropas(){
        ejercito.aumentarTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 4);
    }

    @Test
    public void testVencerUnaVezEjercitoRival() throws EjercitoYaVencidoException{
        Jugador otroJugador = new Jugador("Matias");
        Ejercito otroEjercito = new Ejercito(2, otroJugador);

        ejercito.vencer(otroEjercito);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
        assertEquals(otroEjercito.obtenerNumeroTotalDeTropas(), 1);
    }

    @Test
    public void testEjercitoTomaControlDeUnPais(){
        Pais unPais = new Pais("Italia");
        Ejercito unEjercito = new Ejercito(1, new Jugador("Ramiro"));

        unEjercito.controlarPais(unPais);

        assertSame(unEjercito, unPais.obtenerEjercito());
    }


    @Test
    public void testRestarTropasDeEjercitoDe0TropasLanzaExcepcion() throws NumeroDeTropasInsuficienteException{
        ejercito.reducirTropas(3);

        assertThrows(NumeroDeTropasInsuficienteException.class, ()->ejercito.reducirTropas(1));
    }

    @Test
    public void testVencerEjercitoCon0TropasLanzaExcepcion() throws EjercitoYaVencidoException{
        Jugador otroJugador = new Jugador("Matias");
        Ejercito otroEjercito = new Ejercito(1, otroJugador);

        ejercito.vencer(otroEjercito);

        assertThrows(EjercitoYaVencidoException.class, ()->ejercito.vencer(otroEjercito));
    }
}
