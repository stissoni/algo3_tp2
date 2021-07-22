package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Director {
    public void crearTerritorio(IBuilder builder, String nombre, ArrayList<Pais> paises){
        builder.reset();
        builder.asignarNombre(nombre);
        builder.cargarPaises(paises);
    }
}
