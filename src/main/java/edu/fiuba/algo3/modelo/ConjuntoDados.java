package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class ConjuntoDados {
    private ArrayList<Dado> dados;
    private GeneradorAleatorio generador;

    public ConjuntoDados(GeneradorAleatorio generador){
        this.generador = generador;
        this.dados = new ArrayList<Dado>();
    }

    public void tirarDados(int cantidadDados){
        for (int i = 0; i < cantidadDados; i++){
            Dado unDado = new Dado(this.generador);
            unDado.tirar();
            this.dados.add(unDado);
        }
    }

    public void ordenarDadosDeMayorAMenor(){
        Collections.sort(this.dados);
        Collections.reverse(this.dados);
    }

    public Dado obtenerDado(int indice){
        return this.dados.get(indice);
    }

    public ArrayList<Dado> obtenerDados(){
        return this.dados;
    }

    public int size(){
        return this.dados.size();
    }

    public Dado get(int index){
        return this.dados.get(index);
    }

    public int numeroDeDadosQueSonMayores(ConjuntoDados otroConjuntoDados){
        int numeroDeDadosMayor = 0;
        Dado miDado;
        Dado otroDado;
        int index = 0;
        while (index < this.size()){
            miDado = this.get(index);
            otroDado = otroConjuntoDados.get(index);
            if (miDado.esMayorQue(otroDado)){
               numeroDeDadosMayor = numeroDeDadosMayor + 1;
            }
            index = index + 1;
        }
        return numeroDeDadosMayor;
    }

    public int numeroDeDadosQueSonMayoresOIguales(ConjuntoDados otroConjuntoDados){
        int numeroDeDadosMayor = 0;
        Dado miDado;
        Dado otroDado;
        int index = 0;
        while (index < this.size()){
            miDado = this.get(index);
            otroDado = otroConjuntoDados.get(index);
            if (miDado.esMayorOIgualQue(otroDado)){
               numeroDeDadosMayor = numeroDeDadosMayor + 1;
            }
            index = index + 1;
        }
        return numeroDeDadosMayor;
    }
}
