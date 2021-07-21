package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DadoTest {
    @Test
    public void testUnDadoEsMayorQueOtro(){
        Dado unDado = new Dado(6);
        Dado otroDado = new Dado(5);

        assertTrue(unDado.esMayorQue(otroDado));
    }

    @Test
    public void testUnDadoEsIgualQueOtro(){
        Dado unDado = new Dado(4);
        Dado otroDado = new Dado(4);

        assertTrue(unDado.esIgualQue(otroDado));
    }
}
