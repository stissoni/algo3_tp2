package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MapaBuilder {
    Mapa resultado;

    public void reset(){
        this.resultado = new Mapa();
    }

    public void asignarPaises() throws IOException{
        Parser parser = new Parser();
        Director director = new Director();
        PaisBuilder paisBuilder = new PaisBuilder();

        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/paises.csv";
        
        ArrayList<String> paises = parser.cargar(rutaArchivo);

        for(String nombrePais: paises){
            director.crearTerritorio(paisBuilder, nombrePais);
            Pais nuevoPais = paisBuilder.obtenerResultado();
            this.resultado.agregarPais(nuevoPais);
        }
    }

    public void asignarContinentes() throws IOException{
        Parser parser = new Parser();
        Director director = new Director();
        ContinenteBuilder continenteBuilder = new ContinenteBuilder();

        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/paises.csv";
        
        ArrayList<String> continentes = parser.cargarContinentes(rutaArchivo);

        for(String nombreContinente: continentes){
            director.crearTerritorio(continenteBuilder, nombreContinente);
            Continente nuevoContinente = continenteBuilder.obtenerResultado();
            this.resultado.agregarContinente(nuevoContinente);
        }
    }

    public void asignarPaisesLimitrofes() throws IOException{
        Parser parser = new Parser();
        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/paises.csv";
        
        Hashtable<String, List<String>> paisesLimtrofes = parser.cargarLimitrofes(rutaArchivo);
        
        for (String nombrePais: paisesLimtrofes.keySet()){
            Pais unPais = this.resultado.obtenerUnPais(nombrePais);
            for (String nombreDelLimitrofe: paisesLimtrofes.get(nombrePais)){
                Pais paisLimitrofe = this.resultado.obtenerUnPais(nombreDelLimitrofe);
                unPais.agregarPaisLimitrofe(paisLimitrofe);
            }
        }
    }

    public void asignarPaisesAContinentes() throws IOException{
        Parser parser = new Parser();
        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/paises.csv";
        
        Hashtable<String, List<String>> continentesYSusPaises = parser.cargarPaisesDeContinentes(rutaArchivo);

        for (String nombreDelContinente: continentesYSusPaises.keySet()){
            Continente unContinente = this.resultado.obtenerUnContinente(nombreDelContinente);
            for (String nombrePais: continentesYSusPaises.get(nombreDelContinente)){
                Pais unPais = this.resultado.obtenerUnPais(nombrePais);
                unContinente.agregarPais(unPais);
            }
        }
    }

    public Mapa obtenerResultado(){
        return this.resultado;
    }
}
