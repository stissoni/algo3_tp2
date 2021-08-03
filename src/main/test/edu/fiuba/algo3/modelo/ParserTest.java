package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

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

    @Test
    public void testPaisesLimitrofesDeArgentina() throws IOException {
        Parser parser = new Parser();
        Hashtable<String, List<String>> paisesLimitrofes = parser.cargarLimitrofes("./src/main/java/edu/fiuba/algo3/modelo/paises.csv");

        assertEquals(5, paisesLimitrofes.get("Brasil").size());
        for (String paisLimitrofeDeArgentina: paisesLimitrofes.get("Brasil")){
            System.out.println(paisLimitrofeDeArgentina);
        }
    }
}
