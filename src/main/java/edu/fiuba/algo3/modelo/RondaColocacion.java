package edu.fiuba.algo3.modelo;

public class RondaColocacion {
    private Turno turnero;
    private FaseInicial fase;
    private int numeroTropasIniciales;
    private int numeroTropasRestantes;
    private int numeroJugadoresQueParticiparon;

    public void numeroDeTropas(int numeroTropas){
        this.numeroTropasRestantes = numeroTropas;
        this.numeroTropasIniciales = numeroTropas;
        this.numeroJugadoresQueParticiparon = 0;
    }

    public void fase(FaseInicial fase){
        this.fase = fase;
    }

    public void turnero(Turno turnero){
        this.turnero = turnero;
        this.turnero.reiniciar();
    }

    public void ejecutar(Movimiento unMovimiento) throws Throwable{
        this.numeroTropasRestantes = this.numeroTropasRestantes - unMovimiento.tropasUtilizadas();
        unMovimiento.jugador(this.turnero.jugadorTurno());
        unMovimiento.ejecutar();
        this.verificarTurnoRonda();
        if (this.terminoRonda()){
            this.fase.siguienteRonda();
        }
    }

    public void verificarTurnoRonda(){
        if (numeroTropasRestantes <= 0){
            this.turnero.siguienteTurno();
            this.numeroTropasRestantes = this.numeroTropasIniciales;
            this.numeroJugadoresQueParticiparon = this.numeroJugadoresQueParticiparon + 1;
        }
    }

    public boolean terminoRonda(){
        return this.numeroJugadoresQueParticiparon == this.turnero.obtenerNumeroJugadores();
    }
}
