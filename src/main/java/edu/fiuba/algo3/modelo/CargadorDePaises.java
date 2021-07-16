package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CargadorDePaises {

    public static HashMap<String,Pais> cargarPaisesConRuta(String ruta) throws LeerArchivoError {
        String extension = extraerExtension(ruta);
        if (extension.equals("csv")) return cargarCsv(ruta);
        return null;
    }

    private static String extraerExtension(String ruta) {
        String[] partes = ruta.split(".");
        return partes[partes.length - 1];
    }

    private static HashMap<String,Pais> cargarCsv(String ruta) throws LeerArchivoError {
        HashMap<String,Pais> paises = new HashMap<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(ruta));
            String row;
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] linea = row.split(",");
                String nombrePais = linea[0];
                String nombreContinente = linea[1];
                String[] nombresVecinos = linea[2].replaceAll("\"","").split(",");
                paises.putIfAbsent(nombrePais, new Pais(nombrePais));
                for (String nombreVecino: nombresVecinos) {
                    paises.putIfAbsent(nombreVecino, new Pais(nombreVecino));
                    paises.get(nombrePais).agregarVecino(paises.get(nombreVecino));
                }
            }
            csvReader.close();
            return paises;
        } catch (IOException e) {
            throw new LeerArchivoError(ruta);
        }
    }
}

