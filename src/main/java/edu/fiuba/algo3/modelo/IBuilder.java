package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface IBuilder {
    public void reset();

    public void asignarNombre(String nombre);

    public void cargarPaises(ArrayList<Pais> paises);
}
