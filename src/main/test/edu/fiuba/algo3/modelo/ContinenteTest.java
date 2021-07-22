package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class ContinenteTest {
    @Test
    public void testContinenteEnControlDeJugador() throws EjercitosDeJugadoresDiferentesException{
        Jugador unJugador = new Jugador("Santiago", 1);
        Ejercito unEjercito = new Ejercito(3, unJugador);
        Pais unPais = new Pais("Argentina");
        Continente americaDelSur = new Continente();

        americaDelSur.asignarNombre("America del Sur");
        americaDelSur.agregarPais(unPais);
        unPais.agregarEjercito(unEjercito);

        assertTrue(americaDelSur.esDominadoPorJugador(unJugador));
    }

    @Test
    public void testContinenteSinControlDeUnJugador() throws EjercitosDeJugadoresDiferentesException{
        Jugador unJugador = new Jugador("Santiago", 1);
        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        Continente americaDelSur = new Continente();

        americaDelSur.asignarNombre("America del Sur");
        americaDelSur.agregarPais(unPais);
        americaDelSur.agregarPais(otroPais);

        assertFalse(americaDelSur.esDominadoPorJugador(unJugador));
    }

    @Test
    public void testContinenteSinControlDeUnJugadorPorPresenciaDeOtrosJugadores() throws EjercitosDeJugadoresDiferentesException{
        Jugador unJugador = new Jugador("Santiago", 1);
        Jugador otroJugador = new Jugador("Julio", 2);
        
        Ejercito unEjercito = new Ejercito(3, unJugador);
        Ejercito otroEjercito = new Ejercito(3, otroJugador);
        
        Pais unPais = new Pais("Argentina");
        unPais.agregarEjercito(unEjercito);
        Pais otroPais = new Pais("Brasil");
        otroPais.agregarEjercito(otroEjercito);
        
        Continente americaDelSur = new Continente();
        americaDelSur.asignarNombre("America del Sur");
        americaDelSur.agregarPais(unPais);
        americaDelSur.agregarPais(otroPais);

        assertFalse(americaDelSur.esDominadoPorJugador(unJugador));
    }
}
