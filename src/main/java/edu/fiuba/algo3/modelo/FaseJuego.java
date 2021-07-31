package edu.fiuba.algo3.modelo;

public class FaseJuego implements Fase {
    private Partida partida;
    private Ronda ronda;

    public void asignarPartida(Partida partida){
        this.partida = partida;
    }

    public void iniciarFase(){
        this.partida.reiniciarTurno();
        this.ronda = new RondaAtaqueYAgrupamiento();
        this.ronda.fase(this);
        this.ronda.turnero(this.partida.getTurnero());
        this.ronda.iniciarRonda();
    }

    public void terminarTurno(){
        this.ronda.terminarTurno();
    }

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable{
        this.ronda.ejecutar(unMovimiento);
        // Aca verificar si alguien gano la partida...
    }

    public void siguienteRonda(){
        if (ronda.getClass().equals(RondaAtaqueYAgrupamiento.class)){
            this.ronda = new RondaColocacion();
        }
        else {
            this.ronda = new RondaAtaqueYAgrupamiento();
        }
        this.ronda.fase(this);
        this.ronda.turnero(this.partida.getTurnero());
        this.ronda.iniciarRonda();
    }

    public int tropasAColocarPorJugador(){
        Jugador jugadorActual = this.partida.obtenerJugadorActual();
        Mapa mapa = this.partida.obtenerMapa();
        return mapa.numeroPaisesControladosPor(jugadorActual) / 2;
    }

    public Ronda obtenerRonda(){
        return this.ronda;
    }

    public boolean esRondaDeColocacion(){
        return this.ronda.esRondaDeColocacion();
    }
}
