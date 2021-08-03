package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombreJugador;
    private int idJugador;
    private ObjetivoConquista objetivo;
    private ArrayList<CartaPais> cartasPais;

    public Jugador(String nombre, int id){
        this.nombreJugador = nombre;
        this.idJugador = id;
        this.cartasPais = new ArrayList<CartaPais>();
    }

    public void entregarCarta(CartaPais unaCarta){
        this.cartasPais.add(unaCarta);
    }

    public ArrayList<CartaPais> obtenerCartas(){
        return this.cartasPais;
    }

    public CartaPais devolverCarta(String nombreCarta){
        int index = 0;
        while (index < cartasPais.size()){
            CartaPais carta = cartasPais.get(index);
            if (carta.obtenerNombrePais().equals(nombreCarta)){
                return carta;
            }
        }
        return null;
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
