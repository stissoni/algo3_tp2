package edu.fiuba.algo3.modelo;

public class CartaPais {
    private String nombrePais;
    private String simbolo;

    public CartaPais(String nombre, String simbolo){
        this.nombrePais = nombre;
        this.simbolo = simbolo;
    }

    public String obtenerNombrePais(){  
        return this.nombrePais;  
    }

    public String obtenerSimbolo(){
        return this.simbolo;
    }
}
