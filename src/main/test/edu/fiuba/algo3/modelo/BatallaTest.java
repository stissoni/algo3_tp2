package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import java.util.ArrayList;

public class BatallaTest {
    @Test
    public void testNumeroDeDadosAtacanteMayorA3(){
        Ejercito ejercitoAtacante = new Ejercito(5);
        Ejercito ejercitoDefensor = new Ejercito(4);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(batalla.obtenerNumeroDadosAtacante(4), 3);
    }

    @Test
    public void testNumeroDeDadosAtacanteMenorA3(){
        Ejercito ejercitoAtacante = new Ejercito(3);
        Ejercito ejercitoDefensor = new Ejercito(1);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(batalla.obtenerNumeroDadosAtacante(2), 2);
    }

    @Test
    public void testNumeroDeDadosAComparar(){
        Ejercito ejercitoAtacante = new Ejercito(5);
        Ejercito ejercitoDefensor = new Ejercito(2);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(batalla.obtenerNumeroDadosAComparar(4, 2), 2);
    }

    @Test
    public void testResultadoDeTirarDados(){
        Ejercito mockedEjercito = mock(Ejercito.class);
        Ejercito mockedOtroEjercito = mock(Ejercito.class);

        when(mockedEjercito.tirarDados()).thenReturn(1).thenReturn(5).thenReturn(3);

        Pais paisAtacante = new Pais("Argentina", mockedEjercito);
        Pais paisDefensor = new Pais("Brasil", mockedOtroEjercito);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);
        
        ArrayList<Integer> dadosAtacanteTest = new ArrayList<Integer>();
        dadosAtacanteTest.add(5);
        dadosAtacanteTest.add(3);
        dadosAtacanteTest.add(1);

        assertEquals(batalla.tirarDados(3, paisAtacante), dadosAtacanteTest);
    }

    @Test 
    public void testEjercitoAtacanteGanadorDeBatalla(){
        Ejercito mockedEjercitoAtacante = Mockito.spy(new Ejercito(3));
        Ejercito mockedEjercitoDefensor = Mockito.spy(new Ejercito(2));

        when(mockedEjercitoAtacante.tirarDados()).thenReturn(6).thenReturn(6).thenReturn(2);
        when(mockedEjercitoDefensor.tirarDados()).thenReturn(1).thenReturn(1);

        Pais paisAtacante = new Pais("Argentina", mockedEjercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", mockedEjercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);
        batalla.luchar();

        assertSame(paisDefensor.obtenerEjercito(), mockedEjercitoAtacante);
    }

    @Test 
    public void testEjercitoDefensorGanadorDeBatalla(){
        Ejercito mockedEjercitoAtacante = Mockito.spy(new Ejercito(2));
        Ejercito mockedEjercitoDefensor = Mockito.spy(new Ejercito(2));

        when(mockedEjercitoAtacante.tirarDados()).thenReturn(2).thenReturn(2);
        when(mockedEjercitoDefensor.tirarDados()).thenReturn(5).thenReturn(5);

        Pais paisAtacante = new Pais("Argentina", mockedEjercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", mockedEjercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);
        batalla.luchar();

        assertSame(paisDefensor.obtenerEjercito(), mockedEjercitoDefensor);
    }

    @Test 
    public void testEjercitoDefensorGanadorDeBatallaEnCasoDeEmpate(){
        Ejercito mockedEjercitoAtacante = Mockito.spy(new Ejercito(2));
        Ejercito mockedEjercitoDefensor = Mockito.spy(new Ejercito(2));
        when(mockedEjercitoAtacante.tirarDados()).thenReturn(6).thenReturn(2);
        when(mockedEjercitoDefensor.tirarDados()).thenReturn(5).thenReturn(4);

        Pais paisAtacante = new Pais("Argentina", mockedEjercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", mockedEjercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);
        batalla.luchar();

        assertSame(paisDefensor.obtenerEjercito(), mockedEjercitoDefensor);
    }
}
