package edu.fiuba.algo3.modelo;

public class FaseInicial implements Fase {
    private Partida partida;
    private RondaColocacion ronda;
    private int numeroRondasColocacionJugadas;

    public void asignarPartida(Partida partida){
        this.partida = partida;
    }

    public void iniciarFase() throws Throwable {
        for (Pais pais: this.partida.obtenerPaises()){
            Jugador jugador = this.partida.obtenerJugadorActual();
            Ejercito ejercito = new Ejercito(1, jugador);
            pais.agregarEjercito(ejercito);
            this.partida.siguienteTurno();
        }
        this.ronda = new RondaColocacion();
        this.ronda.turnero(this.partida.obtenerTurnero());
        int tropasParaColocarPorJugador = 3;
        this.ronda.numeroDeTropas(tropasParaColocarPorJugador);
        this.ronda.fase(this);
        this.numeroRondasColocacionJugadas = 0;
    }

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable{
        this.ronda.ejecutar(unMovimiento);
        if (this.terminoFase()){
            this.terminarFase();
        }
    };

    public void siguienteRonda(){
        this.ronda = new RondaColocacion();
        this.ronda.turnero(this.partida.obtenerTurnero());
        int tropasParaColocarPorJugador = 5;
        this.ronda.numeroDeTropas(tropasParaColocarPorJugador);
        this.ronda.fase(this);
        this.numeroRondasColocacionJugadas = this.numeroRondasColocacionJugadas + 1;
    }

    public boolean terminoFase(){
        if (this.numeroRondasColocacionJugadas >= 2){
            return true;
        }
        else {
            return false;
        }
    }

    public void terminarFase() throws Throwable{
        Fase siguienteFase = new FaseJuego();
        siguienteFase.asignarPartida(this.partida);
        siguienteFase.iniciarFase();
        this.partida.asignarFase(siguienteFase);
    }
}
