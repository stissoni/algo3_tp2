package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BatallaTest {

    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador("Santiago", 1);
        this.jugador2 = new Jugador("Ramiro", 2);
    }

    @Test
    public void testLuchaEntreEjercitos() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);

        int numeroDadosAUtilizar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();

        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        
        when(generador.generar()).thenReturn(5).thenReturn(4).thenReturn(2);
        ConjuntoDados dadosAtacante = new ConjuntoDados(generador);
        dadosAtacante.tirarDados(numeroDadosAUtilizar);
        dadosAtacante.ordenarDadosDeMayorAMenor();
       
        when(generador.generar()).thenReturn(4).thenReturn(3).thenReturn(3);
        ConjuntoDados dadosDefensor = new ConjuntoDados(generador);
        dadosDefensor.tirarDados(numeroDadosAUtilizar);
        dadosDefensor.ordenarDadosDeMayorAMenor();

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor);

        assertEquals(2, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }
    
    @Test
    public void testLuchaEntreEjercitosConVictoriaDelAtacante() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDadosAUtilizar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();
        
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        
        when(generador.generar()).thenReturn(6).thenReturn(5).thenReturn(5);
        ConjuntoDados dadosAtacante = new ConjuntoDados(generador);
        dadosAtacante.tirarDados(numeroDadosAUtilizar);
        dadosAtacante.ordenarDadosDeMayorAMenor();
       
        when(generador.generar()).thenReturn(4).thenReturn(3).thenReturn(3);
        ConjuntoDados dadosDefensor = new ConjuntoDados(generador);
        dadosDefensor.tirarDados(numeroDadosAUtilizar);
        dadosDefensor.ordenarDadosDeMayorAMenor();

        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor);

        assertEquals(3, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntreEjercitosConVictoriaDelAtacanteConDiferenciaDeTropas() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDadosAUtilizar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();
        
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        
        when(generador.generar()).thenReturn(6);
        ConjuntoDados dadosAtacante = new ConjuntoDados(generador);
        dadosAtacante.tirarDados(numeroDadosAUtilizar);
        dadosAtacante.ordenarDadosDeMayorAMenor();

        when(generador.generar()).thenReturn(4);
        ConjuntoDados dadosDefensor = new ConjuntoDados(generador);
        dadosDefensor.tirarDados(numeroDadosAUtilizar);
        dadosDefensor.ordenarDadosDeMayorAMenor();

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor);

        assertEquals(3, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntreEjercitosConEmpateDeDadosConDiferenciaDeTropas() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDadosAUtilizar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();
        
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        
        when(generador.generar()).thenReturn(4);
        ConjuntoDados dadosAtacante = new ConjuntoDados(generador);
        dadosAtacante.tirarDados(numeroDadosAUtilizar);
        dadosAtacante.ordenarDadosDeMayorAMenor();

        when(generador.generar()).thenReturn(4);
        ConjuntoDados dadosDefensor = new ConjuntoDados(generador);
        dadosDefensor.tirarDados(numeroDadosAUtilizar);
        dadosDefensor.ordenarDadosDeMayorAMenor();

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor);
        
        assertEquals(2, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }
}
