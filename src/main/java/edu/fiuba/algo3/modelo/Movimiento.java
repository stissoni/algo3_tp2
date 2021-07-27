package edu.fiuba.algo3.modelo;

public interface Movimiento {
    public void ejecutar() throws Throwable;

    public void jugador(Jugador unJugador);

    public int tropasUtilizadas();
}
