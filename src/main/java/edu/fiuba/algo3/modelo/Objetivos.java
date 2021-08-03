package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Objetivos {
    ArrayList<ObjetivoSecreto> MazoObjetivosSecretos;

    public Objetivos(String rutaArchivoDeDatos) {
        MazoObjetivosSecretos = new ArrayList<>();
        inicializarMazoObjetivos(rutaArchivoDeDatos);
    }

    /**Carga el mazo del archivo parseado */
    private void inicializarMazoObjetivos(String rutaArchivoPaises) {
        ObjetivosFachada facade = new ObjetivosFachada(this);
        facade.parsearArchivoMazo(rutaArchivoPaises,"csv");
        facade.cargarMazo();
    }

    /**Agrega una carta Pais al mazo*/
    void agregarObjetivo(ObjetivoSecreto nuevoObjetivo) {
        MazoObjetivosSecretos.add(nuevoObjetivo);
    }
}
