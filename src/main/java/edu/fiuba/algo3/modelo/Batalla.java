package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

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
        this.ejercitoDefensor = this.paisDefensor.obtenerEjercito();
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

    public void luchar() throws EjercitoYaVencidoException{
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

    public void tirarDadosRandomYLuchar() throws EjercitoYaVencidoException {
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

    public void definirGananadorDeLaBatalla() throws EjercitosDeJugadoresDiferentesException{
        if (this.paisDefensor.obtenerNumeroTotalDeTropas() == 0){
            this.paisDefensor.asignarEjercito(this.ejercitoAtacante);
        }
        else this.paisAtacante.reagruparEjercito(this.ejercitoAtacante);
    }
}
