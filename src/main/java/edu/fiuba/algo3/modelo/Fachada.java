package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fachada {
    String formato;
    ArrayList<String[]> archivoParseado;
    int iter;

    public Fachada(String ruta, String formato) throws LeerArchivoError {
        this.formato = formato;
        iter = 0;
        archivoParseado = new ArrayList<>();
        if (formato.equals("csv")) {
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(ruta));
                String row = csvReader.readLine();
                while (row != null) {
                    String[] linea = row.split(",");
                    archivoParseado.add(linea);
                    row = csvReader.readLine();
                }
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean existeSiguienteLinea() {
        return (iter < archivoParseado.size());
    }

    public void avanzarLineaActual() {
        iter++;
    }

    public String devolverNombrePais() {
        return archivoParseado.get(iter)[0];
    }

    public String devolverNombreContinente() {
        return archivoParseado.get(iter)[1];
    }

    public ArrayList<String> devolverNombrePaisesLimitrofes() {
        ArrayList<String> limitrofes = new ArrayList<>();
        String pais = devolverNombrePais();
        String continente = devolverNombreContinente();
        for (String elemento : archivoParseado.get(iter)) {
            if (!elemento.equals(pais) && !elemento.equals(continente)) limitrofes.add(elemento);
        }
        return limitrofes;
    }

    public void resetIter() {
        iter = 0;
    }

    public void cargarPaises(Mapa unMapa) {
        ArrayList<Continente> continentes = new ArrayList<>();
        while (existeSiguienteLinea()) {
            String nombreContinente = devolverNombreContinente();
            String nombrePais = devolverNombrePais();
            if (!unMapa.continenteYaCreado(nombreContinente)) {
                Continente nuevoContinente = new Continente(nombreContinente);
                unMapa.agregarContinente(nuevoContinente);
            }
            Pais nuevoPais = new Pais(nombrePais);
            Continente continenteParaAsignarPais = unMapa.obtenerContinente(nombreContinente);
            continenteParaAsignarPais.agregarPais(nuevoPais);
            avanzarLineaActual();
        }
    }
}
