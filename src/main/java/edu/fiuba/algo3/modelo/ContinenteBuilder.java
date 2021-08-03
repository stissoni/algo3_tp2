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

    public void asignarTropasAdicionales(){
        String nombreDelContinente = this.resultado.obtenerNombre();
        if (nombreDelContinente.equals("Asia")){
            this.resultado.setTropas(7);
        }
        else if (nombreDelContinente.equals("Europa")){
            this.resultado.setTropas(5);
        }
        else if (nombreDelContinente.equals("America Del Sur")){
            this.resultado.setTropas(3);
        }
        else if (nombreDelContinente.equals("America Del Norte")){
            this.resultado.setTropas(5);
        }
        else if (nombreDelContinente.equals("Oceania")){
            this.resultado.setTropas(2);
        }
        else if (nombreDelContinente.equals("Africa")){
            this.resultado.setTropas(3);
        }
    }

    public Continente obtenerResultado(){
        return this.resultado;
    }
}
