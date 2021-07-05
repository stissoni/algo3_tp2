package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Batalla {
    private Pais paisAtacante;
    private Pais paisDefensor;
    private ArrayList<Dado> dadosAtacante;
    private ArrayList<Dado> dadosDefensor;

    public Batalla(Pais paisAtacante, Pais paisDefensor){
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
    }

    public int obtenerNumeroDadosAtacante(int numeroTropasAtacan){
        int numeroDeDadosAtacante = numeroTropasAtacan;
        if (numeroDeDadosAtacante > 3){
            numeroDeDadosAtacante = 3;
        }
        return numeroDeDadosAtacante;
    }

    public void asignarDadosAtacante(ArrayList<Dado> dados){
        this.dadosAtacante = dados;
    }

    public void asignarDadosDefensor(ArrayList<Dado> dados){
        this.dadosAtacante = dados;
    }

    public int obtenerNumeroDadosAComparar(int numeroDadosAtacante, int numeroDadosDefensor){
        int numeroDadosAComparar;
        if (numeroDadosAtacante > numeroDadosDefensor){
            numeroDadosAComparar = numeroDadosDefensor;
        }
        else {
            numeroDadosAComparar = numeroDadosAtacante;
        }
        return numeroDadosAComparar;
    }

    public ArrayList<Dado> obtenerDadosAtacante(){
        return this.dadosAtacante;
    }

    public ArrayList<Dado> obtenerDadosDefensor(){
        return this.dadosDefensor;
    }

    public void luchar(){
        // Se puede (o se debe) mejorar sustancialmente.
        int numeroDadosAtacante = this.obtenerNumeroDadosAtacante(this.paisAtacante.obtenerNumeroTotalDeTropas());
        int numeroDadosDefensor = this.paisDefensor.obtenerNumeroTotalDeTropas();
        int index = 0;
        while (index < this.obtenerNumeroDadosAComparar(numeroDadosAtacante, numeroDadosDefensor)){
            if (dadosAtacante.get(index).esMayorQue(dadosDefensor.get(index))){
                this.paisAtacante.vencer(this.paisDefensor);
            }
            else {
                this.paisDefensor.vencer(this.paisAtacante);
            }
        }
    }
}
