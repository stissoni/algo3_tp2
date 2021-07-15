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
}
