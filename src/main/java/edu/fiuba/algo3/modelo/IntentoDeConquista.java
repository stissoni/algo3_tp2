package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;

public class IntentoDeConquista {
    private Pais paisConquistador;
    private Pais paisDefensor;
    private Batalla laBatalla;

    public IntentoDeConquista(Pais paisConquistador, Pais paisDefensor, Batalla unaBatalla){
        this.paisConquistador = paisConquistador;
        this.paisDefensor = paisDefensor;
        this.laBatalla = unaBatalla;
    }

    public void iniciarConquista() throws EjercitoYaVencidoException{
        laBatalla.luchar();
    }

    public void resultadoDeConquista() throws EjercitosDeJugadoresDiferentesException{
        if (paisDefensor.suEjercitoFueVencido()){
            paisDefensor.asignarEjercito(this.laBatalla.obtenerEjercitoAtacante());
        }
        else {
            paisConquistador.reagruparEjercito(this.laBatalla.obtenerEjercitoAtacante());
        }
    }
}
