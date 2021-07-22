package edu.fiuba.algo3.modelo;


public class Director {
    public void crearPais(Builder builder, String nombre){
        builder.reset();
        builder.asignarNombre(nombre);
    }

    public void crearContinente(Builder builder, String nombre){
        builder.reset();
        builder.asignarNombre(nombre);
    }
}
