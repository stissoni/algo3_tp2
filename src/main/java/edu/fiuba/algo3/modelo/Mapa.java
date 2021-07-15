package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mapa {
    ArrayList<Continente> listaDeContinentes;

    public Mapa(String ruta) {
        listaDeContinentes = new ArrayList<>();
        cargarPaises(ruta);
    }

    /**Carga los paises del archivo parseado y luego asigna sus limítrofes*/
    private void cargarPaises(String rutaArchivoPaises) {
        MapaFachada facade = new MapaFachada(this);
        facade.parsearArchivo(rutaArchivoPaises,"csv");
        facade.cargarPaises();
        facade.asignarPaisesLimitrofes();
    }


//    public void repartirOcupacionDePaises(ArrayList<Jugador> listaDeJugadores) {
//        facade.repartirOcupacionDePaises(listaDeJugadores,this);
//    }

    /**Agrega un continente al mapa*/
    void agregarContinente(Continente nuevoContinente) {
        listaDeContinentes.add(nuevoContinente);
    }

    /**Devuelve un continente del mapa que tenga el nombre pasado por parámetro, o null si no existe*/
    public Continente buscarContinente(String nombreContinente) {
        for (Continente continente : listaDeContinentes){
            if (continente.tieneElMismoNombre(nombreContinente)) return continente;
        }
        return null;
    }

    /**Devuelve un pais del mapa que tenga el nombre pasado por parámetro, o null si no existe*/
    public Pais buscarPais(String nombrePais) {
        Pais pais = null;
        for (Continente continente : listaDeContinentes){
            pais = continente.buscarPais(nombrePais);
            if (pais != null) break;
        }
        return pais;
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
