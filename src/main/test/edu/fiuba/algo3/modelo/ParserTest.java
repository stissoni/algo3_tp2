package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    public void testCantidadPaisesDevueltoPorParser() throws IOException{
        Parser parser = new Parser();
        Hashtable<String, Pais> paises;

        paises = parser.cargarPaises("./src/main/java/edu/fiuba/algo3/modelo/paises.csv");

        assertEquals(50, paises.size());
    }

    @Test
    public void testCantidadContienentesDevueltoPorParser() throws IOException{
        Parser parser = new Parser();
        Hashtable<String, Continente> continentes;

        continentes = parser.cargarContinentes("./src/main/java/edu/fiuba/algo3/modelo/continentes.csv");

        assertEquals(6, continentes.size());
    }

}
