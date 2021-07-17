package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;

public class Batalla {
    private Ejercito ejercitoAtacante;
    private Ejercito ejercitoDefensor;

    public void asignarEjercitos(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
        this.ejercitoAtacante = ejercitoAtacante;
        this.ejercitoDefensor = ejercitoDefensor;
    }

    public Ejercito obtenerEjercitoAtacante(){
        return this.ejercitoAtacante;
    }

    public Ejercito obtenerEjercitoDefensor(){
        return this.ejercitoDefensor;
    }

    public void luchar(ArrayList<Dado> dadosAtacante, ArrayList<Dado> dadosDefensor) throws EjercitoYaVencidoException{
        Dado dadoAtacante;
        Dado dadoDefensor;
        int numeroDadosAComparar = Math.min(
            dadosAtacante.size(),
            dadosDefensor.size()
        );
        int index = 0;
        while (index < numeroDadosAComparar){
            dadoAtacante = dadosAtacante.get(index);
            dadoDefensor = dadosDefensor.get(index);
            if (dadoAtacante.esMayorQue(dadoDefensor)){
                this.ejercitoAtacante.vencer(this.ejercitoDefensor);
            }
            else {
                this.ejercitoDefensor.vencer(this.ejercitoAtacante);
            }
            index = index + 1;
        }
    }
}
