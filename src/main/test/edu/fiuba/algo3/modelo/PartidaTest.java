package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

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
    public void paisesLimitrofes() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.jugadorInicial(0);
        unaPartida.iniciarPartida();

        assertEquals(4, unaPartida.obtenerPaisesLimitrofesDe("Argentina").size());
    }

    @Test
    public void testObjetivosCumplidos() throws Throwable{
        Jugador jugador1 = new Jugador("Santiago", 1);
        Jugador jugador2 = new Jugador("Julio", 2);

        Partida unaPartida = new Partida();
        unaPartida.crearMapa();
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unaPartida.jugadorInicial(0);
        unaPartida.iniciarPartida();

        for(Pais pais: unaPartida.obtenerPaises()){
            System.out.println(pais.obtenerNombrePais()+" "+pais.obtenerJugadorEnControl().obtenerNombre());
        }

        Continente americaDelSur = unaPartida.obtenerMapa().obtenerUnContinente("America Del Sur");
        ObjetivoConquista conquistar4DeAmericaDelSur = new ObjetivoConquista();
        conquistar4DeAmericaDelSur.agregarContinenteAConquistar(
            americaDelSur,
            4
        );
        conquistar4DeAmericaDelSur.setJugador(jugador1);

        assertTrue(conquistar4DeAmericaDelSur.logroElObjetivo(unaPartida.obtenerMapa()));
    }

    @Test
    public void testMazo() throws IOException{
        Partida unaPartida = new Partida();
        unaPartida.cargarMazo();
        MazoPaises mazo = unaPartida.obtenerMazo();

        assertEquals(50, mazo.numeroDeCartas());

        CartaPais carta = mazo.obtenerSiguienteCarta();

        assertEquals(49, mazo.numeroDeCartas());

        mazo.agregarAlFondo(carta);

        assertEquals(50, mazo.numeroDeCartas());
    }
}
