package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mapa {
    ArrayList<Continente> listaDeContinentes;

    public Mapa(String rutaArchivoDeDatos) {
        listaDeContinentes = new ArrayList<>();
        inicializarMapa(rutaArchivoDeDatos);
    }

    /**Carga los paises del archivo parseado y luego asigna sus limítrofes*/
    private void inicializarMapa(String rutaArchivoPaises) {
        MapaFachada facade = new MapaFachada(this);
        facade.parsearArchivo(rutaArchivoPaises,"csv");
        facade.cargarPaises();
        facade.asignarPaisesLimitrofes();
    }

    public void repartirOcupacionDePaises(Jugadores listaDeJugadores) {
        listaDeContinentes.forEach(continente -> continente.repartirOcupacionDePaises(listaDeJugadores));
    }

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

    /** Método solo usado para prueba de mapa */
    public boolean mapaFueOcupadoCorrectamente(Jugadores listaDeJugadores) {
        final int cantidadDeJugadores = listaDeJugadores.cantidadDeJugadores();
        final int asignadosPorJugador = 50 / cantidadDeJugadores;
        for (int i = 0; i < cantidadDeJugadores; i++) {
            int paisesAsignados = 0;
            Jugador unJugador = listaDeJugadores.siguienteJugador();
            for (Continente continente : listaDeContinentes) {
                paisesAsignados += continente.contarPaisesAsignadosA(unJugador);
            }
            int resultado = asignadosPorJugador - paisesAsignados;
            if (resultado > 1 || resultado < -1) return false;
        }
        return true;
    }
}