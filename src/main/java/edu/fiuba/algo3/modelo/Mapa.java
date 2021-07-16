package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;
import edu.fiuba.algo3.excepciones.PaisNoExisteError;

import java.util.*;

public class Mapa {
    HashMap<String,Pais> paises;

    public Mapa(String ruta) throws LeerArchivoError {
        paises = CargadorDePaises.cargarPaisesConRuta(ruta);
    }

    public void inicializarCon(Jugador[] jugadores) {
        ArrayList<String> nombresPaises = new ArrayList<>(paises.keySet());
        Collections.shuffle(nombresPaises);
        int numPais = 0;
        for (String nombrePais: nombresPaises) {
            int numJugador = numPais % jugadores.length;
            numPais++;
            paises.get(nombrePais).asignarEjercito(new Ejercito(1, jugadores[numJugador]));
        }
    }

    public int size() {
        return paises.size();
    }

    public Pais obtenerPais(String nombrePais) throws PaisNoExisteError {
        if (!paises.containsKey(nombrePais)) throw new PaisNoExisteError(nombrePais);
        return paises.get(nombrePais);
    }

}
