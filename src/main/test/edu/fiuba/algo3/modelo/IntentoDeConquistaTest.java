package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntentoDeConquistaTest {
    private Jugador jugadorAtacante;
    private Jugador jugadorDefensor;

    @BeforeEach
    public void setUp() {
        this.jugadorAtacante = new Jugador("Santiago");
        this.jugadorDefensor = new Jugador("Ramiro");
    }
    @Test
    public void testIntentarConquistaDePaisConVictoriaAtacante() throws Throwable{
        Pais paisAtacante = new Pais("Argentina");
        Pais paisDefensor = new Pais("Brasil");

        Ejercito ejercitoAtacante = new Ejercito(3, jugadorAtacante);
        Ejercito ejercitoDefensor = new Ejercito(3, jugadorDefensor);
        Ejercito ejercitoQueSeQuedaEnElPais = new Ejercito(1, jugadorAtacante);

        paisAtacante.asignarEjercito(ejercitoQueSeQuedaEnElPais);
        paisDefensor.asignarEjercito(ejercitoDefensor);
        
        ArrayList<Dado> dadosAtacante = new ArrayList<>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<>();
        Dado dadoDefensor = new Dado(4); // Pierde contra el 6.
        Dado otroDadoDefensor = new Dado(3); // Pierde contra el 5.
        Dado otroDadoDefensorMas = new Dado(3); // Pierde contra el 3.
        dadosDefensor.add(dadoDefensor);
        dadosDefensor.add(otroDadoDefensor);
        dadosDefensor.add(otroDadoDefensorMas);

        Batalla unaBatalla = new Batalla();
        unaBatalla.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);

        IntentoDeConquista intentarConquista = new IntentoDeConquista(
            paisAtacante,
            paisDefensor
        );
        intentarConquista.asignarBatalla(unaBatalla);
        unaBatalla.luchar(dadosAtacante, dadosDefensor);
        intentarConquista.resultadoDeConquista();

        assertSame(ejercitoAtacante, paisDefensor.obtenerEjercito()); // Cambia el control del pais.
        assertSame(jugadorAtacante, paisDefensor.obtenerJugadorEnControl());
        assertEquals(3, paisDefensor.obtenerNumeroTotalDeTropas());
        assertEquals(1, paisAtacante.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testIntentarConquistaDePaisConVictoriaDefensor() throws Throwable{
        Pais paisAtacante = new Pais("Argentina");
        Pais paisDefensor = new Pais("Brasil");

        Ejercito ejercitoAtacante = new Ejercito(3, jugadorAtacante);
        Ejercito ejercitoDefensor = new Ejercito(3, jugadorDefensor);
        Ejercito ejercitoQueSeQuedaEnElPais = new Ejercito(1, jugadorAtacante);

        paisAtacante.asignarEjercito(ejercitoQueSeQuedaEnElPais);
        paisDefensor.asignarEjercito(ejercitoDefensor);
        
        ArrayList<Dado> dadosAtacante = new ArrayList<>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<>();
        Dado dadoDefensor = new Dado(6); // Empata contra el 6.
        Dado otroDadoDefensor = new Dado(3); // Pierde contra el 5.
        Dado otroDadoDefensorMas = new Dado(3); // Pierde contra el 3.
        dadosDefensor.add(dadoDefensor);
        dadosDefensor.add(otroDadoDefensor);
        dadosDefensor.add(otroDadoDefensorMas);

        Batalla unaBatalla = new Batalla();
        unaBatalla.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);

        IntentoDeConquista intentarConquista = new IntentoDeConquista(
            paisAtacante,
            paisDefensor
        );
        intentarConquista.asignarBatalla(unaBatalla);

        unaBatalla.luchar(dadosAtacante, dadosDefensor);
        intentarConquista.resultadoDeConquista();

        assertSame(ejercitoDefensor, paisDefensor.obtenerEjercito()); // Mantiene el pais.
        assertSame(jugadorDefensor, paisDefensor.obtenerJugadorEnControl());
        assertEquals(1, paisDefensor.obtenerNumeroTotalDeTropas());
        assertEquals(3, paisAtacante.obtenerNumeroTotalDeTropas()); // Vuelven 2 tropas + 1 que se habia quedado.
    }
}
