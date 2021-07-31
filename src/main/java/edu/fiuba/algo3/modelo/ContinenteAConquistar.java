package edu.fiuba.algo3.modelo;

public class ContinenteAConquistar {
    private final String nombreContinente;
    private final int cantidadDePaisesAConquistar ;

    public ContinenteAConquistar (String nombre, int cantidad){
        this.nombreContinente = nombre;
        this.cantidadDePaisesAConquistar = cantidad;
    }

    public String obtenerNombreContinente(){  return this.nombreContinente;  }

    public int obtenerCantidadDePaisesAConquistar(){
        return this.cantidadDePaisesAConquistar;
    }

}
