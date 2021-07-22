package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Parser {
    public Hashtable<String, Pais> cargarPaises(String rutaArchivo) throws IOException{
        Hashtable<String, Pais> paises = new Hashtable<String, Pais>();
        
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            ArrayList<String> listaConPaises = new ArrayList<String>();
            Collections.addAll(listaConPaises, data);

            String nombrePais = listaConPaises.get(0);
            Pais nuevoPais = new Pais();
            nuevoPais.asignarNombre(nombrePais);

            paises.put(nombrePais, nuevoPais);
        }
        csvReader.close();
        return paises;
    }

    public Hashtable<String, Continente> cargarContinentes(String rutaArchivo) throws IOException{
        Hashtable<String, Continente> continentes = new Hashtable<String, Continente>();
        
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            ArrayList<String> listaConPaises = new ArrayList<String>();
            Collections.addAll(listaConPaises, data);

            String nombreContinente = listaConPaises.get(0);
            Continente nuevoContinente = new Continente();
            nuevoContinente.asignarNombre(nombreContinente);

            continentes.put(nombreContinente,nuevoContinente);
        }
        csvReader.close();
        return continentes;
    }
}
