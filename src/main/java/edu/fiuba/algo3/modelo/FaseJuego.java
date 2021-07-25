package edu.fiuba.algo3.modelo;

public class FaseJuego implements Fase {
    private Partida partida;

    public void asignarPartida(Partida partida){
        this.partida = partida;
    }

    public void iniciarFase() throws Throwable{
        this.partida.reiniciarTurno();
    }

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable{
        unMovimiento.ejecutar();
    }
}
