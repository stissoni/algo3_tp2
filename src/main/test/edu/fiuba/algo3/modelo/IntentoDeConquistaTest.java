package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntentoDeConquistaTest {
    private Jugador jugadorAtacante;
    private Jugador jugadorDefensor;

    @BeforeEach
    public void setUp() throws Exception {
        this.jugadorAtacante = new Jugador("Santiago", 1);
        this.jugadorDefensor = new Jugador("Ramiro", 2);
    }
    @Test
    public void testIntentarConquistaDePaisConVictoriaAtacante() throws Throwable{
        Pais paisAtacante = new Pais("Argentina");
        Pais paisDefensor = new Pais("Brasil");

        Ejercito ejercitoAtacante = new Ejercito(5, jugadorAtacante);
        Ejercito ejercitoDefensor = new Ejercito(3, jugadorDefensor);
        paisAtacante.asignarEjercito(ejercitoAtacante);
        paisDefensor.asignarEjercito(ejercitoDefensor);

        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(6).thenReturn(5).thenReturn(4).thenReturn(2).thenReturn(2).thenReturn(2);
        
        int numeroTropasParaAtacar = 3;
        IntentoDeConquista intentarConquista = new IntentoDeConquista(paisAtacante, paisDefensor);
        intentarConquista.intentarConquista(numeroTropasParaAtacar, generador);

        assertSame(jugadorAtacante, paisDefensor.obtenerJugadorEnControl()); // Cambia el control del pais.
        assertEquals(3, paisDefensor.obtenerNumeroTotalDeTropas());
        assertEquals(2, paisAtacante.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testIntentarConquistaDePaisConVictoriaDefensor() throws Throwable{
        Pais paisAtacante = new Pais("Argentina");
        Pais paisDefensor = new Pais("Brasil");

        Ejercito ejercitoAtacante = new Ejercito(4, jugadorAtacante);
        Ejercito ejercitoDefensor = new Ejercito(3, jugadorDefensor);
        paisAtacante.asignarEjercito(ejercitoAtacante);
        paisDefensor.asignarEjercito(ejercitoDefensor);

        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(6).thenReturn(2).thenReturn(2).thenReturn(4).thenReturn(4).thenReturn(3);
        
        int numeroTropasParaAtacar = 3;
        IntentoDeConquista intentarConquista = new IntentoDeConquista(paisAtacante, paisDefensor);
        intentarConquista.intentarConquista(numeroTropasParaAtacar, generador);

        assertSame(ejercitoDefensor, paisDefensor.obtenerEjercito()); // Mantiene el pais.
        assertSame(jugadorDefensor, paisDefensor.obtenerJugadorEnControl());
        assertEquals(2, paisDefensor.obtenerNumeroTotalDeTropas());
        assertEquals(2, paisAtacante.obtenerNumeroTotalDeTropas()); // Vuelven 1 tropa + 1 que se habia quedado.
    }
}
