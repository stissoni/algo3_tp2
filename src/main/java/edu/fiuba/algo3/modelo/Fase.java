package edu.fiuba.algo3.modelo;

public interface Fase {
    public void asignarPartida(Partida partida);

    public void iniciarFase() throws Throwable;

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable;
}
