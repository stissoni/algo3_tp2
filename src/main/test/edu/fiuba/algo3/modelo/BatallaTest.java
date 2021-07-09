package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.excepciones.EjercitoYaVencidoException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class BatallaTest {

    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void setUp() throws Exception{
        this.jugador1 = new Jugador("Santiago", 1);
        this.jugador2 = new Jugador("Ramiro", 2);
    }

    @Test
    public void testNumeroDeDadosAtacanteMayorA3(){
        Ejercito ejercitoAtacante = mock(Ejercito.class);
        Ejercito ejercitoDefensor = mock(Ejercito.class);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(3, batalla.obtenerNumeroDadosAtacante(4));
    }

    @Test
    public void testNumeroDeDadosAtacanteMenorA3(){
        Ejercito ejercitoAtacante = mock(Ejercito.class);
        Ejercito ejercitoDefensor = mock(Ejercito.class);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        assertEquals(2, batalla.obtenerNumeroDadosAtacante(2));
    }

    @Test
    public void testNumeroDeDadosAComparar(){
        Ejercito ejercitoAtacante = mock(Ejercito.class);
        Ejercito ejercitoDefensor = mock(Ejercito.class);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla batalla = new Batalla(paisAtacante, paisDefensor);

        batalla.asignarNumeroDadosAComparar(4, 2);

        assertEquals(2, batalla.obtenerNumeroDadosAComparar());
    }

    @Test
    public void testLuchaEntrePaises() throws EjercitoYaVencidoException{
        ArrayList<Dado> dadosAtacante = new ArrayList<Dado>();
        Dado dado = new Dado(5);
        Dado otroDado = new Dado(4);
        Dado otroDadoMas = new Dado(2);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<Dado>();
        Dado dadoDefensor = new Dado(4); // Pierde contra el 5.
        Dado otroDadoDefensor = new Dado(3); // Pierde contra el 4.
        Dado otroDadoDefensorMas = new Dado(3); // Gana contra el 2.
        dadosDefensor.add(dadoDefensor);
        dadosDefensor.add(otroDadoDefensor);
        dadosDefensor.add(otroDadoDefensorMas);

        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla unaBatallaEpica = new Batalla(paisAtacante, paisDefensor);
        unaBatallaEpica.asignarDadosAtacante(dadosAtacante);
        unaBatallaEpica.asignarDadosDefensor(dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar(3, 3);

        unaBatallaEpica.luchar();

        assertEquals(2, paisAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, paisDefensor.obtenerNumeroTotalDeTropas());
    }
    
    @Test
    public void testLuchaEntrePaisesConVictoriaDelAtacante() throws EjercitoYaVencidoException{
        ArrayList<Dado> dadosAtacante = new ArrayList<Dado>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<Dado>();
        Dado dadoDefensor = new Dado(4); // Pierde contra el 6.
        Dado otroDadoDefensor = new Dado(3); // Pierde contra el 5.
        Dado otroDadoDefensorMas = new Dado(3); // Pierde contra el 3.
        dadosDefensor.add(dadoDefensor);
        dadosDefensor.add(otroDadoDefensor);
        dadosDefensor.add(otroDadoDefensorMas);

        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla unaBatallaEpica = new Batalla(paisAtacante, paisDefensor);
        unaBatallaEpica.asignarDadosAtacante(dadosAtacante);
        unaBatallaEpica.asignarDadosDefensor(dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar(3, 3);

        unaBatallaEpica.luchar();

        assertEquals(3, paisAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, paisDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntrePaisesConVictoriaDelAtacanteConDiferenciaDeTropas() throws EjercitoYaVencidoException{
        ArrayList<Dado> dadosAtacante = new ArrayList<Dado>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);

        ArrayList<Dado> dadosDefensor = new ArrayList<Dado>();
        Dado dadoDefensor = new Dado(4); // Compara contra el 6 y pierde su unica tropa.
        dadosDefensor.add(dadoDefensor);

        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);

        Batalla unaBatallaEpica = new Batalla(paisAtacante, paisDefensor);
        unaBatallaEpica.asignarDadosAtacante(dadosAtacante);
        unaBatallaEpica.asignarDadosDefensor(dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar(3, 1);

        unaBatallaEpica.luchar();

        assertEquals(3, paisAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, paisDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntrePaisesConEmpateDeDadosConDiferenciaDeTropas() throws EjercitoYaVencidoException{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Pais paisAtacante = new Pais("Argentina", ejercitoAtacante);
        Pais paisDefensor = new Pais("Brasil", ejercitoDefensor);
        
        // Los dados que le salieron al atacante.
        ArrayList<Dado> dadosAtacante = new ArrayList<Dado>();
        Dado dado = new Dado(6);
        Dado otroDado = new Dado(5);
        Dado otroDadoMas = new Dado(5);
        dadosAtacante.add(dado);
        dadosAtacante.add(otroDado);
        dadosAtacante.add(otroDadoMas);
        
        // Los dados del defensor.
        ArrayList<Dado> dadosDefensor = new ArrayList<Dado>();
        Dado dadoDefensor = new Dado(6); // Compara contra el 6 y empata con el 6 del atacante.
        dadosDefensor.add(dadoDefensor);

        Batalla unaBatallaEpica = new Batalla(paisAtacante, paisDefensor);
        unaBatallaEpica.asignarDadosAtacante(dadosAtacante);
        unaBatallaEpica.asignarDadosDefensor(dadosDefensor);
        unaBatallaEpica.asignarNumeroDadosAComparar(3, 1);

        unaBatallaEpica.luchar();

        assertEquals(2, paisAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, paisDefensor.obtenerNumeroTotalDeTropas());
    }
}
