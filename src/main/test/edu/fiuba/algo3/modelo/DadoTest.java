package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DadoTest {
    private GeneradorAleatorio generador;

    @BeforeEach
    public void setUp() throws Throwable{
        this.generador = mock(GeneradorAleatorio.class);
    }
    @Test
    public void testTirarDadoTieneValorValido(){
        Dado dado = new Dado(this.generador);
        when(this.generador.generar()).thenReturn(5);
        dado.tirar();
        assertTrue(dado.obtenerValor() == 5);
    }

    @Test
    public void testUnDadoEsMayorQueOtro(){
        Dado unDado = new Dado(this.generador);
        Dado otroDado = new Dado(this.generador);

        when(this.generador.generar()).thenReturn(5).thenReturn(4);
        unDado.tirar();
        otroDado.tirar();
        assertTrue(unDado.esMayorQue(otroDado));
    }

    @Test
    public void testUnDadoEsMayorOIgualQueOtro(){
        Dado unDado = new Dado(this.generador);
        Dado otroDado = new Dado(this.generador);

        when(this.generador.generar()).thenReturn(5).thenReturn(5);
        unDado.tirar();
        otroDado.tirar();
        assertTrue(unDado.esMayorOIgualQue(otroDado));
    }
}
