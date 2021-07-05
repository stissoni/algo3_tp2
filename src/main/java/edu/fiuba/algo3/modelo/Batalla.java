package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Batalla {
    private Pais paisAtacante;
    private Pais paisDefensor;

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

    public ArrayList<Integer> tirarDados(int numeroDeDados, Pais pais){
        ArrayList<Integer> dados = new ArrayList<Integer>();
        int i = 0;
        while(i < numeroDeDados){
            dados.add(pais.tirarDados());
            i = i + 1;
        }
        Collections.sort(dados);
        Collections.reverse(dados);
        return dados;
    }

    public void luchar(){
        // Resolver como decidir con el numero de tropas que un pais ataca a otro.
        int numeroDeDadosAtacante = obtenerNumeroDadosAtacante(this.paisAtacante.obtenerNumeroTotalDeTropas());
        int numeroDeDadosDefensor = this.paisDefensor.obtenerNumeroTotalDeTropas();
        int numeroDeDadosAComparar = obtenerNumeroDadosAComparar(numeroDeDadosAtacante, numeroDeDadosDefensor);

        ArrayList<Integer> dadosAtacante = tirarDados(numeroDeDadosAtacante, this.paisAtacante);
        ArrayList<Integer> dadosDefensor = tirarDados(numeroDeDadosDefensor, this.paisDefensor);
        
        int i = 0;
        while (i < numeroDeDadosAComparar){
            if (dadosAtacante.get(i) > dadosDefensor.get(i)){
                this.paisAtacante.vencer(this.paisDefensor);
            }
            else {
                this.paisDefensor.vencer(this.paisAtacante);
            }
            i = i + 1;
        }
        this.obtenerGanador();
    }
    
    public void obtenerGanador(){
        if (this.paisDefensor.obtenerNumeroTotalDeTropas() == 0){
            this.paisDefensor.entregarControlAlEjercitoDe(this.paisAtacante.obtenerEjercito());
        }
    }
}
