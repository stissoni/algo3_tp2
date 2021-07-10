package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class PartidaTest {

    Jugador jugador1;
    Jugador jugador2;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Santiago", 1);
        this.jugador2 = new Jugador("Ramiro", 2);
    }

    @Test
    public void crearPartidaDe2JugadoresTiene2Jugadores(){
        ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
        listaDeJugadores.add(jugador1);
        listaDeJugadores.add(jugador2);
        Partida teg = new Partida(listaDeJugadores);
        Assertions.assertEquals(2,teg.obtenerCantidadDeJugadores());
        Assertions.assertEquals(jugador1, teg.obtenerListaDeJugadores().get(0));
        Assertions.assertEquals(jugador2,teg.obtenerListaDeJugadores().get(1));
    }
    @Test
    public void partidaDe2JugadoresTieneTodosLosPaisesAsignados(){
        ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
        listaDeJugadores.add(jugador1);
        listaDeJugadores.add(jugador2);
        Partida teg = new Partida(listaDeJugadores);
        ArrayList<Pais> listaDePaises = teg.obtenerlistaDePaises();
        for (Pais pais : listaDePaises){
            Ejercito ejercitoAsignado = pais.obtenerEjercito();
            Assertions.assertEquals(1,ejercitoAsignado.obtenerNumeroTotalDeTropas());
        }
    }

    @Test
    public void losPaisesSeAsignanAlAzarEntreLosJugadores(){
        ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
        listaDeJugadores.add(jugador1);
        listaDeJugadores.add(jugador2);

        Partida teg1 = new Partida(listaDeJugadores);
        Partida teg2 = new Partida(listaDeJugadores);
        ArrayList<Pais> listaDePaises1 = teg1.obtenerlistaDePaises();
        ArrayList<Pais> listaDePaises2 = teg2.obtenerlistaDePaises();
        int cantidadPaises = teg1.obtenerlistaDePaises().size();
        boolean iguales = true;

        for (int i=0;i<cantidadPaises;i++){
            String nombrePaisTeg1 = listaDePaises1.get(i).obtenerNombrePais();
            String nombrePaisTeg2 = listaDePaises2.get(i).obtenerNombrePais();
            if (!nombrePaisTeg1.equals(nombrePaisTeg2)) iguales = false ;
        }
        Assertions.assertFalse(iguales);
    }

    @Test
    public void partidaDe2JugadoresTieneTodosLosPaisesAsignadosEquitativamente(){
        ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
        listaDeJugadores.add(jugador1);
        listaDeJugadores.add(jugador2);
        Partida teg = new Partida(listaDeJugadores);
        ArrayList<Pais> listaDePaises = teg.obtenerlistaDePaises();
        int paisesJugador1 = 0;
        int paisesJugador2 = 0;
        for (Pais pais : listaDePaises){
            if (pais.obtenerJugadorEnControl() == jugador1) paisesJugador1 ++;
            else paisesJugador2 ++;
        }
        int resultado = paisesJugador1-paisesJugador2;
        Assertions.assertTrue(resultado<=1);
    }
}
