package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class BatallaTest {
    @Test
    public void testNumeroDeDadosAtacanteMayorA3(){
        Ejercito ejercitoAtacante = mock(Ejercito.class);
        Ejercito ejercitoDefensor = mock(Ejercito.class);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(3, batalla.obtenerNumeroDadosAtacante(4));
    }

    @Test
    public void testNumeroDeDadosAtacanteMenorA3(){
        Ejercito ejercitoAtacante = mock(Ejercito.class);
        Ejercito ejercitoDefensor = mock(Ejercito.class);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(2, batalla.obtenerNumeroDadosAtacante(2));
    }

    @Test
    public void testNumeroDeDadosAComparar(){
        Ejercito ejercitoAtacante = mock(Ejercito.class);
        Ejercito ejercitoDefensor = mock(Ejercito.class);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(2, batalla.obtenerNumeroDadosAComparar(4, 2));
    }
}
