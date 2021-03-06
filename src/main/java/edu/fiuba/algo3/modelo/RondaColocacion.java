package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.NoSePermiteColocarEseNumeroDeTropasException;

public class RondaColocacion implements Ronda{
    private Turnero turnero;
    private Fase fase;
    private int numeroTropasRestantes;
    private int numeroJugadoresQueParticiparon;

    public void iniciarRonda(){
        this.turnero.reiniciar();
        this.numeroTropasRestantes = this.fase.tropasAColocarPorJugador();
        this.numeroJugadoresQueParticiparon = 0;
    }

    public void fase(Fase fase){
        this.fase = fase;
    }

    public void turnero(Turnero turnero){
        this.turnero = turnero;
    }

    public void ejecutar(Movimiento unMovimiento) throws Throwable, NoSePermiteColocarEseNumeroDeTropasException{
        if (this.numeroTropasRestantes - unMovimiento.tropasUtilizadas() < 0){
            throw new NoSePermiteColocarEseNumeroDeTropasException("No se pueden colocar "+unMovimiento.tropasUtilizadas()+" tropas. Maximo "+this.numeroTropasRestantes+" tropas.");
        }
        unMovimiento.jugador(this.turnero.jugadorTurno());
        unMovimiento.ejecutar();
        this.numeroTropasRestantes = this.numeroTropasRestantes - unMovimiento.tropasUtilizadas();
        
        this.verificarTurnoRonda();
    }
    
    public void verificarTurnoRonda(){
        if (numeroTropasRestantes <= 0){
            this.terminarTurno();
        }
    }

    public void terminarTurno(){
        this.numeroJugadoresQueParticiparon = this.numeroJugadoresQueParticiparon + 1;
        if (this.terminoRonda()){
            this.fase.siguienteRonda();
        }
        else {
            this.turnero.siguienteTurno();
            this.numeroTropasRestantes = this.fase.tropasAColocarPorJugador();
        }
    }
    
    public boolean terminoRonda(){
        return this.numeroJugadoresQueParticiparon == this.turnero.obtenerNumeroJugadores();
    }

    public boolean esRondaDeColocacion(){
        return true;
    }

    public boolean esRondaDeReagrupamiento(){
        return false;
    }

    public int tropasDisponiblesParaColocar(){
        return this.numeroTropasRestantes;
    }

    public String nombreDeLaRonda(){
        return "Ronda de colocacion";
    }
}
