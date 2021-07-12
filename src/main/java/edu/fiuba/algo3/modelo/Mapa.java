package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;
import edu.fiuba.algo3.excepciones.PaisNoExisteError;
import edu.fiuba.algo3.excepciones.VerticeNoExisteError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mapa {
    Grafo grafoPaises;

    public Mapa(String ruta) throws LeerArchivoError {
        grafoPaises = new Grafo();
        cargarPaises(ruta);
    }

    private void cargarPaises(String ruta) throws LeerArchivoError {
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
        } catch (IOException | VerticeNoExisteError e) {
            throw new LeerArchivoError(ruta);
        }
    }

    public int size() {
        return grafoPaises.size();
    }

    public boolean puedeAtacar(String unNombrePais, String otroNombrePais) throws PaisNoExisteError {
        try {
            return grafoPaises.estanUnidos(unNombrePais,otroNombrePais);
        } catch (VerticeNoExisteError verticeNoExisteError) {
            throw new PaisNoExisteError(unNombrePais);
        }
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
