package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class PartidaTest {
    @Test
    public void testPaisesRepartidosCorrectamenteEntreDosJugadores() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.jugadorInicial(0);
        unaPartida.iniciarPartida();
        
        for(Pais pais: unaPartida.obtenerMapa().obtenerPaises()){
            System.out.println(pais.obtenerNombrePais()+"-"+pais.obtenerJugadorEnControl().obtenerNombre());
        }
    }

    @Test
    public void testTurnero() throws Throwable{
        // Preguntar a Pablo...
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.jugadorInicial(0);
        
        Turnero turnero = Turnero.getInstance();

        assertSame(jugador1, turnero.jugadorTurno());
    }
    @Test
    public void testPaisesRepartidosCorrectamenteEntreTresJugadores() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);
        Jugador jugador3 = new Jugador("Pablo", 3);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.agregarJugador(jugador3);
        unaPartida.jugadorInicial(0);
        unaPartida.iniciarPartida();
        
        for(Pais pais: unaPartida.obtenerMapa().obtenerPaises()){
            System.out.println(pais.obtenerNombrePais()+"-"+pais.obtenerJugadorEnControl().obtenerNombre());
        }
    }

    @Test
    public void testRondaDeColocacion() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.jugadorInicial(0);
        unaPartida.iniciarPartida();

        //___________________________________//

        MovimientoColocacion movimiento = new MovimientoColocacion();
        Pais destino = unaPartida.obtenerUnPais("Terranova");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(3);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(4, destino.obtenerNumeroTotalDeTropas());
        // Jugador 1 ya coloco todas las tropas que le correspondia...
        assertSame(jugador2, unaPartida.obtenerJugadorActual());

        //___________________________________//

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerUnPais("Japon");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(2);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(3, destino.obtenerNumeroTotalDeTropas());
        // Sigue jugando jugador 2 tiene una tropa mas para colocar...
        assertSame(jugador2, unaPartida.obtenerJugadorActual());

        //___________________________________//

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerUnPais("Rusia");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(1);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(2, destino.obtenerNumeroTotalDeTropas());
        // Ahora le toca a jugador 1
        assertSame(jugador1, unaPartida.obtenerJugadorActual());
        
        //___________________________________//

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerUnPais("Terranova");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(4);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(8, destino.obtenerNumeroTotalDeTropas());
        // Sigue jugando jugador1, puede colocar una tropa mas todavia...
        assertSame(jugador1, unaPartida.obtenerJugadorActual());
    }

    @Test
    public void testJuegoDeUnaRondaConDosJugadores() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.jugadorInicial(0);
        unaPartida.iniciarPartida();

        assertSame(jugador1, unaPartida.obtenerJugadorActual());

        MovimientoColocacion movimiento = new MovimientoColocacion();
        Pais destino = unaPartida.obtenerUnPais("Alemania");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(3);
        unaPartida.ejecutarMovimiento(movimiento);

        assertSame(jugador2, unaPartida.obtenerJugadorActual());

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerUnPais("Francia");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(3);
        unaPartida.ejecutarMovimiento(movimiento);

        assertSame(jugador1, unaPartida.obtenerJugadorActual());
        
        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerUnPais("Terranova");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(5);
        unaPartida.ejecutarMovimiento(movimiento);

        assertSame(jugador2, unaPartida.obtenerJugadorActual());

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerUnPais("España");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(5);
        unaPartida.ejecutarMovimiento(movimiento);

        //___ATAQUE___//

        assertSame(jugador1, unaPartida.obtenerJugadorActual());
        assertSame(jugador2, unaPartida.obtenerUnPais("Polonia").obtenerJugadorEnControl());

        MovimientoAtaque ataque = new MovimientoAtaque();
        ataque.paisAtacante(unaPartida.obtenerUnPais("Alemania"));
        ataque.paisDefensor(unaPartida.obtenerUnPais("Polonia"));
        ataque.numeroDeTropas(3);
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(6).thenReturn(1);
        ataque.generador(generador);
        ataque.jugador(jugador1);

        unaPartida.ejecutarMovimiento(ataque);

        assertSame(jugador1, unaPartida.obtenerUnPais("Polonia").obtenerJugadorEnControl());
        assertEquals(3, unaPartida.obtenerUnPais("Polonia").obtenerNumeroTotalDeTropas());

        //___OTRO ATAQUE___//

        assertSame(jugador2, unaPartida.obtenerUnPais("Nueva York").obtenerJugadorEnControl());

        ataque = new MovimientoAtaque();
        ataque.paisAtacante(unaPartida.obtenerUnPais("Terranova"));
        ataque.paisDefensor(unaPartida.obtenerUnPais("Nueva York"));
        ataque.numeroDeTropas(5);
        generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(6).thenReturn(1);
        ataque.generador(generador);
        ataque.jugador(jugador1);

        unaPartida.ejecutarMovimiento(ataque);

        assertSame(jugador1, unaPartida.obtenerUnPais("Nueva York").obtenerJugadorEnControl());
        assertEquals(5, unaPartida.obtenerUnPais("Nueva York").obtenerNumeroTotalDeTropas());
    }
}
