package edu.fiuba.algo3.modelo;

public interface Ronda {
    public void ejecutar(Movimiento unMovimiento) throws Throwable;

    public void terminarTurno();

    public boolean terminoRonda();

    public void fase(Fase unaFase);

    public void turnero(Turnero turnero);

    public void iniciarRonda();

    public boolean esRondaDeColocacion();

    public int tropasDisponiblesParaColocar();
    
    public boolean esRondaDeReagrupamiento();
}
