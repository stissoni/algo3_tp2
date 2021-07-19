package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class IntentoDeConquista {
    private Pais paisConquistador;
    private Pais paisDefensor;

    public IntentoDeConquista(Pais paisConquistador, Pais paisDefensor){
        this.paisConquistador = paisConquistador;
        this.paisDefensor = paisDefensor;
    }

    public void intentarConquista(int numeroTropasAtacante) throws Throwable{
        Ejercito ejercitoAtacante = this.paisConquistador.ejercitoParaAtacar(numeroTropasAtacante);
        Ejercito ejercitoDefensor = this.paisConquistador.obtenerEjercito();

        Batalla batalla = new Batalla();
        batalla.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);

        ArrayList<Dado> dadosAtacante = Dado.tirar(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        ArrayList<Dado> dadosDefensor = Dado.tirar(ejercitoDefensor.obtenerNumeroTotalDeTropas());

        batalla.luchar(dadosAtacante, dadosDefensor);

        if (paisDefensor.suEjercitoFueVencido()){
            paisDefensor.asignarEjercito(batalla.obtenerEjercitoAtacante());
        }
        else {
            paisConquistador.reagruparEjercito(batalla.obtenerEjercitoAtacante());
        }
    }
}
