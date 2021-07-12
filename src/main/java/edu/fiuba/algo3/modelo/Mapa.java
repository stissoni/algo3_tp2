package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mapa {
    Grafo grafoPaises;

    public Mapa(String ruta) {
        grafoPaises = new Grafo();
        cargarPaises(ruta);
    }

    public void cargarPaises(String ruta) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(ruta));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] linea = row.split(",");
                String paisOrigen = linea[0];
                String continente = linea[1];
                grafoPaises.agregarVertice(paisOrigen);
                for (String pais: linea) {
                    if (pais.equals(paisOrigen) || pais.equals(continente)) continue;
                    grafoPaises.agregarVertice(pais);
                    grafoPaises.agregarArista(paisOrigen,pais);
                }
            }
            csvReader.close();
        } catch (IOException e) {
            // lanzar una excepcion de error al leer archivo
            e.printStackTrace();
        }
    }
    public int size() {
        return grafoPaises.size();
    }

    public boolean puedeAtacar(String unNombrePais, String otroNombrePais) {
        return grafoPaises.estanUnidos(unNombrePais,otroNombrePais);
    }

    public List<String> obtenerPaises() {
        return Arrays.asList(grafoPaises.obtenerVertices());
    }

    public List<String> obtenerPaisesMezclados() {
        List<String> paises = obtenerPaises();
        Collections.shuffle(paises);
        return paises;
    }
}
