package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ConjuntoDadosTest {
    @Test
    public void testValorDeLosDados(){
        GeneradorAleatorio generador = mock(GeneradorAleatorio.class);
        
        when(generador.generar()).thenReturn(6).thenReturn(3).thenReturn(3);
        ConjuntoDados conjuntoDadosUno = new ConjuntoDados(generador);
        conjuntoDadosUno.tirarDados(3);
        conjuntoDadosUno.ordenarDadosDeMayorAMenor();
        
        when(generador.generar()).thenReturn(2).thenReturn(4).thenReturn(1);
        ConjuntoDados conjuntoDadosDos = new ConjuntoDados(generador);
        conjuntoDadosDos.tirarDados(3);
        conjuntoDadosDos.ordenarDadosDeMayorAMenor();
        
        assertEquals(3, conjuntoDadosUno.numeroDeDadosQueSonMayores(conjuntoDadosDos));
    }
}
