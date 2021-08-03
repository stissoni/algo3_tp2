package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class ObjetivosBuilder {
    private ArrayList<ObjetivoConquista> resultado;

    public void reset(){
        this.resultado = new ArrayList<ObjetivoConquista>();
    }

    public void cargarObjetivos(Mapa mapaJuego) throws IOException{
        Parser parser = new Parser();

        String rutaObjetivos = "./src/main/java/edu/fiuba/algo3/modelo/objetivos.csv";
        ArrayList<Hashtable<String, Integer>> objetivos = parser.cargarObjetivos(rutaObjetivos);
        
        for (Hashtable<String, Integer> objetivo: objetivos){
            ObjetivoConquista nuevoObjetivo = new ObjetivoConquista();
            for (String nombreContinenteObjetivo: objetivo.keySet()){
                Continente contienenteObjetivo = mapaJuego.obtenerUnContinente(nombreContinenteObjetivo);
                int numeroPaisesDelContinente = objetivo.get(nombreContinenteObjetivo);
                nuevoObjetivo.agregarContinenteAConquistar(contienenteObjetivo, numeroPaisesDelContinente);
            }
            this.resultado.add(nuevoObjetivo);
        }
    }

    public ArrayList<ObjetivoConquista> obtenerResultado(){
        return this.resultado;
    }
}
