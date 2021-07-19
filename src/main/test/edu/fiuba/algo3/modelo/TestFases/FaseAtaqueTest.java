package edu.fiuba.algo3.modelo.TestFases;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.fase.FaseAtaque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FaseAtaqueTest {
    Turno unTurno;
    FaseAtaque unaFase;
    Jugadores listaDePersonas;
    Jugador jugador1;
    Pais paisAtacante;
    Jugador jugador2;
    Pais paisDefensor;
    int tropasAtacantes;
    private Object EjercitoYaVencidoException;

    @BeforeEach
    public void SetUp(){
        listaDePersonas = new Jugadores();
        jugador1 = new Jugador("Matias");
        jugador2 = new Jugador("Julio");
        listaDePersonas.agregarJugador(jugador1);
        listaDePersonas.agregarJugador(jugador2);

        paisAtacante = new Pais("Argentina");
        paisDefensor = new Pais("Brasil");

        paisAtacante.ocuparPor(jugador1);
        paisDefensor.ocuparPor(jugador2);

        unTurno = new Turno(listaDePersonas);
    }

    //Hay que cambiar clase dado o agregar clase adicional para una tirada de dados.
    //Falta ordenamiento de dados (mayor se compara con mayor, etc).
    //batalla.lucha() determina la cantidad de dados a comparar, por lo tanto nunca tira exception ejercito ya vencido.
    //Propongo que lucha devuelva el ejercito ganador, (Y de ser el ejercito atacante ocupar el pais).
    @Test
    public void ganaPaisAtacante() throws EjercitoYaVencidoException {
        ArrayList<Dado> dadosAtaque = new ArrayList<>();
        Dado unDado = new Dado(6);
        Dado unDado2 = new Dado(6);
        Dado unDado3 = new Dado(6);

        dadosAtaque.add(unDado);
        dadosAtaque.add(unDado2);
        dadosAtaque.add(unDado3);


        ArrayList<Dado> dadosDefensa = new ArrayList<>();
        Dado unDadoDefensa = new Dado(1);
        dadosDefensa.add(unDadoDefensa);

        unTurno.atacarConNTropasA(paisAtacante,tropasAtacantes,paisDefensor,dadosAtaque,dadosDefensa);
        assertTrue(paisDefensor.suEjercitoFueVencido());
    }
}