package edu.fiuba.algo3.modelo;

public class MovimientoReagrupacion implements Movimiento {
    private Jugador unJugador;
    private int cantidadTropas;
    private Pais origen;
    private Pais destino;

    public int tropasUtilizadas(){
        return this.cantidadTropas;
    }

    public void jugador(Jugador unJugador){
        this.unJugador = unJugador;
    }

    public void cantidadDeTropas(int numeroTropas){
        this.cantidadTropas = numeroTropas;
    }
    
    public void paisOrigen(Pais paisOrigen){
        this.origen = paisOrigen;
    }
    
    public void paisDestino(Pais paisDestino){
        this.destino = paisDestino;
    }

    public void ejecutar() throws Throwable{
        this.origen.reducirTropas(this.cantidadTropas);
        Ejercito ejercito = new Ejercito(cantidadTropas, this.origen.obtenerJugadorEnControl());
        this.destino.reagruparEjercito(ejercito);
    }
}
