package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MazoPaises {
    ArrayList<CartaPais> mazoDePaises;

    public MazoPaises(String rutaArchivoDeDatos) {
        mazoDePaises = new ArrayList<>();
        inicializarMazo(rutaArchivoDeDatos);
    }

    /**Carga el mazo del archivo parseado */
    private void inicializarMazo(String rutaArchivoPaises) {
        MazoPaisesFachada facade = new MazoPaisesFachada(this);
        facade.parsearArchivoMazo(rutaArchivoPaises,"csv");
        facade.cargarMazo();
    }

    /**Agrega una carta Pais al mazo*/
    void agregarCarta(CartaPais nuevaCarta) {
        mazoDePaises.add(nuevaCarta);
    }
}
