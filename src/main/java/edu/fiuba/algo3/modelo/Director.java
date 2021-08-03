package edu.fiuba.algo3.modelo;

import java.io.IOException;

public class Director {
    public void crearTerritorio(Builder builder, String nombre){
        builder.reset();
        builder.asignarNombre(nombre);
    }

    public void crearContinente(ContinenteBuilder builder, String nombre){
        builder.reset();
        builder.asignarNombre(nombre);
        builder.asignarTropasAdicionales();
    }

    public void crearMapa(MapaBuilder builder) throws IOException{
        builder.reset();
        builder.asignarPaises();
        builder.asignarContinentes();
        builder.asignarPaisesLimitrofes();
        builder.asignarPaisesAContinentes();
    }

    public void crearObjetivos(ObjetivosBuilder builder, Mapa mapaJuego) throws IOException{
        builder.reset();
        builder.cargarObjetivos(mapaJuego);
    }

    public void crearMazo(MazoPaisBuilder builder) throws IOException{
        builder.reset();
        builder.cargarTarjetas();
    }
}
