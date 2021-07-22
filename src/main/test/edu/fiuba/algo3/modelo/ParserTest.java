package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class ParserTest {
    @Test
    public void testCantidadPaisesDevueltoPorParser() throws IOException{
        Parser parser = new Parser();
        ArrayList<String> paises;

        paises = parser.cargar("./src/main/java/edu/fiuba/algo3/modelo/paises.csv");

        assertEquals(50, paises.size());
    }

    @Test
    public void testCantidadContienentesDevueltoPorParser() throws IOException{
        Parser parser = new Parser();
        ArrayList<String> continentes;

        continentes = parser.cargar("./src/main/java/edu/fiuba/algo3/modelo/continentes.csv");

        assertEquals(6, continentes.size());
    }

}
