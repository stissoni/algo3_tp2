package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

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
        this.paisDefensor = paisDefensor;
    }

    public void paisAtacaConNumeroDeTropas(int numeroDeTropas){
        Jugador jugador = this.paisAtacante.obtenerJugadorEnControl();
        // Lanzar excepcion si numero de tropas del ejercito atacante - numero de tropas < 1.
        Ejercito ejercitoAtacante = new Ejercito(numeroDeTropas, jugador);
        this.ejercitoAtacante = ejercitoAtacante;
    }

    public void asignarEjercitoAtacante(Ejercito unEjercito){
        this.ejercitoAtacante = unEjercito;
    }

    public void asignarEjercitoDefensor(Ejercito unEjercito){
        this.ejercitoDefensor = unEjercito;
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
        this.dadosDefensor = dados;
    }

    public void asignarNumeroDadosAComparar(int numeroDadosAtacante, int numeroDadosDefensor){
        int numeroDados;
        if (numeroDadosAtacante > numeroDadosDefensor){
            numeroDados = numeroDadosDefensor;
        }
        else {
            numeroDados = numeroDadosAtacante;
        }
        this.numeroDadosAComparar = numeroDados;
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

    public void definirGananadorDeLaBatalla() throws EjercitosDeJugadoresDiferentesException{
        if (this.paisDefensor.obtenerNumeroTotalDeTropas() == 0){
            this.paisDefensor.asignarEjercito(this.ejercitoAtacante);
        }
        else {
            this.paisAtacante.reagruparEjercito(this.ejercitoAtacante);
        }
    }
}
