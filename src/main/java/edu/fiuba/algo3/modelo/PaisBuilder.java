package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PaisBuilder implements Builder {
    private Pais resultado;

    public void reset(){
        this.resultado = new Pais();
    }

    public void asignarNombre(String nombre){
        this.resultado.asignarNombre(nombre);
    }

    public void cargarPaises(ArrayList<Pais> paises){
        for (Pais unPais: paises){
            this.resultado.agregarPaisLimitrofe(unPais);
        }
    }

    public Pais obtenerResultado(){
        return this.resultado;
    }
}
