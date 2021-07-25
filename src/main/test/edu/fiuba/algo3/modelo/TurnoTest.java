package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TurnoTest {
    @Test
    public void testTurnoActual(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turnero = new Turno(jugadores, 0);

        assertSame(jugador1, turnero.jugadorTurno());
    }
    @Test
    public void testAvanzarTurno(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turnero = new Turno(jugadores, 0);

        turnero.siguienteTurno();

        assertSame(jugador2, turnero.jugadorTurno());
    }

    @Test
    public void testAvanzarTurnoPeroYaSeCompletoLaRonda(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turnero = new Turno(jugadores, 0);

        turnero.siguienteTurno();
        turnero.siguienteTurno();

        assertSame(jugador1, turnero.jugadorTurno());
    }
    @Test
    public void reiniciarTurno(){
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turnero = new Turno(jugadores, 0);

        turnero.siguienteTurno();
        turnero.reiniciar();

        assertSame(jugador1, turnero.jugadorTurno());
    }
}
