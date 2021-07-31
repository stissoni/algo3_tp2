package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Tirada {
    private ArrayList<Dado> dados;
    private IDadosStrategy strategy;

    public Tirada(){
        this.dados = new ArrayList<Dado>();
    }

    public void setStrategy(IDadosStrategy unaStrategy){
        this.strategy = unaStrategy;
    }

    public void ordenarDadosDeMayorAMenor(){
        Collections.sort(this.dados);
        Collections.reverse(this.dados);
    }

    public Dado obtenerDado(int indice){
        return this.dados.get(indice);
    }

    public int size(){
        return this.dados.size();
    }

    public Dado get(int index){
        return this.dados.get(index);
    }

    public int compararTiradas(Tirada otraTirada, int numeroDeDados){
        return strategy.compararDados(this, otraTirada, numeroDeDados);
    }

    public void agregarDado(Dado unDado){
        this.dados.add(unDado);
    }

    public String obtenerStringTirada(){
        String tirada = "";
        for (int i = 0; i < this.dados.size(); i++){
            Dado dado = this.dados.get(i);
            if (i == (this.dados.size() - 1)){
                tirada = tirada + dado.obtenerValor();
            }
            else{
                tirada = tirada + dado.obtenerValor()+ " - ";
            }
        }
        return tirada;
    }
}
