package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class MapaTest {
    @Test
    public void testMapaColorcarEjercitos() throws EjercitosDeJugadoresDiferentesException{
        Mapa mapa = new Mapa();
        Pais argentina = new Pais();
        argentina.asignarNombre("Argentina");
        mapa.agregarPais(argentina);

        Pais chile = new Pais();
        chile.asignarNombre("Chile");
        mapa.agregarPais(chile);

        int idJugador = 1;
        String nombreJugador = "Santiago";
        Jugador unJugador = new Jugador(nombreJugador, idJugador);

        idJugador = 2;
        nombreJugador = "Julio";
        Jugador otroJugador = new Jugador(nombreJugador, idJugador);

        int numeroTropas = 3;
        mapa.colocarEjercitoEn("Argentina", unJugador, numeroTropas);
        numeroTropas = 2;
        mapa.colocarEjercitoEn("Chile", otroJugador, numeroTropas);

        assertEquals(3, argentina.obtenerNumeroTotalDeTropas());
        assertEquals(2, chile.obtenerNumeroTotalDeTropas());
    }
}
