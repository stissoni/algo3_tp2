package edu.fiuba.algo3.modelo;

public class CartaPais {
    private final String nombrePais;
    private final String simbolo;

    public CartaPais(String nombre, String id){
        this.nombrePais = nombre;
        this.simbolo = id;
    }

    public String obtenerNombrePais(){  return this.nombrePais;  }

    public String obtenerSimbolo(){
        return this.simbolo;
    }

}
