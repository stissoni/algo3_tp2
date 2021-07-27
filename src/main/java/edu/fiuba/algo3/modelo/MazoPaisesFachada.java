package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MazoPaisesFachada {
    MazoPaises mazo;
    ArrayList<String[]> archivoParseado;
    int lineaActual;

    public MazoPaisesFachada(MazoPaises mazo) {
        this.mazo = mazo;
        lineaActual = 0;
        archivoParseado = new ArrayList<>();
    }

    public void parsearArchivoMazo(String ruta, String formato) {
        if (formato.equals("csv")) {
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(ruta));
                String row = csvReader.readLine();
                while (row != null) {
                    String[] linea = row.split(",");
                    archivoParseado.add(linea);
                    row = csvReader.readLine();
                }
                csvReader.close();
            } catch (IOException ignored) {
            }
        }
    }

    public void cargarMazo(){
        while (existeSiguienteLinea()) {
            String PaisActual = devolverNombrePais();
            String simboloActual = devolverSimbolo();
            CartaPais carta = new CartaPais(PaisActual,simboloActual);
            mazo.agregarCarta(carta);
            lineaActual++;
        }
        lineaActual=0;
    }

    private boolean existeSiguienteLinea() {
        return (lineaActual < archivoParseado.size());
    }

    private String devolverNombrePais() {
        return archivoParseado.get(lineaActual)[0];
    }

    private String devolverSimbolo() {
        return archivoParseado.get(lineaActual)[1];
    }

}
