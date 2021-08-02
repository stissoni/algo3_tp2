package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapaBuilder {
    Mapa resultado;
    ArrayList<String[]> archivoParseado;
    int lineaActual = 0;

    public void reset() {
        this.resultado = new Mapa();
    }

    public void asignarPaises() throws IOException {
        Director director = new Director();
        PaisBuilder paisBuilder = new PaisBuilder();

        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/paises.csv";
        archivoParseado = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(rutaArchivo));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            archivoParseado.add(data);
        }
        csvReader.close();

        while (existeSiguienteLinea()) {
            Pais nuevoPais = new Pais(devolverNombrePais());
            for (int i = 2; i < longitudDatosDeLinea(); i++) {
                nuevoPais.agregarPaisLimitrofe(devolverNombrePaisLimitrofe(i));
            }
            this.resultado.agregarPais(nuevoPais);
            lineaActual++;
        }
        lineaActual = 0;
    }

    private boolean existeSiguienteLinea() {
        return (lineaActual < archivoParseado.size());
    }

    private String devolverNombrePais() {
        return archivoParseado.get(lineaActual)[0];
    }

    private String devolverContinente() {
        return archivoParseado.get(lineaActual)[1];
    }

    private int longitudDatosDeLinea() {
        return archivoParseado.get(lineaActual).length;
    }

    private String devolverNombrePaisLimitrofe(int posicion) {
        return archivoParseado.get(lineaActual)[posicion];
    }

    public void asignarContinentes() throws IOException{
        Parser parser = new Parser();
        Director director = new Director();
        ContinenteBuilder continenteBuilder = new ContinenteBuilder();

        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/continentes.csv";
        
        ArrayList<String> continentes = parser.cargar(rutaArchivo);

        for(String nombreContinente: continentes){
            director.crearTerritorio(continenteBuilder, nombreContinente);
            Continente nuevoContinente = continenteBuilder.obtenerResultado();
            this.resultado.agregarContinente(nuevoContinente);
        }
    }

    public Mapa obtenerResultado(){
        return this.resultado;
    }
}
