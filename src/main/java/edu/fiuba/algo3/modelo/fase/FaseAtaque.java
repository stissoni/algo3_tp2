package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.modelo.Batalla;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Ejercito;
import edu.fiuba.algo3.modelo.Pais;


import java.util.ArrayList;

public class FaseAtaque {
    Ejercito ejercitoAtacante;
    Ejercito ejercitoDefensor;
    int tropasAtacantes;

    public FaseAtaque(Pais atacante, Pais defensor, int tropasAtacantes) {
        this.ejercitoAtacante = atacante.obtenerEjercito();
        this.ejercitoDefensor = defensor.obtenerEjercito();
        this.tropasAtacantes = tropasAtacantes;
    }

    public void atacar(ArrayList<Dado> dadosAtaque,ArrayList<Dado> dadosDefensa) throws EjercitoYaVencidoException {
        Batalla unaBatalla = new Batalla();
        unaBatalla.asignarEjercitos(ejercitoAtacante,ejercitoDefensor);
        unaBatalla.luchar(dadosAtaque,dadosDefensa);

    }
}
