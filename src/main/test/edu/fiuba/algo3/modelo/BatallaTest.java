package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BatallaTest {
    @Test
    public void testNumeroDeDadosAtacanteMayorA3(){
        Ejercito ejercitoAtacante = new Ejercito(5);
        Ejercito ejercitoDefensor = new Ejercito(4);

        Batalla batalla = new Batalla(ejercitoAtacante, ejercitoDefensor);

        assertEquals(batalla.obtenerNumeroDadosAtacante(4), 3);
    }

    @Test
    public void testNumeroDeDadosAtacanteMenorA3(){
        Ejercito ejercitoAtacante = new Ejercito(3);
        Ejercito ejercitoDefensor = new Ejercito(1);

        Batalla batalla = new Batalla(ejercitoAtacante, ejercitoDefensor);

        assertEquals(batalla.obtenerNumeroDadosAtacante(2), 2);
    }

    @Test
    public void testNumeroDeDadosAComparar(){
        Ejercito ejercitoAtacante = new Ejercito(5);
        Ejercito ejercitoDefensor = new Ejercito(2);

        Batalla batalla = new Batalla(ejercitoAtacante, ejercitoDefensor);

        assertEquals(batalla.obtenerNumeroDadosAComparar(4, 2), 2);
    }
}
