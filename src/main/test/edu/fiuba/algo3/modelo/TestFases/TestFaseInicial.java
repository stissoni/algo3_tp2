package edu.fiuba.algo3.modelo.TestFases;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.fase.FaseInicial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFaseInicial {
    Turno unTurno;
    FaseInicial unaFase;
    Jugadores listaDePersonas;
    Jugador jugador1;

    @BeforeEach
    public void SetUp(){
        listaDePersonas = new Jugadores();
        jugador1 = new Jugador("Matias");
        listaDePersonas.agregarJugador(jugador1);
        unTurno = new Turno(listaDePersonas);
        unaFase = new FaseInicial(jugador1);
    }
    @Test
    public void jugadorPoneSus5TropasEnUnPais(){
        Pais argentina = new Pais("Argentina");
        argentina.ocuparPor(jugador1);

        unaFase.colocacionTropas(argentina,5);
        assertEquals(6,argentina.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void seReparten3TropasEnLaFaseInicial(){
        unaFase = new FaseInicial(jugador1);
        unaFase.otorgarTropasIniciales();
        assertEquals(8,jugador1.getTropasDisponibles());
    }
}
