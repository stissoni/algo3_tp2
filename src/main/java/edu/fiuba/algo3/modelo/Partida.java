package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.*;

public class Partida {
    private Mapa mapaDelJuego;
    private Fase faseActual;
    private Turnero turno;

    public Partida(){
        this.turno = Turnero.getInstance();
    }

    public Turnero getTurnero(){
        return this.turno;
    }

    public void terminarTurno(){
        this.faseActual.terminarTurno();
    }

    public void agregarJugador(Jugador unJugador){
        this.turno.agregarJugador(unJugador);
    }

    public void jugadorInicial(int index){
        this.turno.jugadorInicial(index);
    }

    public void iniciarPartida() throws Throwable{
        for (Pais pais: this.mapaDelJuego.obtenerPaises()){
            Jugador jugador = this.turno.jugadorTurno();
            Ejercito ejercito = new Ejercito(1, jugador);
            pais.agregarEjercito(ejercito);
            this.turno.siguienteTurno();
        }
        this.repartirObjetivos();
        this.faseActual = new FaseInicial();
        this.faseActual.asignarPartida(this);
        this.faseActual.iniciarFase();
    }

    private void repartirObjetivos() throws IOException{
        Director director = new Director();
        ObjetivosBuilder builder = new ObjetivosBuilder();
        director.crearObjetivos(builder, this.mapaDelJuego);

        ArrayList<ObjetivoConquista> objetivos = builder.obtenerResultado();
        int numeroObjetivosDisponibles = objetivos.size();
        System.out.println(numeroObjetivosDisponibles);
        
        for (Jugador jugador: this.turno.obtenerJugadores()){
            GeneradorAleatorio generador = new GeneradorAleatorio();
            int index = generador.generar(0, numeroObjetivosDisponibles);
            jugador.asignarObjetivo(objetivos.get(index));
            objetivos.get(index).setJugador(jugador);

            objetivos.remove(index);
            numeroObjetivosDisponibles = numeroObjetivosDisponibles - 1;
        }
    }

    public void reiniciarTurno(){
        this.turno.reiniciar();
    }

    public void crearMapa() throws IOException{
        Director director = new Director();
        MapaBuilder builder = new MapaBuilder();
        director.crearMapa(builder);
        this.mapaDelJuego = builder.obtenerResultado();
    }

    public void asignarFase(Fase unaFase){
        this.faseActual = unaFase;
    }

    public void ejecutarMovimiento(Movimiento unMovimiento) throws Throwable{
        this.faseActual.ejecutarMovimiento(unMovimiento);
    }

    public int obtenerNumeroJugadores(){
        return this.turno.obtenerNumeroJugadores();
    }

    public Jugador obtenerJugadorActual(){
        return this.turno.jugadorTurno();
    }

    public void siguienteTurno(){
        this.turno.siguienteTurno();
    }

    public ArrayList<Pais> obtenerPaises(){
        return this.mapaDelJuego.obtenerPaises();
    }

    public ArrayList<Pais> obtenerPaisesDe(Jugador unJugador){
        return this.mapaDelJuego.obtenerPaisesDe(unJugador);
    }

    public ArrayList<Pais> obtenerPaisesNoDe(Jugador unJugador){
        return this.mapaDelJuego.obtenerPaisesNoDe(unJugador);
    }

    public Mapa obtenerMapa(){
        return this.mapaDelJuego;
    }

    public Pais obtenerUnPais(String nombre){
        return this.mapaDelJuego.obtenerUnPais(nombre);
    }
    
    public Ronda obtenerRonda(){
        return this.faseActual.obtenerRonda();
    }

    public boolean esRondaDeColocacion(){
        return this.faseActual.esRondaDeColocacion();
    }

    public ArrayList<Pais> obtenerPaisesLimitrofesDe(String nombrePais){
        return this.mapaDelJuego.obtenerPaisesLimitrofesDe(nombrePais);
    }

    public ArrayList<Pais> obtenerPaisesLimitrofesEnemigosDe(String nombrePais, Jugador unJugador){
        return this.mapaDelJuego.obtenerPaisesLimitrofesEnemigosDe(nombrePais, unJugador);
    }

    public ArrayList<Pais> obtenerPaisesLimitrofesDe(String nombrePais, Jugador unJugador){
        return this.mapaDelJuego.obtenerPaisesLimitrofesDe(nombrePais, unJugador);
    }

    public int tropasDisponiblesParaColocar(){
        return this.faseActual.tropasDisponiblesParaColocar();
    }

    public boolean esRondaDeReagrupamiento(){
        return this.faseActual.esRondaDeReagrupamiento();
    }

    public boolean alguienGanoLaPartida(){
        for(Jugador jugador: this.turno.obtenerJugadores()){
            if (jugador.cumplioSuObjetivo(this.mapaDelJuego)){
                return true;
            }
        }
        return false;
    }

    public Jugador obtenerGanador(){
        for(Jugador jugador: this.turno.obtenerJugadores()){
            if (jugador.cumplioSuObjetivo(this.mapaDelJuego)){
                return jugador;
            }
        }
        return null;
    }

    public boolean ganoLaPartida(Jugador unJugador){
        return (this.alguienGanoLaPartida() && unJugador.sonElMismoJugador(this.obtenerGanador()));
    }
}