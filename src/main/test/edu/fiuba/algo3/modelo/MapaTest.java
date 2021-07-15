package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {
    String ruta = "src/main/java/edu/fiuba/algo3/modelo/paises.csv";
    Mapa mapa = new Mapa(ruta);

    public MapaTest() {
    }

    private void assertThrows(Mapa mapa) {
    }
    
    @Test
    public void rutaInvalidaLanzaExcepcion() {
        assertThrows(new Mapa("Wakanda.csv"));
    }

    @Test
    public void testObtenerContinenteInvalidoDevuelveNull(){
        assertNull(mapa.buscarContinente("Wakanda"));
    }

    @Test
    public void testObtenerPaisInvalidoDevuelveNull(){
        assertNull(mapa.buscarPais("Braavos"));
    }

    @Test
    public void testMapaCreadoCorrectamente(){
        assertTrue(mapa.mapaFueCreadoCorrectamente());
    }
}
