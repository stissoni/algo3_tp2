package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;

import java.util.*;

public class Partida {
    private final int cantidadDeJugadores;
    private final ArrayList<Jugador> listaDeJugadores;
    private Mapa mapa;
    private Map<String, Pais> paises;
    // Debería haber una forma de agrupar en continentes, o nueva clase para chequear posible condición de victoria

    public Partida(ArrayList<Jugador> listaDeJugadores){
        this.listaDeJugadores = listaDeJugadores; //Limitar a 2-6 jugadores.
        cantidadDeJugadores = listaDeJugadores.size();
        //listaDeJugadores = crearJugadores();
        try {
            mapa = new Mapa("src/main/java/edu/fiuba/algo3/modelo/paises.csv");
            List<String> paisesMezclados = mapa.obtenerPaisesMezclados();
            inizializarPaises(paisesMezclados);
            repartirOcupacionDePaises(paisesMezclados);
        } catch (LeerArchivoError leerArchivoError) {
            leerArchivoError.printStackTrace();
        }
    }

    private void inizializarPaises(List<String> listaPaises) {
        paises = new HashMap<String,Pais>();
        for (String nombrePais: listaPaises) {
            paises.put(nombrePais, new Pais(nombrePais));
        }
    }

    private void repartirOcupacionDePaises(List<String> listaPaisesMezcalda) {
        int contador = 0;
        for (String nombrePais: listaPaisesMezcalda) {
            Jugador unJugador = listaDeJugadores.get(contador%cantidadDeJugadores);
            paises.get(nombrePais).asignarEjercito(new Ejercito(1,unJugador));
            contador++;
        }
    }

    public int obtenerCantidadDeJugadores(){
        return cantidadDeJugadores;
    }
    public ArrayList<Jugador> obtenerListaDeJugadores(){
        return listaDeJugadores;
    }
    public List<String> obtenerlistaDePaises(){
        return Arrays.asList(paises.keySet().toArray(new String[0]));
    }

    public Pais obtenerPais(String nombrePais) {
        return paises.get(nombrePais);
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


    // Me basé en el mapa de TEG tradicional:
    // https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large
    /*
    public Map<String,String[]> solicitarPaises(){
        String[] americaDelSur = new String[]{
                "Argentina", "Brasil", "Uruguay", "Chile", "Peru", "Colombia"
        };
        String[] americaDelNorte = new String[]{
                "México", "California", "Nueva York", "Oregón", "Alaska", "Yukón", "Canadá",
                "Terranova", "Labrador", "Groenlandia"
        };
        String[] europa = new String[]{
                "España", "Francia", "Alemania", "Gran Bretaña", "Islandia", "Italia",
                "Polonia", "Rusia", "Suecia"
        };
        String[] asia = new String[]{
                "Aral", "Tartaria", "Taymír", "Kamchatka", "Japón", "Siberia", "Mongolia",
                "Irán", "Gobí", "China", "Malasia", "India", "Arabia", "Israel", "Turquía",
        };
        String[] oceania = new String[]{
                "Australia","Borneo","Java", "Sumatra",
        };
        String[] africa = new String[]{
                "Sahara", "Zaire", "Etiopía", "Egipto", "Sudáfrica", "Madagascar"
        };

        Map<String,String[]> continentes = new HashMap<>();
        continentes.put("America del Sur", americaDelSur);
        continentes.put("America del Norte", americaDelNorte);
        continentes.put("Europa", europa);
        continentes.put("Asia", asia);
        continentes.put("Oceania", oceania);
        continentes.put("Africa",africa);
        return continentes;
    }
    */

}
