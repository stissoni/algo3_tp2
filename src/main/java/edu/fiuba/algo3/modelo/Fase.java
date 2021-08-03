package edu.fiuba.algo3.modelo;

public interface Fase {
    public void asignarPartida(Partida partida);

    public void iniciarFase();

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable;

    public void siguienteRonda();

    public int tropasAColocarPorJugador();

    public Ronda obtenerRonda();

    public void terminarTurno();

    public boolean esRondaDeColocacion();

    public int tropasDisponiblesParaColocar();
}
