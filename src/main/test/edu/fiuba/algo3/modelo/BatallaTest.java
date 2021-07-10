package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;

import java.util.ArrayList;

public class BatallaTest {

    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Santiago", 1);
        this.jugador2 = new Jugador("Ramiro", 2);
    }

    @Test
    public void testAsignarDadosLosOrdenaPorValorDescendente(){
        // Los dados que le salieron al atacante.
        ArrayList<Dado> dadosAtacante = new ArrayList<>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(1);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);

        // Los dados del defensor.
        ArrayList<Dado> dadosDefensor = new ArrayList<>();
        Dado dadoDefensor = new Dado(6);
        Dado dadoDefensor2 = new Dado(2);
        dadosDefensor.add(dadoDefensor);
        dadosDefensor.add(dadoDefensor2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarDados(dadosAtacante,dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar();

        assertEquals(2,unaBatallaEpica.obtenerNumeroDadosAComparar());
        
        assertEquals(6,unaBatallaEpica.obtenerDadosAtacante().get(0).obtenerValor());
        assertEquals(1,unaBatallaEpica.obtenerDadosAtacante().get(1).obtenerValor());
        
        assertEquals(6,unaBatallaEpica.obtenerDadosDefensor().get(0).obtenerValor());
        assertEquals(2,unaBatallaEpica.obtenerDadosDefensor().get(1).obtenerValor());
    }

    @Test
    public void testLuchaEntrePaises() throws EjercitoYaVencidoException{
        ArrayList<Dado> dadosAtacante = new ArrayList<>();
        Dado dado = new Dado(5);
        Dado otroDado = new Dado(4);
        Dado otroDadoMas = new Dado(2);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<>();
        Dado dadoDefensor = new Dado(4); // Pierde contra el 5.
        Dado otroDadoDefensor = new Dado(3); // Pierde contra el 4.
        Dado otroDadoDefensorMas = new Dado(3); // Gana contra el 2.
        dadosDefensor.add(dadoDefensor);
        dadosDefensor.add(otroDadoDefensor);
        dadosDefensor.add(otroDadoDefensorMas);

        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        unaBatallaEpica.asignarDados(dadosAtacante, dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar();

        unaBatallaEpica.luchar();

        assertEquals(2, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }
    
    @Test
    public void testLuchaEntrePaisesConVictoriaDelAtacante() throws EjercitoYaVencidoException{
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

        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        unaBatallaEpica.asignarDados(dadosAtacante,dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar();

        unaBatallaEpica.luchar();

        assertEquals(3, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntrePaisesConVictoriaDelAtacanteConDiferenciaDeTropas() throws EjercitoYaVencidoException{
        ArrayList<Dado> dadosAtacante = new ArrayList<>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<>();
        Dado dadoDefensor = new Dado(4); // Compara contra el 6 y pierde su unica tropa.
        dadosDefensor.add(dadoDefensor);

        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        unaBatallaEpica.asignarDados(dadosAtacante,dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar();

        unaBatallaEpica.luchar();

        assertEquals(3, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntrePaisesConEmpateDeDadosConDiferenciaDeTropas() throws EjercitoYaVencidoException{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);
        
        // Los dados que le salieron al atacante.
        ArrayList<Dado> dadosAtacante = new ArrayList<>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);
        
        // Los dados del defensor.
        ArrayList<Dado> dadosDefensor = new ArrayList<>();
        Dado dadoDefensor = new Dado(6); // Compara contra el 6 y empata con el 6 del atacante.
        dadosDefensor.add(dadoDefensor);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        unaBatallaEpica.asignarDados(dadosAtacante,dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar();

        unaBatallaEpica.luchar();

        assertEquals(2, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }
}
