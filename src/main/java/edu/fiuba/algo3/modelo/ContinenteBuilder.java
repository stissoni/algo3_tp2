package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ContinenteBuilder implements Builder{
    private Continente resultado;

    public void reset(){
        this.resultado = new Continente();
    }

    public void asignarNombre(String nombre){
        this.resultado.asignarNombre(nombre);
    }

    public void cargarPaises(ArrayList<Pais> paises){
        for (Pais unPais: paises){
            this.resultado.agregarPais(unPais);
        }
    }

    public Continente obtenerResultado(){
        return this.resultado;
    }
}
