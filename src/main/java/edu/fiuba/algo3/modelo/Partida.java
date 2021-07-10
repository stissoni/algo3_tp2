package edu.fiuba.algo3.modelo;

import java.util.*;


public class Partida {
    private final int cantidadDeJugadores;
    private final ArrayList<Jugador> listaDeJugadores;
    private ArrayList<Pais> mapa;
    // Debería haber una forma de agrupar en continentes, o nueva clase para chequear posible condición de victoria

    public Partida(ArrayList<Jugador> listaDeJugadores){
        this.listaDeJugadores = listaDeJugadores;
        cantidadDeJugadores = listaDeJugadores.size();
        //listaDeJugadores = crearJugadores();
        mapa = solicitarPaises(); // Falta dividir la funcionalidad en solicitar y ocupar
    }

//    private int solicitarCantidadDeJugadores(){ //TEMP
//        return 2; //Pospuesto - Propongo que se ofrezca mediante botones un numero entre 2-6 (Y que no se pida por input).
//    }

//    private ArrayList<Jugador> crearJugadores(){ //
//        ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
//        for (int i=0;i<cantidadDeJugadores;i++){
//            String nombreJugador = pedirNombreJugador(i);
//            Jugador jugador = new Jugador(nombreJugador,i);
//            listaDeJugadores.add(jugador);
//        }
//        return listaDeJugadores;
//    }

//    private String pedirNombreJugador(int numeroDeJugador){ //TEMP
//        Scanner scanNombre = new Scanner(System.in); //Al igual que solicitarCantidadDeJugadores propongo que sea con GUI.
//        System.out.print("Escribi el nombre del jugador " + numeroDeJugador + " :\n");
//        return scanNombre.next();
//    }

    public ArrayList<Pais> solicitarPaises(){ //TEMP for testing
        ArrayList<Pais> listaPaises = new ArrayList<>();
        String[] america = new String[]{
                "Argentina", "Brasil", "Uruguay", "Chile", "Peru", "Paraguay", "Bolivia",
                "Ecuador", "Colombia", "Venezuela",
        };
        Collections.shuffle(Arrays.asList(america)); //Para que sea aleatorio mezclo la lista de países
        int i = 0;
        for (String nombrePais : america){
            Jugador unJugador = listaDeJugadores.get(i%this.cantidadDeJugadores);
            Ejercito unEjercito = new Ejercito(1,unJugador);
            Pais nuevoPais = new Pais(nombrePais);
            listaPaises.add(nuevoPais);
            i++;
        }
        return listaPaises;
    }

    public int obtenerCantidadDeJugadores(){
        return cantidadDeJugadores;
    }
    public ArrayList<Jugador> obtenerListaDeJugadores(){
        return listaDeJugadores;
    }
    public ArrayList<Pais> obtenerlistaDePaises(){
        return mapa;
    }

//    public void colocarEjercitosIniciales(){
//        int i = 0;
//        for (Pais pais : mapa) {
//            Jugador unJugador = listaDeJugadores.get(i%this.cantidadDeJugadores);
//            pais.asignarOcupanteInicial(unJugador);
//            i++;
//            }
//    }


}
