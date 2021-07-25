package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RondaColocacionTest {

    private Turno turnero;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void setUp() throws Throwable{
        this.jugador1 = new Jugador("Santiago", 1);
        this.jugador2 = new Jugador("Julio", 2);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(this.jugador1);
        jugadores.add(this.jugador2);
        this.turnero = new Turno(jugadores, 0);
    }
    @Test
    public void testTurnoCompletado() throws Throwable{
        RondaColocacion ronda = new RondaColocacion();
        ronda.numeroDeTropas(3);
        ronda.turnero(this.turnero);

        MovimientoColocacion movimiento = new MovimientoColocacion();
        movimiento.destinoPais(new Pais("Argentina"));
        movimiento.numeroTropas(3);

        ronda.ejecutar(movimiento);

        assertSame(this.jugador2, this.turnero.jugadorTurno());
    }
    @Test
    public void testRondaCompletada() throws Throwable{
        RondaColocacion ronda = new RondaColocacion();

        FaseInicial faseInicial = mock(FaseInicial.class);

        ronda.numeroDeTropas(3);
        ronda.turnero(this.turnero);
        ronda.fase(faseInicial);

        MovimientoColocacion movimiento = new MovimientoColocacion();
        movimiento.destinoPais(new Pais("Argentina"));
        movimiento.numeroTropas(3);

        ronda.ejecutar(movimiento);

        MovimientoColocacion movimiento2 = new MovimientoColocacion();
        movimiento2.destinoPais(new Pais("Chile"));
        movimiento2.numeroTropas(3);

        ronda.ejecutar(movimiento2);

        assertTrue(ronda.terminoRonda());
    }
}
