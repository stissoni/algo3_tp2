package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombrePais;
    private Ejercito ejercitoEnControl; 

    public Pais(String nombrePais, Ejercito ejercito){
        this.nombrePais = nombrePais;
        this.ejercitoEnControl = ejercito;
    }

    public void atacarA(Pais otroPais, int numeroDeTropas){
        // Lanzar excepcion si numero de tropas del ejercito - numero de tropas < 1.
        ejercitoEnControl.reducirTropas(numeroDeTropas);
        Ejercito ejercitoAtacante = new Ejercito(numeroDeTropas, ejercitoEnControl.obtenerJugador());

        Batalla batallaEntrePaises = new Batalla(this, otroPais);
        batallaEntrePaises.asignarEjercitoAtacante(ejercitoAtacante);
        // Faltaria completar la logica de los dados. Quien tira los dados y quien los ordena. Lo demas esta ok.
    }

    public Ejercito obtenerEjercito(){
        return this.ejercitoEnControl;
    }

    public void entregarControlAlEjercito(Ejercito nuevoEjercito){
        this.ejercitoEnControl = nuevoEjercito;
    }

    public int obtenerNumeroTotalDeTropas(){
        return this.ejercitoEnControl.obtenerNumeroTotalDeTropas();
    }

    public void vencer(Pais otroPais){
        this.ejercitoEnControl.vencer(otroPais.obtenerEjercito());
    }

    public Jugador obtenerJugadorEnControl(){
        return this.ejercitoEnControl.obtenerJugador();
    }

    public String obtenerNombrePais(){
        return this.nombrePais;
    }

    public void reagruparEjercito(Ejercito otroEjercito){
        this.ejercitoEnControl.reagruparEjercito(otroEjercito);
    }
}
