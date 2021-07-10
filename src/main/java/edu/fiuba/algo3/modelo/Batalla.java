package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;

public class Batalla {
    private Ejercito ejercitoAtacante;
    private Ejercito ejercitoDefensor;
    private ArrayList<Dado> dadosAtacante;
    private ArrayList<Dado> dadosDefensor;
    private int numeroDadosAComparar;

    public void asignarEjercitos(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
        this.ejercitoAtacante = ejercitoAtacante;
        this.ejercitoDefensor = ejercitoDefensor;
    }

    public void asignarDados(ArrayList<Dado> dadosAtacante, ArrayList<Dado> dadosDefensor){
        this.dadosAtacante = dadosAtacante;
        this.dadosDefensor = dadosDefensor;
    }

    public void asignarNumeroDadosAComparar(){
        this.numeroDadosAComparar = Math.min(
            this.dadosAtacante.size(),
            this.dadosDefensor.size()
        );
    }

    public int obtenerNumeroDadosAComparar(){
        return this.numeroDadosAComparar;
    }

    public ArrayList<Dado> obtenerDadosAtacante(){
        return this.dadosAtacante;
    }

    public ArrayList<Dado> obtenerDadosDefensor(){
        return this.dadosDefensor;
    }

    public Ejercito obtenerEjercitoAtacante(){
        return this.ejercitoAtacante;
    }

    public Ejercito obtenerEjercitoDefensor(){
        return this.ejercitoDefensor;
    }

    public void luchar() throws EjercitoYaVencidoException{
        Dado dadoAtacante;
        Dado dadoDefensor;
        int index = 0;
        while (index < this.numeroDadosAComparar){
            dadoAtacante = this.dadosAtacante.get(index);
            dadoDefensor = this.dadosDefensor.get(index);
            if (dadoAtacante.obtenerValor() > dadoDefensor.obtenerValor()){
                this.ejercitoAtacante.vencer(this.ejercitoDefensor);
            }
            else {
                this.ejercitoDefensor.vencer(this.ejercitoAtacante);
            }
            index = index + 1;
        }
    }
}
