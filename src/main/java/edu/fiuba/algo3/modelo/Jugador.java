package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombreJugador;
    private int idJugador;
    private ObjetivoConquista objetivo;

    public Jugador(String nombre, int id){
        this.nombreJugador = nombre;
        this.idJugador = id;
    }

    public void asignarObjetivo(ObjetivoConquista objetivo){
        this.objetivo = objetivo;
    }

    public boolean cumplioSuObjetivo(Mapa mapaDelJuego){
        return this.objetivo.logroElObjetivo(mapaDelJuego);
    }

    public int obtenerId(){
        return this.idJugador;
    }

    public String obtenerNombre(){
        return this.nombreJugador;
    }

    public boolean sonJugadoresDiferentes(Jugador otroJugador){
        return !this.sonElMismoJugador(otroJugador);
    }

    public boolean sonElMismoJugador(Jugador otroJugador){
        return (this.obtenerId() == otroJugador.obtenerId());
    }

    public ObjetivoConquista obtenerObjetivo(){
        return this.objetivo;
    }
}
