package edu.fiuba.algo3.modelo;

public class RondaAtaque implements Ronda {
    private Turnero turnero;
    private Fase fase;
    private int numeroJugadoresQueParticiparon;

    public void iniciarRonda(){
        this.turnero.reiniciar();
        this.numeroJugadoresQueParticiparon = 0;
    }
    
    public void fase(Fase fase){
        this.fase = fase;
    }

    public void turnero(Turnero turnero){
        this.turnero = turnero;
    }

    public void ejecutar(Movimiento unMovimiento) throws Throwable{
        unMovimiento.jugador(this.turnero.jugadorTurno());
        unMovimiento.ejecutar();
    }

    public void terminarTurno(){
        this.numeroJugadoresQueParticiparon = this.numeroJugadoresQueParticiparon + 1;
        if (this.terminoRonda()){
            this.fase.siguienteRonda();
        }
        else {
            this.turnero.siguienteTurno();
        }
    }

    public boolean terminoRonda(){
        return this.numeroJugadoresQueParticiparon == this.turnero.obtenerNumeroJugadores();
    }

    public boolean esRondaDeColocacion(){
        return false;
    }

    public boolean esRondaDeReagrupamiento(){
        return false;
    }

    public int tropasDisponiblesParaColocar(){
        return 0;
    }

    public String nombreDeLaRonda(){
        return "Ronda de ataque";
    }
}
