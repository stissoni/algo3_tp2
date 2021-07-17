package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class IntentoDeConquista {
    private Pais paisConquistador;
    private Pais paisDefensor;
    private Batalla batalla;

    public IntentoDeConquista(Pais paisConquistador, Pais paisDefensor){
        this.paisConquistador = paisConquistador;
        this.paisDefensor = paisDefensor;
    }

    public void asignarBatalla(Batalla unaBatalla){
        this.batalla = unaBatalla;
    }

    public void resultadoDeConquista() throws EjercitosDeJugadoresDiferentesException{
        if (paisDefensor.suEjercitoFueVencido()){
            paisDefensor.asignarEjercito(this.batalla.obtenerEjercitoAtacante());
        }
        else {
            paisConquistador.reagruparEjercito(this.batalla.obtenerEjercitoAtacante());
        }
    }
}
