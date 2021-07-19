package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class PartidaTest {
    Jugadores listaDeJugadores;
    Jugador jugador1;
    Jugador jugador2;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Santiago");
        this.jugador2 = new Jugador("Ramiro");
        listaDeJugadores = new Jugadores();
        listaDeJugadores.agregarJugador(jugador1);
        listaDeJugadores.agregarJugador(jugador2);
    }

    @Test
    public void crearPartidaDe2JugadoresTiene2Jugadores() {
        Partida teg = new Partida(listaDeJugadores);
        int n = 2;
        assertTrue(teg.partidaSeCreaConNJugadores(n));
    }

    @Test
    public void mapaFueOcupadoCorrectamente(){
        Partida teg = new Partida(listaDeJugadores);
        assertTrue(teg.mapaFueOcupadoCorrectamente());
    }

    @Test
    public void jugarUnaRondaCon2JugadoresSinAtacar() {
        Partida teg = new Partida(listaDeJugadores);
        assertTrue(teg.tienenTropasDisponibles());
        teg.jugarUnaRondaDe2JugadoresSoloConPosicionamientos(jugador1,jugador2);
        assertFalse(teg.tienenTropasDisponibles());
    }

    @Test
    public void jugarUnaRondaCon3JugadoresSinAtacar() {
        Jugador jugador3 = new Jugador("Matias");
        listaDeJugadores.agregarJugador(jugador3);
        Partida teg = new Partida(listaDeJugadores);
        assertTrue(teg.tienenTropasDisponibles());
        teg.jugarUnaRondaDe3JugadoresSoloConPosicionamientos(jugador1,jugador2,jugador3);
        assertFalse(teg.tienenTropasDisponibles());
    }
}
