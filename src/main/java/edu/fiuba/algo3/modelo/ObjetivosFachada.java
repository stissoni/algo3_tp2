package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjetivosFachada {
    Objetivos mazo;
    ArrayList<String[]> archivoParseado;
    int lineaActual;

    public ObjetivosFachada(Objetivos mazo) {
        this.mazo = mazo;
        lineaActual = 0;
        archivoParseado = new ArrayList<>();
    }

    public void parsearArchivoMazo(String ruta, String formato) {
        if (formato.equals("csv")){
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(ruta));
                String row = csvReader.readLine();
                    while (row != null) {
                        String[] linea = row.split(",");
                        archivoParseado.add(linea);
                        row = csvReader.readLine();
                    }
                    csvReader.close();
            } catch (IOException ignored) { }
        }
    }

    public void cargarMazo(){
        while (existeSiguienteLinea()) {
            String TipoDeObjetivo = devolverTipoDeObjetivo();
            ArrayList<ContinenteAConquistar> continentes = new ArrayList<>();
            String jugadorADerrotar=devolverJugadorADerrotar();
            if(TipoDeObjetivo.equalsIgnoreCase("Conquista")){
                jugadorADerrotar="Ninguno";
                for (int i=1; i<=longitudDatosDeLinea(); i++ ){
                    String nombreContinente=devolverNombreContinente(i);
                    i++;
                    int CantidadDePaisesAConquistar =devolverCantidadDePaisesAConquistar(i);
                    ContinenteAConquistar Continente= new ContinenteAConquistar(nombreContinente, CantidadDePaisesAConquistar);
                }
            }
            ObjetivoSecreto Objetivo = new ObjetivoSecreto(TipoDeObjetivo,continentes,devolverJugadorADerrotar());
            mazo.agregarObjetivo(Objetivo);
            lineaActual++;
        }
        lineaActual=0;
    }

    private boolean existeSiguienteLinea() {
            return (lineaActual < archivoParseado.size());
        }

    private String devolverTipoDeObjetivo() {
            return archivoParseado.get(lineaActual)[0];
        }

    private String devolverJugadorADerrotar() {
            return archivoParseado.get(lineaActual)[1];
        }
    private int longitudDatosDeLinea() {
        return archivoParseado.get(lineaActual).length;
    }
    private String devolverNombreContinente( int posicion) {
        return archivoParseado.get(lineaActual)[posicion];
    }
    private int devolverCantidadDePaisesAConquistar( int posicion) {
        return Integer.parseInt(archivoParseado.get(lineaActual)[posicion]);
    }

}

