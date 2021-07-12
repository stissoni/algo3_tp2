package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.VerticeNoExisteError;

import java.util.*;

public class Grafo {
    // Grafo no dirigido, no pesado.
    Map<String, Set<String>> vertices;

    public Grafo() {
        vertices = new HashMap<String, Set<String>>();
    }

    public void agregarVertice(String nombreVertice) {
        if (vertices.containsKey(nombreVertice)) return;
        vertices.put(nombreVertice, new HashSet<String>());
    }

    public void agregarArista(String nombreVertice, String otroNombreVertice) {
        // if (!existeVertice(nombreVertice)) throw new VerticeNoExisteError(nombreVertice);
        // if (!existeVertice(otroNombreVertice)) throw new VerticeNoExisteError(otroNombreVertice);
        vertices.get(nombreVertice).add(otroNombreVertice);
        vertices.get(otroNombreVertice).add(nombreVertice);
    }

    public void eliminarArista(String nombreVertice, String otroNombreVertice) {
        // si no existe alguna clave en el grafo --> exception.
        vertices.get(nombreVertice).remove(otroNombreVertice);
        vertices.get(otroNombreVertice).remove(nombreVertice);
    }

    public boolean estanUnidos(String nombreVertice, String otroNombreVertice) {
        // si no existe alguna clave en el grafo --> exception.
        return vertices.get(nombreVertice).contains(otroNombreVertice);
    }

    public String[] obtenerAdyacentes(String nombreVertice) {
        // si no existe alguna clave en el grafo --> exception.
        return vertices.get(nombreVertice).toArray(new String[0]);
    }

    public int size() {
        return vertices.size();
    }

    public boolean estaVacio() {
        return vertices.isEmpty();
    }

    public boolean existeVertice(String nombreVertice) {
        return vertices.containsKey(nombreVertice);
    }
}
