package edu.fiuba.algo3.modelo;

public class MovimientoColocacion implements Movimiento{
    private Jugador jugador;
    private int numeroTropas;
    private Pais destinoPais;

    public int tropasUtilizadas(){
        return this.numeroTropas;
    }

    public void ejecutar() throws Throwable{
        Ejercito ejercitoAColocar = new Ejercito(this.numeroTropas, this.jugador);
        destinoPais.agregarEjercito(ejercitoAColocar);
    }

    public void jugador(Jugador unJugador){
        this.jugador = unJugador;
    }

    public void numeroTropas(int numeroTropas){
        this.numeroTropas = numeroTropas;
    }

    public void destinoPais(Pais pais){
        this.destinoPais = pais;
    }
}