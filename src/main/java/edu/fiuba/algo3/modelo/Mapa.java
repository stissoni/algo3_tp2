package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;
import java.util.ArrayList;

public class Mapa {
    ArrayList<Continente> listaDeContinentes;

    public Mapa(String ruta) throws LeerArchivoError {
        listaDeContinentes = new ArrayList<>();
        cargarPaises(ruta);
    }

    private void cargarPaises(String rutaArchivoPaises) throws LeerArchivoError {
        Fachada archivoParseado = new Fachada(rutaArchivoPaises,"csv");
        archivoParseado.cargarPaises(this);
    }

    public void agregarContinente(Continente nuevoContinente) {
        listaDeContinentes.add(nuevoContinente);
    }

    public Continente obtenerContinente(String nombreContinente) {
        for (Continente continente : listaDeContinentes){
            if (continente.tieneElMismoNombre(nombreContinente)) return continente;
        }
        return null;
    }

    public boolean continenteYaCreado(String nombreContinente) {
        for (Continente continente : listaDeContinentes){
            if (continente.tieneElMismoNombre(nombreContinente)) return true;
        }
        return false;
    }


    /** Método solo usado para prueba de mapa */
    private int cantidadDePaisesCreados(){
        int cantidad = 0;
        for (Continente continente : listaDeContinentes){
            cantidad+= continente.cantidadDePaises();
        }
        return cantidad;
    }

    /** Método solo usado para prueba de mapa */
    public boolean mapaFueCreadoCorrectamente(){
        final int continentesEsperados = 6;
        final int paisesEsperados = 50;
        return listaDeContinentes.size() == continentesEsperados && cantidadDePaisesCreados() == paisesEsperados;
    }
}
