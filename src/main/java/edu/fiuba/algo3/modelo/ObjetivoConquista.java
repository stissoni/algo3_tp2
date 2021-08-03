package edu.fiuba.algo3.modelo;

import java.util.Hashtable;

public class ObjetivoConquista {
    private Hashtable<Continente, Integer> continentes;
    private Jugador jugadorDelObjetivo;

    public ObjetivoConquista(){
        this.continentes = new Hashtable<Continente, Integer>();
    }

    public void setJugador(Jugador unJugador){
        this.jugadorDelObjetivo = unJugador;
    }

    public void agregarContinenteAConquistar(Continente unContinente, int numeroDePaises){
        this.continentes.put(unContinente, numeroDePaises);
    }

    public boolean logroElObjetivo(Mapa mapaDelJuego){
        int numeroObjetivos = this.continentes.keySet().size();
        int numeroObjetivosCompletados = 0;
        for (Continente unContinente: this.continentes.keySet()){
            int numeroPaisesAConquistarDelContinente = this.continentes.get(unContinente);
            if (unContinente.numeroPaisesDominadosPor(this.jugadorDelObjetivo) >= numeroPaisesAConquistarDelContinente){
                numeroObjetivosCompletados = numeroObjetivosCompletados + 1;
            }
        }
        return numeroObjetivos == numeroObjetivosCompletados;
    }

    public String descripcionDelObjetivo(){
        String descripcion = "Objetivo\n";
        for (Continente continente: this.continentes.keySet()){
            String objetivoParticular = "Conquistar "+ this.continentes.get(continente)+" paises de "+continente.obtenerNombre()+"\n";
            descripcion = descripcion + objetivoParticular;
        }
        return descripcion;
    }

    public String estadoDelObjetivo(Mapa mapa){
        String descripcion = "Estado de objetivo\n";
        for (Continente continente: this.continentes.keySet()){
            int numeroObjetivo = this.continentes.get(continente);
            int numeroActual = numeroObjetivo - continente.numeroPaisesDominadosPor(this.jugadorDelObjetivo);
            String objetivoParticular =(
                "Faltan "+numeroActual+" pais(es)"+" de "+continente.obtenerNombre()+"\n"
            );
            descripcion = descripcion + objetivoParticular;
        }
        return descripcion;
    }
}
