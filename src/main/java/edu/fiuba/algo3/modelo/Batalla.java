package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Batalla {
    private Pais paisAtacante;
    private Pais paisDefensor;
    private Ejercito ejercitoAtacante;
    private Ejercito ejercitoDefensor;
    private ArrayList<Dado> dadosAtacante;
    private ArrayList<Dado> dadosDefensor;
    private int numeroDadosAComparar;

    public Batalla(Pais paisAtacante, Pais paisDefensor){
        this.paisAtacante = paisAtacante;
        //Lanzar excepcion si el país Atacante no está vinculado con el Defensor.
        this.paisDefensor = paisDefensor;
    }

    public void asignarEjercitoAtacante(Ejercito unEjercito){
        this.ejercitoAtacante = unEjercito;
    }

    public void asignarEjercitoDefensor(Ejercito unEjercito){
        this.ejercitoDefensor = unEjercito;
    }

    public void asignarDados(ArrayList<Dado> dadosAtacante, ArrayList<Dado> dadosDefensor){
        this.dadosAtacante = dadosAtacante;
        this.dadosDefensor = dadosDefensor;
        this.dadosAtacante.sort(Collections.reverseOrder());
        this.dadosDefensor.sort(Collections.reverseOrder());
        this.numeroDadosAComparar = Math.min(dadosAtacante.size(),dadosDefensor.size());
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

    public void luchar(){
        int index = 0;
        Dado dadoAtacante;
        Dado dadoDefensor;
        while (index < this.numeroDadosAComparar){
            dadoAtacante = this.dadosAtacante.get(index);
            dadoDefensor = this.dadosDefensor.get(index);
            if (dadoAtacante.esMayorQue(dadoDefensor)){
                this.paisAtacante.vencer(this.paisDefensor);
            }
            else {
                this.paisDefensor.vencer(this.paisAtacante);
            }
            index = index + 1;
        }
    }

    public void tirarDadosRandomYLuchar(){
        ArrayList<Dado> dadosAtaque = Dado.tirar(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        ArrayList<Dado> dadosDefensa = Dado.tirar(ejercitoDefensor.obtenerNumeroTotalDeTropas());
        asignarDados(dadosAtaque,dadosDefensa);

        for (int i = 0;i<this.numeroDadosAComparar;i++){
            Dado dadoDeAtaque = this.dadosAtacante.get(i);
            Dado dadoDeDefensa = this.dadosDefensor.get(i);
            if (dadoDeAtaque.esMayorQue(dadoDeDefensa)) paisAtacante.vencer(paisDefensor);
            else paisDefensor.vencer(paisAtacante);
        }
    }


    public void definirGananadorDeLaBatalla(){
        if (this.paisDefensor.obtenerNumeroTotalDeTropas() == 0) {
            this.paisDefensor.entregarControlAlEjercito(this.ejercitoAtacante);
        }
        else this.paisAtacante.reagruparEjercito(this.ejercitoAtacante);
    }
}
