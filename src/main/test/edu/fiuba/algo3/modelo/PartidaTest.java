package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PartidaTest {

    Jugador jugador1;
    Jugador jugador2;
    ArrayList<Jugador> listaDeJugadores;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Santiago", 1);
        this.jugador2 = new Jugador("Ramiro", 2);
        listaDeJugadores = new ArrayList<>();
        listaDeJugadores.add(jugador1);
        listaDeJugadores.add(jugador2);
    }

    @Test
    public void crearPartidaDe2JugadoresTiene2Jugadores(){
        Partida teg = new Partida(listaDeJugadores);
        Assertions.assertEquals(2,teg.obtenerCantidadDeJugadores());
        Assertions.assertEquals(jugador1, teg.obtenerListaDeJugadores().get(0));
        Assertions.assertEquals(jugador2,teg.obtenerListaDeJugadores().get(1));
    }
    @Test
    public void partidaDe2JugadoresTieneTodosLosPaisesAsignados(){
        Partida teg = new Partida(listaDeJugadores);
        List<String> listaDePaises = teg.obtenerlistaDePaises();
        for (String pais : listaDePaises){
            Ejercito ejercitoAsignado = teg.obtenerPais(pais).obtenerEjercito();
            Assertions.assertEquals(1,ejercitoAsignado.obtenerNumeroTotalDeTropas());
        }
    }

    @Test
    public void losPaisesSeAsignanAlAzarEntre2Jugadores(){
        Partida teg1 = new Partida(listaDeJugadores);
        Partida teg2 = new Partida(listaDeJugadores);
        List<String> listaDePaises1 = teg1.obtenerlistaDePaises();
        List<String> listaDePaises2 = teg2.obtenerlistaDePaises();
        assertNotEquals(listaDePaises1,listaDePaises2);
    }

    @Test
    public void partidaDe2JugadoresTieneTodosLosPaisesAsignadosEquitativamente(){
        Partida teg = new Partida(listaDeJugadores);
        List<String> listaDePaises = teg.obtenerlistaDePaises();
        int paisesJugador1 = 0;
        int paisesJugador2 = 0;
        for (String pais : listaDePaises){
            if (teg.obtenerPais(pais).obtenerJugadorEnControl() == jugador1) paisesJugador1 ++;
            else paisesJugador2 ++;
        }
        int resultado = paisesJugador1-paisesJugador2;
        Assertions.assertTrue(resultado<=1 && resultado>=-1);
    }

    @Test
    public void partidaDe3JugadoresTiene3Jugadores(){
        Jugador jugador3 = new Jugador("Mati", 3);
        listaDeJugadores.add(jugador3);

        Partida teg = new Partida(listaDeJugadores);
        Assertions.assertEquals(3,teg.obtenerCantidadDeJugadores());
        Assertions.assertEquals(jugador1, teg.obtenerListaDeJugadores().get(0));
        Assertions.assertEquals(jugador2,teg.obtenerListaDeJugadores().get(1));
        Assertions.assertEquals(jugador3,teg.obtenerListaDeJugadores().get(2));
    }
    @Test
    public void partidaDe3JugadoresTieneTodosLosPaisesAsignados(){
        Jugador jugador3 = new Jugador("Mati", 3);
        listaDeJugadores.add(jugador3);
        Partida teg = new Partida(listaDeJugadores);
        List<String> listaDePaises = teg.obtenerlistaDePaises();
        for (String pais : listaDePaises){
            Ejercito ejercitoAsignado = teg.obtenerPais(pais).obtenerEjercito();
            Assertions.assertEquals(1,ejercitoAsignado.obtenerNumeroTotalDeTropas());
        }
    }

    @Test
    public void losPaisesSeAsignanAlAzarEntre3Jugadores(){
        Jugador jugador3 = new Jugador("Mati", 3);
        listaDeJugadores.add(jugador3);
        Partida teg1 = new Partida(listaDeJugadores);
        Partida teg2 = new Partida(listaDeJugadores);
        List<String> listaDePaises1 = teg1.obtenerlistaDePaises();
        List<String> listaDePaises2 = teg2.obtenerlistaDePaises();
        assertNotEquals(listaDePaises1,listaDePaises2);
    }

    @Test
    public void partidaDe3JugadoresTieneTodosLosPaisesAsignadosEquitativamente(){
        Jugador jugador3 = new Jugador("Mati", 3);
        listaDeJugadores.add(jugador3);
        Partida teg = new Partida(listaDeJugadores);
        List<String> listaDePaises = teg.obtenerlistaDePaises();
        int paisesJugador1 = 0;
        int paisesJugador2 = 0;
        int paisesJugador3 = 0;
        for (String nombrePais : listaDePaises){
            Pais pais = teg.obtenerPais(nombrePais);
            if (pais.obtenerJugadorEnControl() == jugador1) paisesJugador1 ++;
            else if (pais.obtenerJugadorEnControl() == jugador2) paisesJugador2 ++;
            else paisesJugador3++;
        }
        int promedioEsperadoRedondeado = listaDePaises.size()/ teg.obtenerCantidadDeJugadores();
        int resultadoParcial = (paisesJugador1-paisesJugador2+paisesJugador3);
        int resultado = promedioEsperadoRedondeado-resultadoParcial;
        Assertions.assertTrue(resultado<=1 && resultado>=-1);
    }

    @Test
    public void partidaDe6JugadoresTieneTodosLosPaisesAsignadosEquitativamente(){
        Jugador jugador3 = new Jugador("Mati", 3);
        listaDeJugadores.add(jugador3);
        Jugador jugador4 = new Jugador("Julio", 4);
        listaDeJugadores.add(jugador4);
        Jugador jugador5 = new Jugador("Pablo", 5);
        listaDeJugadores.add(jugador5);
        Jugador jugador6 = new Jugador("Maia", 6);
        listaDeJugadores.add(jugador6);

        Partida teg = new Partida(listaDeJugadores);
        List<String> listaDePaises = teg.obtenerlistaDePaises();
        int paisesJugador1 = 0;
        int paisesJugador2 = 0;
        int paisesJugador3 = 0;
        int paisesJugador4 = 0;
        int paisesJugador5 = 0;
        int paisesJugador6 = 0;
        for (String nombrePais : listaDePaises){
            Pais pais = teg.obtenerPais(nombrePais);
            if (pais.obtenerJugadorEnControl() == jugador1) paisesJugador1 ++;
            else if (pais.obtenerJugadorEnControl() == jugador2) paisesJugador2 ++;
            else if (pais.obtenerJugadorEnControl() == jugador3) paisesJugador3 ++;
            else if (pais.obtenerJugadorEnControl() == jugador4) paisesJugador4 ++;
            else if (pais.obtenerJugadorEnControl() == jugador5) paisesJugador5 ++;
            else paisesJugador6 ++;
        }
        int resultado = (paisesJugador1-paisesJugador2+paisesJugador3-
                paisesJugador4+paisesJugador5-paisesJugador6);
        Assertions.assertTrue(resultado<=1 && resultado>=-1);
    }
}
