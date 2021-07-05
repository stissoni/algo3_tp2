package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;

public class DadoTest {
    
    @Test
    public void testNumeroDeDadoMayorA0(){
        Dado unDado = new Dado();
        unDado.tirarDado();

        assertTrue(unDado.obtenerNumeroDeTirada() > 0);
    }

    @Test
    public void testNumeroDeDadoMenorA7(){
        Dado unDado = new Dado();
        unDado.tirarDado();

        assertTrue(unDado.obtenerNumeroDeTirada() < 7);
    }

    @Test
    public void testSePuedenOrdenarLosDados(){
        Dado unDado = mock(Dado.class);
        Dado otroDado = mock(Dado.class);

        when(unDado.obtenerNumeroDeTirada()).thenReturn(6);
        when(otroDado.obtenerNumeroDeTirada()).thenReturn(4);

        when(unDado.compareTo(otroDado)).thenCallRealMethod();
        when(otroDado.compareTo(unDado)).thenCallRealMethod();

        ArrayList<Dado> dados = new ArrayList<Dado>();
        dados.add(unDado);
        dados.add(otroDado);
        
        Collections.sort(dados);

        assertSame(otroDado, dados.get(0));
        assertSame(unDado, dados.get(1));
    }

    public void testSePuedenOrdenarLosDadosDeMayorAMenor(){
        Dado unDado = mock(Dado.class);
        Dado otroDado = mock(Dado.class);

        when(unDado.obtenerNumeroDeTirada()).thenReturn(3);
        when(otroDado.obtenerNumeroDeTirada()).thenReturn(2);

        when(unDado.compareTo(otroDado)).thenCallRealMethod();
        when(otroDado.compareTo(unDado)).thenCallRealMethod();

        ArrayList<Dado> dados = new ArrayList<Dado>();
        dados.add(unDado);
        dados.add(otroDado);
        
        Collections.sort(dados);
        Collections.reverse(dados);

        assertSame(unDado, dados.get(0));
        assertSame(otroDado, dados.get(1));
    }

    @Test 
    public void testUnDadoEsMayorQueOtro(){
        Dado unDado = mock(Dado.class);
        Dado otroDado = mock(Dado.class);

        when(unDado.obtenerNumeroDeTirada()).thenReturn(3);
        when(otroDado.obtenerNumeroDeTirada()).thenReturn(2);

        when(unDado.esMayorQue(otroDado)).thenCallRealMethod();

        assertTrue(unDado.esMayorQue(otroDado));
    }
}
