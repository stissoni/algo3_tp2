package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class TurnoTest {
    @Test
    public void testTurnoActual(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        Turnero turnero = Turnero.getInstance();
        turnero.agregarJugador(jugador1);
        turnero.agregarJugador(jugador2);
        turnero.jugadorInicial(0);

        assertSame(jugador1, turnero.jugadorTurno());
    }
    @Test
    public void testAvanzarTurno(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        Turnero turnero = Turnero.getInstance();
        turnero.agregarJugador(jugador1);
        turnero.agregarJugador(jugador2);
        turnero.jugadorInicial(0);

        turnero.siguienteTurno();

        assertSame(jugador2, turnero.jugadorTurno());
    }

    @Test
    public void testAvanzarTurnoPeroYaSeCompletoLaRonda(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        Turnero turnero = Turnero.getInstance();
        turnero.agregarJugador(jugador1);
        turnero.agregarJugador(jugador2);
        turnero.jugadorInicial(0);

        turnero.siguienteTurno();
        turnero.siguienteTurno();

        assertSame(jugador1, turnero.jugadorTurno());
    }
    @Test
    public void reiniciarTurno(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        Turnero turnero = Turnero.getInstance();
        turnero.agregarJugador(jugador1);
        turnero.agregarJugador(jugador2);
        turnero.jugadorInicial(0);

        turnero.siguienteTurno();
        turnero.reiniciar();

        assertSame(jugador1, turnero.jugadorTurno());
    }
}
