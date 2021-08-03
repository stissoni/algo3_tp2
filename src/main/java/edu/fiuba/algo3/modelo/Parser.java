package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

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

    public Hashtable<String, List<String>> cargarLimitrofes(String rutaArchivo) throws IOException{
        Hashtable<String, List<String>> paisesLimitrofes = new Hashtable<String, List<String>>();
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            ArrayList<String> limitrofes = new ArrayList<String>(Arrays.asList(data));
            paisesLimitrofes.put(limitrofes.get(0), limitrofes.subList(2, limitrofes.size()));
        }
        csvReader.close();
        return paisesLimitrofes;
    }
}
