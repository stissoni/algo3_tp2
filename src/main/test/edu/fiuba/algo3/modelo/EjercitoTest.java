package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EjercitoTest {
    @Test
    public void testNumeroDeTropasDeEjercito(){
        Ejercito ejercito = new Ejercito(3);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
    }

    @Test
    public void testReducirNumeroDeTropas(){
        Ejercito ejercito = new Ejercito(3);
        ejercito.reducirTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 2);
    }

    @Test
    public void testAumentarNumeroDeTropas(){
        Ejercito ejercito = new Ejercito(3);
        ejercito.aumentarTropas(1);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 4);
    }

    @Test
    public void testVencerUnaVezEjercitoRival(){
        Ejercito ejercito = new Ejercito(3);
        Ejercito otroEjercito = new Ejercito(2);

        ejercito.vencer(otroEjercito);

        assertEquals(ejercito.obtenerNumeroTotalDeTropas(), 3);
        assertEquals(otroEjercito.obtenerNumeroTotalDeTropas(), 1);
    }

    @Test
    public void testTirarDados(){
        Ejercito ejercito = new Ejercito(3);

        int salidaDado = ejercito.tirarDados();

        assertTrue(salidaDado < 7 && salidaDado > 0);
    }

    @Test
    public void testSalidaDados(){
        //PROBANDO MOCKITO PARA LOS DADOS
        Ejercito mockedEjercito = mock(Ejercito.class);

        when(mockedEjercito.tirarDados()).thenReturn(1).thenReturn(2);

        assertEquals(mockedEjercito.tirarDados(), 1);
        assertEquals(mockedEjercito.tirarDados(), 2);
    }
}
