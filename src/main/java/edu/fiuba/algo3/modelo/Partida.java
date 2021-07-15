package edu.fiuba.algo3.modelo;

public class Partida {
    private final Jugadores listaDeJugadores;
    private final Mapa mapa;

    public Partida(Jugadores listaDeJugadores) {
        this.listaDeJugadores = listaDeJugadores; //Limitar a 2-6 jugadores.
        listaDeJugadores.mezclarJugadores();
        mapa = new Mapa("src/main/java/edu/fiuba/algo3/modelo/paises.csv");
        mapa.repartirOcupacionDePaises(listaDeJugadores);
    }

    /**Método solo usado para prueba*/
    public boolean partidaSeCreaConNJugadores(int n){
        return listaDeJugadores.cantidadDeJugadores() == n;
    }

    /**Método solo usado para prueba*/
    public boolean mapaFueOcupadoCorrectamente(){
        return mapa.mapaFueOcupadoCorrectamente(listaDeJugadores);
    }
}
