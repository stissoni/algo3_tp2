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
    public void testPaisesLimitrofesDeArgentina() throws IOException{
        Parser parser = new Parser();
        Hashtable<String, List<String>> paisesLimitrofes = parser.cargarLimitrofes("./src/main/java/edu/fiuba/algo3/modelo/paises.csv");

        assertEquals(5, paisesLimitrofes.get("Brasil").size());
        for (String paisLimitrofeDeArgentina: paisesLimitrofes.get("Brasil")){
            System.out.println(paisLimitrofeDeArgentina);
        }
    }

    @Test
    public void testPaisesDelContinente() throws IOException{
        Parser parser = new Parser();
        Hashtable<String, List<String>> continentesYSusPaises = parser.cargarPaisesDeContinentes("./src/main/java/edu/fiuba/algo3/modelo/paises.csv");
    
        assertEquals(6, continentesYSusPaises.get("America Del Sur").size());
        for(String nombresDePaises: continentesYSusPaises.get("America Del Norte")){
            System.out.println(nombresDePaises);
        }
    }

    @Test
    public void testObjetivos() throws IOException{
        Parser parser = new Parser();
        ArrayList<Hashtable<String, Integer>> objetivos = parser.cargarObjetivos("./src/main/java/edu/fiuba/algo3/modelo/objetivos.csv");

        assertEquals(6, objetivos.get(0).get("America Del Sur"));

        for (Hashtable<String, Integer> objetivo: objetivos){
            System.out.println("Objetivo...");
            for (String nombreContinente: objetivo.keySet()){
                System.out.println(nombreContinente+" nPaises: "+objetivo.get(nombreContinente));
            }
        }
    }

    @Test 
    public void testTarjetasPais() throws IOException{
        Parser parser = new Parser();
        ArrayList<String[]> tarjetas = parser.cargarTarjetasPais("./src/main/java/edu/fiuba/algo3/modelo/tarjetas.csv");

        assertEquals(50, tarjetas.size());

        for (String[] tarjeta: tarjetas){
            System.out.println(tarjeta[0]+"-"+tarjeta[1]);
        }
    }
}
