package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.NumeroDeTropasInsuficienteException;
import edu.fiuba.algo3.excepciones.EjercitosDeJugadoresDiferentesException;
import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;

public class Ejercito {
    private int numeroDeTropas;
    private Jugador jugador;

    public Ejercito(int nuevoNumeroDeTropas, Jugador jugador){
        this.numeroDeTropas = nuevoNumeroDeTropas;
        this.jugador = jugador;
    }

    public void reducirTropas (int numeroDeTropasARestar) throws NumeroDeTropasInsuficienteException {
        if ((this.numeroDeTropas - numeroDeTropasARestar) < 0){
            throw new NumeroDeTropasInsuficienteException();
        }
        this.numeroDeTropas = this.numeroDeTropas - numeroDeTropasARestar;
    }

    public void aumentarTropas(int numeroDeTropasASumar){
        this.numeroDeTropas = this.numeroDeTropas + numeroDeTropasASumar;
    }

    public int obtenerNumeroTotalDeTropas(){
        return this.numeroDeTropas;
    }

    public void vencer(Ejercito otroEjercito) throws EjercitoYaVencidoException{
        try{
            otroEjercito.reducirTropas(1);
        }
        catch (NumeroDeTropasInsuficienteException e){
            throw new EjercitoYaVencidoException();
        }
    }

    public Jugador obtenerJugador(){
        return this.jugador;
    }

    public void controlarPais(Pais elPaisAControlar){
        elPaisAControlar.entregarControlAlEjercito(this);
    }

    public void reagruparEjercito(Ejercito otroEjercito) throws EjercitosDeJugadoresDiferentesException{
        if (this.obtenerJugador().sonJugadoresDiferentes(otroEjercito.obtenerJugador())){
            throw new EjercitosDeJugadoresDiferentesException();
        }
        this.numeroDeTropas = this.numeroDeTropas + otroEjercito.obtenerNumeroTotalDeTropas();
        // Tambien se podria hacer return new Ejercito(this.obtenerNumeroTotalTropas()+otroEjercito.obtenerNumeroTotal...)
    }
}
