package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;

public class Partida {
    private final Jugadores listaDeJugadores;
    private final Mapa mapa;
    private Turno turno;

    public Partida(Jugadores listaDeJugadores) {
        this.listaDeJugadores = listaDeJugadores; //Limitar a 2-6 jugadores.
        listaDeJugadores.mezclarJugadores();
        mapa = new Mapa("src/main/java/edu/fiuba/algo3/modelo/paises.csv");
        mapa.repartirOcupacionDePaises(listaDeJugadores);
        turno = new Turno(listaDeJugadores);
    }

    /**Método solo usado para prueba*/
    public boolean partidaSeCreaConNJugadores(int n){
        return listaDeJugadores.cantidadDeJugadores() == n;
    }

    /**Método solo usado para prueba*/
    public boolean mapaFueOcupadoCorrectamente(){
        return mapa.mapaFueOcupadoCorrectamente(listaDeJugadores);
    }

    /**Método solo usado para prueba*/
    public boolean tienenTropasDisponibles(){
        return listaDeJugadores.tienenTropasDisponibles();
    }

    /**Método solo usado para prueba*/
    public void jugarUnaRondaDe2JugadoresSoloConPosicionamientos(Jugador jugador1, Jugador jugador2) {
        Pais unPais = mapa.buscarPais("Argentina");
        Pais otroPais = mapa.buscarPais("Brasil");

        unPais.ganarControlPor(new Ejercito(5,jugador1));
        otroPais.ganarControlPor(new Ejercito(5,jugador2));

        int tropasADistribuirJ1 = jugador1.getTropasDisponibles();
        int tropasADistribuirJ2 = jugador2.getTropasDisponibles();

        turno.cambiarJugadorActivo(jugador1);
        turno.distribuirTropas(tropasADistribuirJ1,unPais);

        turno.cambiarJugadorActivo(jugador2);
        turno.distribuirTropas(tropasADistribuirJ2,otroPais);
    }

    /**Método solo usado para prueba*/
    public void jugarUnaRondaDe3JugadoresSoloConPosicionamientos(Jugador jugador1, Jugador jugador2, Jugador jugador3) {
        Continente asia = mapa.buscarContinente("Asia");

        Pais unPais = mapa.buscarPais("Argentina");
        Pais otroPais = mapa.buscarPais("Brasil");
        Pais unPaisDeAsia = mapa.buscarPais("Siberia");

        unPais.ganarControlPor(new Ejercito(5,jugador1));
        asia.controlarPor(jugador2);
        otroPais.ganarControlPor(new Ejercito(5,jugador3));

        int tropasADistribuirJ1 = jugador1.getTropasDisponibles();
        int tropasADistribuirJ2 = jugador2.getTropasDisponibles();
        int tropasADistribuirJ3 = jugador3.getTropasDisponibles();

        turno.cambiarJugadorActivo(jugador1);
        turno.distribuirTropas(tropasADistribuirJ1,unPais);

        turno.cambiarJugadorActivo(jugador2);
        turno.distribuirTropas(tropasADistribuirJ2,unPaisDeAsia);

        turno.cambiarJugadorActivo(jugador3);
        turno.distribuirTropas(tropasADistribuirJ3,otroPais);
    }
}
