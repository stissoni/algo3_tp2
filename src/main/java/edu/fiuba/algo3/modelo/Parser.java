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

    public ArrayList<String> cargarContinentes(String rutaArchivo) throws IOException{
        ArrayList<String> continentes = new ArrayList<String>();
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (!continentes.contains(data[1])){
                continentes.add(data[1]);
            }
        }
        csvReader.close();
        return continentes;
    }

    public Hashtable<String, List<String>> cargarPaisesDeContinentes(String rutaArchivo) throws IOException{
        Hashtable<String, List<String>> continentesYSusPaises = new Hashtable<String, List<String>>();
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            ArrayList<String> filaDelCSV = new ArrayList<String>(Arrays.asList(data));

            String nombreDelContinente = filaDelCSV.get(1);
            String paisDeLaFila = filaDelCSV.get(0);
            List<String> paisesDelContinente;

            if(!continentesYSusPaises.keySet().contains(nombreDelContinente)){
                paisesDelContinente = new ArrayList<String>();
                paisesDelContinente.add(paisDeLaFila);
                continentesYSusPaises.put(nombreDelContinente, paisesDelContinente);
            }
            else {
                paisesDelContinente = continentesYSusPaises.get(nombreDelContinente);
                paisesDelContinente.add(paisDeLaFila);
                continentesYSusPaises.replace(nombreDelContinente, paisesDelContinente);
            }
        }
        csvReader.close();
        return continentesYSusPaises;
    }

    public ArrayList<Hashtable<String, Integer>> cargarObjetivos(String rutaArchivo) throws IOException{
        ArrayList<Hashtable<String, Integer>> objetivos = new ArrayList<Hashtable<String, Integer>>();
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            ArrayList<String> filaDelCSV = new ArrayList<String>(Arrays.asList(data));

            Hashtable<String, Integer> objetivo = new Hashtable<String, Integer>();
            int index = 1;
            while (index < filaDelCSV.size()){
                objetivo.put(filaDelCSV.get(index), Integer.parseInt(filaDelCSV.get(index+1)));
                index = index + 2;
            }
            objetivos.add(objetivo);
        }
        csvReader.close();
        return objetivos;
    }
}
