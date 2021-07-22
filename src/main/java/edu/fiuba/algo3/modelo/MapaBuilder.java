package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.Hashtable;

public class MapaBuilder {
    Mapa resultado;

    public void reset(){
        this.resultado = new Mapa();
    }

    public void asignarPaises() throws IOException{
        Parser parser = new Parser();
        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/paises.csv";
        Hashtable<String, Pais> paises = parser.cargarPaises(rutaArchivo);
        resultado.asignarPaises(paises);
    }

    public void asignarContinentes() throws IOException{
        Parser parser = new Parser();
        String rutaArchivo = "./src/main/java/edu/fiuba/algo3/modelo/continentes.csv";
        Hashtable<String, Continente> continentes = parser.cargarContinentes(rutaArchivo);
        resultado.asignarContinentes(continentes);
    }

    public Mapa obtenerResultado(){
        return this.resultado;
    }
}
