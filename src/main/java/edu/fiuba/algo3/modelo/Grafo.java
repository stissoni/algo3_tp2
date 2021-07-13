package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.VerticeNoExisteError;

import java.util.*;

public class Grafo {
    // Grafo simple, no dirigido, no pesado.
    private Map<String, Set<String>> vertices;

    public Grafo() {
        vertices = new HashMap<>();
    }

    public void agregarVertice(String nombreVertice) {
        vertices.putIfAbsent(nombreVertice, new HashSet<>());
    }

    public void agregarArista(String nombreVertice, String otroNombreVertice) throws VerticeNoExisteError {
        if (!existeVertice(nombreVertice)) throw new VerticeNoExisteError(nombreVertice);
        if (!existeVertice(otroNombreVertice)) throw new VerticeNoExisteError(otroNombreVertice);
        if (nombreVertice.equals(otroNombreVertice)) return;
        vertices.get(nombreVertice).add(otroNombreVertice);
        vertices.get(otroNombreVertice).add(nombreVertice);
    }

    public boolean estanUnidos(String nombreVertice, String otroNombreVertice) throws VerticeNoExisteError {
        if (!existeVertice(nombreVertice)) throw new VerticeNoExisteError(nombreVertice);
        if (!existeVertice(otroNombreVertice)) throw new VerticeNoExisteError(otroNombreVertice);
        return vertices.get(nombreVertice).contains(otroNombreVertice);
    }

    public String[] obtenerAdyacentes(String nombreVertice) throws VerticeNoExisteError {
        if (!existeVertice(nombreVertice)) throw new VerticeNoExisteError(nombreVertice);
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

    public String[] obtenerVertices() {
        return vertices.keySet().toArray(new String[0]);
    }
}
