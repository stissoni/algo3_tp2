package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapaFachada {
    Mapa mapa;
    ArrayList<String[]> archivoParseado;
    int lineaActual;

    public MapaFachada(Mapa mapa) {
        this.mapa = mapa;
        lineaActual = 0;
        archivoParseado = new ArrayList<>();
    }

    public void parsearArchivo(String ruta, String formato) {
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
            } catch (IOException ignored) { //Temp
            }
        }
    }

    public void cargarPaises(){
        while (existeSiguienteLinea()) {
            String nombreContinente = devolverNombreContinente();
            String nombrePais = devolverNombrePais();
            Continente continenteParaAsignarPais = mapa.buscarContinente(nombreContinente);

            if (continenteParaAsignarPais==null) {
                Continente nuevoContinente = new Continente(nombreContinente);
                mapa.agregarContinente(nuevoContinente);
                continenteParaAsignarPais = nuevoContinente;
            }
            Pais nuevoPais = new Pais(nombrePais);
            continenteParaAsignarPais.agregarPais(nuevoPais);
            lineaActual++;
        }
        lineaActual=0;
    }

    public void asignarPaisesLimitrofes(){
        while (existeSiguienteLinea()) {
            String nombrePais = devolverNombrePais();
            Pais unPais = mapa.buscarPais(nombrePais);
            ArrayList<String> listaNombrePaisesLimitrofes = devolverNombrePaisesLimitrofes();
            for (String nombrePaisLimitrofe : listaNombrePaisesLimitrofes){
                Pais unPaisLimitrofe = mapa.buscarPais(nombrePaisLimitrofe);
                unPais.agregarPaisLimitrofe(unPaisLimitrofe);
                unPaisLimitrofe.agregarPaisLimitrofe(unPais);
            }
            lineaActual++;
        }
    }

    private boolean existeSiguienteLinea() {
        return (lineaActual < archivoParseado.size());
    }

    private String devolverNombrePais() {
        return archivoParseado.get(lineaActual)[0];
    }

    private String devolverNombreContinente() {
        return archivoParseado.get(lineaActual)[1];
    }

    private ArrayList<String> devolverNombrePaisesLimitrofes() {
        ArrayList<String> limitrofes = new ArrayList<>();
        String pais = devolverNombrePais();
        String continente = devolverNombreContinente();
        for (String elemento : archivoParseado.get(lineaActual)) {
            if (!elemento.equals(pais) && !elemento.equals(continente)) limitrofes.add(elemento);
        }
        return limitrofes;
    }

    /**Método solo para prueba*/
    public boolean parserDevuelveResultadoEsperado(){
        lineaActual = 0;
        String nombrePais = devolverNombrePais();
        String nombreContinente = devolverNombreContinente();
        return nombrePais.equals("Argentina") && nombreContinente.equals("America Del Sur");
    }
}
