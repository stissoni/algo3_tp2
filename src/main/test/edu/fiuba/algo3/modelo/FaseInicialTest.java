package edu.fiuba.algo3.modelo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class FaseInicialTest {
    @Test
    public void testFaseInicialCompletada(){
        FaseInicial faseInicial = new FaseInicial();
        RondaColocacion ronda = mock(RondaColocacion.class);
        when(ronda.terminoRonda()).thenReturn(true);

        
    }
}
