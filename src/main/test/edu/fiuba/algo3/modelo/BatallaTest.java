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

        int numeroDeDadosAComparar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();

        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(5).thenReturn(4).thenReturn(2).thenReturn(4).thenReturn(3).thenReturn(3);

        Dados dados = new Dados(generador);

        Tirada dadosAtacante = dados.tirarDados(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        dadosAtacante.ordenarDadosDeMayorAMenor();
        dadosAtacante.setStrategy(new DadosParaAtaqueStrategy());

        Tirada dadosDefensor = dados.tirarDados(ejercitoDefensor.obtenerNumeroTotalDeTropas());
        dadosDefensor.ordenarDadosDeMayorAMenor();
        dadosDefensor.setStrategy(new DadosParaDefensaStrategy());

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor, numeroDeDadosAComparar);

        assertEquals(2, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }
    
    @Test
    public void testLuchaEntreEjercitosConVictoriaDelAtacante() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(3, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDeDadosAComparar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();
        
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(6).thenReturn(5).thenReturn(5).thenReturn(4).thenReturn(3).thenReturn(3);

        Dados dados = new Dados(generador);

        Tirada dadosAtacante = dados.tirarDados(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        dadosAtacante.ordenarDadosDeMayorAMenor();
        dadosAtacante.setStrategy(new DadosParaAtaqueStrategy());
       
        Tirada dadosDefensor = dados.tirarDados(ejercitoDefensor.obtenerNumeroTotalDeTropas());
        dadosDefensor.ordenarDadosDeMayorAMenor();
        dadosDefensor.setStrategy(new DadosParaDefensaStrategy());

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor, numeroDeDadosAComparar);

        assertEquals(3, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntreEjercitosConVictoriaDelAtacanteConDiferenciaDeTropas() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDeDadosAComparar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();
        
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);        
        when(generador.generar()).thenReturn(6).thenReturn(4).thenReturn(6).thenReturn(1);

        Dados dados = new Dados(generador);

        Tirada dadosAtacante = dados.tirarDados(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        dadosAtacante.ordenarDadosDeMayorAMenor();
        dadosAtacante.setStrategy(new DadosParaAtaqueStrategy());

        Tirada dadosDefensor = dados.tirarDados(ejercitoDefensor.obtenerNumeroTotalDeTropas());
        dadosDefensor.ordenarDadosDeMayorAMenor();
        dadosDefensor.setStrategy(new DadosParaDefensaStrategy());

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor, numeroDeDadosAComparar);

        assertEquals(3, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(0, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }

    @Test
    public void testLuchaEntreEjercitosConEmpateDeDadosConDiferenciaDeTropas() throws Throwable{
        Ejercito ejercitoAtacante = new Ejercito(3, jugador1);
        Ejercito ejercitoDefensor = new Ejercito(1, jugador2);

        Batalla unaBatallaEpica = new Batalla();
        unaBatallaEpica.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDeDadosAComparar = unaBatallaEpica.numeroDeDadosQueSeUtilizaran();
        
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        when(generador.generar()).thenReturn(4).thenReturn(4).thenReturn(2).thenReturn(4);
        
        Dados dados = new Dados(generador);
        
        Tirada dadosAtacante = dados.tirarDados(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        dadosAtacante.ordenarDadosDeMayorAMenor();
        dadosAtacante.setStrategy(new DadosParaAtaqueStrategy());

        Tirada dadosDefensor = dados.tirarDados(ejercitoDefensor.obtenerNumeroTotalDeTropas());
        dadosDefensor.ordenarDadosDeMayorAMenor();
        dadosDefensor.setStrategy(new DadosParaDefensaStrategy());

        unaBatallaEpica.luchar(dadosAtacante, dadosDefensor, numeroDeDadosAComparar);
        
        assertEquals(2, ejercitoAtacante.obtenerNumeroTotalDeTropas());
        assertEquals(1, ejercitoDefensor.obtenerNumeroTotalDeTropas());
    }
}
