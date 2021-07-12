package edu.fiuba.algo3.modelo;

public class Ejercito {
    private int numeroDeTropas;
    private Jugador jugador;

    public Ejercito(int nuevoNumeroDeTropas, Jugador jugador){
        this.numeroDeTropas = nuevoNumeroDeTropas;
        this.jugador = jugador;
    }

    public void reducirTropas(int numeroDeTropasARestar){
        // Lanzar excepcion si la resta es menor a 0. 
        this.numeroDeTropas = this.numeroDeTropas - numeroDeTropasARestar;
    }

    public void aumentarTropas(int numeroDeTropasASumar){
        this.numeroDeTropas = this.numeroDeTropas + numeroDeTropasASumar;
    }

    public int obtenerNumeroTotalDeTropas(){
        return this.numeroDeTropas;
    }

    public void vencer(Ejercito otroEjercito){
        otroEjercito.reducirTropas(1);
    }

    public Jugador obtenerJugador(){
        return this.jugador;
    }

    public void controlarPais(Pais elPaisAControlar){
        elPaisAControlar.entregarControlAlEjercito(this);
    }

    public void reagruparEjercito(Ejercito otroEjercito){
        // Lanzar excepcion si el nuevo ejercito es de otro jugador.
        this.numeroDeTropas = this.numeroDeTropas + otroEjercito.obtenerNumeroTotalDeTropas();
    }
}
