package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class PartidaTest {
    @Test
    public void testPaisesRepartidosCorrectamente() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();

        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);

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
        unaPartida.iniciarPartida();

        //___________________________________//

        MovimientoColocacion movimiento = new MovimientoColocacion();
        Pais destino = unaPartida.obtenerMapa().obtenerUnPais("Terranova");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(3);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(4, destino.obtenerNumeroTotalDeTropas());
        // Jugador 1 ya coloco todas las tropas que le correspondia...
        assertSame(jugador2, unaPartida.obtenerJugadorActual());

        //___________________________________//

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerMapa().obtenerUnPais("Japon");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(2);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(3, destino.obtenerNumeroTotalDeTropas());
        // Sigue jugando jugador 2 tiene una tropa mas para colocar...
        assertSame(jugador2, unaPartida.obtenerJugadorActual());

        //___________________________________//

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerMapa().obtenerUnPais("Rusia");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(1);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(2, destino.obtenerNumeroTotalDeTropas());
        // Ahora le toca a jugador 1
        assertSame(jugador1, unaPartida.obtenerJugadorActual());
        
        //___________________________________//

        movimiento = new MovimientoColocacion();
        destino = unaPartida.obtenerMapa().obtenerUnPais("Terranova");
        movimiento.destinoPais(destino);
        movimiento.numeroTropas(4);
        unaPartida.ejecutarMovimiento(movimiento);
        assertEquals(8, destino.obtenerNumeroTotalDeTropas());
        // Sigue jugando jugador1, puede colocar una tropa mas todavia...
        assertSame(jugador1, unaPartida.obtenerJugadorActual());
    }
}
