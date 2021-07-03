package edu.fiuba.algo3.modelo;

public class Batalla {
    
    public Batalla(Ejercito ejecitoAtacante, int numeroTropasAtacan, Ejercito ejercitoDefensor){
        int numeroDeDadosAtacante;
        if (numeroTropasAtacan > 3){
            numeroDeDadosAtacante = 3;
        }
        else {
            numeroDeDadosAtacante = numeroTropasAtacan;
        }
        int numeroDeDadosDefensor = ejercitoDefensor.obtenerNumeroTotalDeTropas();

        // Aqui tirar los dados para la batalla. Generar una lista con los resultados.
        // Ver el que ejercito con menos dados, ese sera el largo de la lista.
        // Tomar los mas altos de todos los dados tirados y ponerlos en sus respectivas listas.
        // Comparar uno a uno, e ir restando ejercitos. O hacer toda la cuenta y ver el resultado.
    }
}
