package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class FachadaTest {
    String ruta = "src/main/java/edu/fiuba/algo3/modelo/paises.csv";
    Mapa mapa = new Mapa(ruta);
    MapaFachada facadeMapa = new MapaFachada(mapa);
    private Object FileNotFoundException;

    public FachadaTest() {
    }

    private void assertThrows(Object fileNotFoundException) {
    }

    @Test
    public void fachadaParseaCorrectamenteElArchivo() {
        facadeMapa.parsearArchivo(ruta,"csv");
        assertTrue(facadeMapa.parserDevuelveResultadoEsperado());
    }

    @Test
    public void fachadaLanzaExceptionSiLaRutaNoExiste() {
        facadeMapa.parsearArchivo("Wakanda.csv","csv");
        assertThrows(FileNotFoundException);
    }
}
