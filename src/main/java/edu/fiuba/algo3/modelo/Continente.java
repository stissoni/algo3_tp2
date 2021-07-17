package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {
    String nombreDelContinente;
    ArrayList<Pais> listaDePaises = new ArrayList<>();

    public Continente(String nombreDelContinente){
    this.nombreDelContinente = nombreDelContinente;
    }

    public boolean tieneElMismoNombre(String nombreDelContinente){
        return nombreDelContinente.equals(this.nombreDelContinente);
    }

    public void agregarPais(Pais nuevoPais) {
        listaDePaises.add(nuevoPais);
    }

    public int cantidadDePaises() {
        return listaDePaises.size();
    }

    public Pais buscarPais(String nombrePais) {
        for (Pais pais : listaDePaises){
            if(pais.tieneElMismoNombre(nombrePais)) return pais;
        }
        return null;
    }

    public void repartirOcupacionDePaises(Jugadores listaDeJugadores) {
        listaDePaises.forEach(pais -> {
            Jugador unJugadorOcupante = listaDeJugadores.siguienteJugador();
            pais.ocuparPor(unJugadorOcupante);
            unJugadorOcupante.agregarPaisOcupado(pais);
        });
    }

    /**Metodo solo usado para prueba*/
    public int contarPaisesAsignadosA(Jugador unJugador) {
        int cantidadPaisesAsignados = 0;
        for (Pais pais : listaDePaises){
            if (pais.estaOcupadoPor(unJugador)) cantidadPaisesAsignados++;
        }
        return cantidadPaisesAsignados;
    }

    /**Metodo solo usado para prueba
     * @param unJugador Jugador que va a controlar el continente*/
    public void controlarPor(Jugador unJugador) {
        for (Pais pais : listaDePaises){
            Ejercito ejercitoConquistador = new Ejercito(1,unJugador);
            pais.ganarControlPor(ejercitoConquistador);
        }
    }
}
