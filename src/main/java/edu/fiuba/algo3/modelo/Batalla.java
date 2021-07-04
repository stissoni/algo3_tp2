package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Batalla {
    private Ejercito ejercitoAtacante;
    private Ejercito ejercitoDefensor;

    public Batalla(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
        this.ejercitoAtacante = ejercitoAtacante;
        this.ejercitoDefensor = ejercitoDefensor;
    }

    public int obtenerNumeroDadosAtacante(int numeroTropasAtacan){
        int numeroDeDadosAtacante =  numeroTropasAtacan;
        if (numeroDeDadosAtacante > 3){
            numeroDeDadosAtacante = 3;
        }
        return numeroDeDadosAtacante;
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

    public void luchar(int numeroTropasAtacan){
        int numeroDeDadosAtacante =  obtenerNumeroDadosAtacante(numeroTropasAtacan);
        int numeroDeDadosDefensor = this.ejercitoDefensor.obtenerNumeroTotalDeTropas();
        int numeroDeDadosAComparar = obtenerNumeroDadosAComparar(numeroDeDadosAtacante, numeroDeDadosDefensor);

        ArrayList<Integer> dadosAtacante = new ArrayList<Integer>();
        ArrayList<Integer> dadosDefensor = new ArrayList<Integer>();
        
        int i = 0;
        while(i <= numeroDeDadosAtacante){
            dadosAtacante.add(this.ejercitoAtacante.tirarDados());
            i = i + 1;
        }
        i = 0;
        while(i <= numeroDeDadosDefensor){
            dadosDefensor.add(this.ejercitoDefensor.tirarDados());
            i = i + 1;
        }
    }

}
