package edu.fiuba.algo3.modelo;

public class FaseInicial implements Fase {
    private Partida partida;
    private Ronda ronda;
    private int numeroRondasColocacionJugadas;

    public void asignarPartida(Partida partida){
        this.partida = partida;
    }

    public void iniciarFase() {
        this.numeroRondasColocacionJugadas = 0;
        this.ronda = new RondaColocacion();
        this.ronda.turnero(this.partida.getTurnero());
        this.ronda.fase(this);
        this.ronda.iniciarRonda();
    }

    public void terminarTurno(){
        this.ronda.terminarTurno();
    }

    public int tropasAColocarPorJugador(){
        if (numeroRondasColocacionJugadas == 0){
            return 9999;
        }
        else {
            return 5;
        }
    }

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable{
        this.ronda.ejecutar(unMovimiento);
    }

    public void siguienteRonda(){
        this.numeroRondasColocacionJugadas = this.numeroRondasColocacionJugadas + 1;
        if (this.terminoFase()){
            this.terminarFase();
        }
        this.ronda = new RondaColocacion();
        this.partida.reiniciarTurno();
        this.ronda.turnero(this.partida.getTurnero());
        this.ronda.fase(this);
        this.ronda.iniciarRonda();
    }

    public boolean terminoFase(){
        if (this.numeroRondasColocacionJugadas >= 2){
            return true;
        }
        else {
            return false;
        }
    }

    public void terminarFase(){
        Fase siguienteFase = new FaseJuego();
        siguienteFase.asignarPartida(this.partida);
        siguienteFase.iniciarFase();
        this.partida.asignarFase(siguienteFase);
    }

    public Ronda obtenerRonda(){
        return this.ronda;
    }

    public boolean esRondaDeColocacion(){
        return this.ronda.esRondaDeColocacion();
    }

    public int tropasDisponiblesParaColocar(){
        return this.ronda.tropasDisponiblesParaColocar();
    }

    public boolean esRondaDeReagrupamiento(){
        return this.ronda.esRondaDeReagrupamiento();
    }
}
