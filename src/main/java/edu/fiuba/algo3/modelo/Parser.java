package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    public ArrayList<String> cargar(String rutaArchivo) throws IOException{
        ArrayList<String> paises = new ArrayList<String>();
        
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            paises.add(data[0]);
        }
        csvReader.close();
        return paises;
    }
}
