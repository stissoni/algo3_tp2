package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {
    private final Grafo grafo = new Grafo();

    @Test
    public void grafoNuevoEstaVacio() {
        assertTrue(grafo.estaVacio());
    }

    @Test
    public void agregarVerticeTieneTamanoUno() {
        grafo.agregarVertice("unVertice");
        assertEquals(1, grafo.size());
    }

    @Test
    public void tresVerticesTieneTamanoTres() {
        grafo.agregarVertice("1");
        grafo.agregarVertice("3");
        grafo.agregarVertice("2");
        assertEquals(3, grafo.size());
    }

    @Test
    public void aristaEstreDosVerticesEstanUnidos() {
        grafo.agregarVertice("1");
        grafo.agregarVertice("2");
        grafo.agregarArista("1","2");
        assertTrue(grafo.estanUnidos("1","2"));
    }

    @Test
    public void agregarYLuegoEliminarAristaNoEstanUnidos() {
        grafo.agregarVertice("1");
        grafo.agregarVertice("2");
        grafo.agregarArista("1","2");
        grafo.eliminarArista("1","2");
        assertFalse(grafo.estanUnidos("1","2"));
    }

    @Test
    public void grafoConVerticesNoEstaVacio() {
        grafo.agregarVertice("1");
        grafo.agregarVertice("2");
        assertFalse(grafo.estaVacio());
    }

    @Test
    public void agregarVerticeExisteEnElGrafo() {
        grafo.agregarVertice("1");
        assertTrue(grafo.existeVertice("1"));
    }

    @Test
    public void verticeSinAgregarNoExisteEnElGrafo() {
        grafo.agregarVertice("1");
        assertFalse(grafo.existeVertice("2"));
    }

    @Test
    public void obtenerAdyacentesDevuelveUnArregloDelTamanoEsperado() {
        grafo.agregarVertice("1");
        grafo.agregarVertice("2");
        grafo.agregarVertice("3");
        grafo.agregarVertice("4");
        grafo.agregarArista("1","2");
        grafo.agregarArista("1","3");
        grafo.agregarArista("1","4");

        assertEquals(3, grafo.obtenerAdyacentes("1").length);
    }

}
