package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoSecreto {
    private final String tipoDeObjetivo;
    private final ArrayList<ContinenteAConquistar> continentes;
    private final String jugadorADerrotar;

    public ObjetivoSecreto(String tipoDeObjetivo, ArrayList<ContinenteAConquistar> continente, String JugadorADerrotar ){
        this.tipoDeObjetivo = tipoDeObjetivo;
        this.continentes = new ArrayList<>();
        if (tipoDeObjetivo.equalsIgnoreCase("Conquista")) {
            this.jugadorADerrotar="Ninguno";
            for (int i=0; i< continente.size(); i++){
                this.continentes.set(i, continente.get(i));
            }
        }
        else{
            this.jugadorADerrotar=JugadorADerrotar;
        }
    }

    public String obtenerTipoDeOjetivo(){  
        return this.tipoDeObjetivo;  
    }

    public String obtenerJugadorADerrotar(){
        return this.jugadorADerrotar;
    }

    public ArrayList<ContinenteAConquistar> obtenerContinentesADerrotar(){ 
        return this.continentes;
    }
}
