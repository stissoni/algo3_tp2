package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;

public class DadoTest {
    
    @Test
    public void testNumeroDeDadoMayorACero(){
        Dado dado = new Dado();
        assertTrue(dado.obtenerValor() > 0);
    }

    @Test
    public void testNumeroDeDadoMenorASiete(){
        Dado dado = new Dado();
        assertTrue(dado.obtenerValor() < 7);
    }

    @Test
    public void testTirarDadoTieneValorValido(){
        Dado dado = new Dado();
        dado.tirar();
        assertTrue(dado.obtenerValor() > 0 && dado.obtenerValor() < 7);
    }

    @Test
    public void testUnDadoEsMayorQueOtro(){
        Dado unDado = new Dado(5);
        Dado otroDado = new Dado(4);

        assertTrue(unDado.esMayorQue(otroDado));
    }

    @Test
    public void testSePuedeCrearUnArrayListDeDados() {
        int cantidad = 3;
        ArrayList<Dado> dados = Dado.tirar(cantidad);
        assertEquals(cantidad, dados.size());
    }

    @Test
    public void testTirarVariosDadosEnArrayListEsValido() {
        int cantidad = 10;
        ArrayList<Dado> dados = Dado.tirar(cantidad);
        boolean valorValido = true;
        for (Dado dado: dados) {
            valorValido = dado.obtenerValor() > 0 && dado.obtenerValor() < 7;
            if (!valorValido) break;
        }
        assertTrue(valorValido);
    }

    private boolean arrayListDeDadosEstaOrdenadoDecrecientemente(ArrayList<Dado> dados) {
        for (int i=0; i<(dados.size()-1); ++i){
            if (dados.get(i+1).esMayorQue(dados.get(i))) return false;
        }
        return true;
    }

    @Test
    public void testSePuedeOrdenarUnArrayListDeDadosDecrecientemente(){
        int cantidad = 10;
        ArrayList<Dado> dados = Dado.tirar(cantidad);

        dados.sort(Collections.reverseOrder());

        assertTrue(arrayListDeDadosEstaOrdenadoDecrecientemente(dados));
    }

    @Test
    public void testVerSalidaDeTirarDados(){
        int cantidad = 3;
        ArrayList<Dado> dados = Dado.tirar(cantidad);

        dados.sort(Collections.reverseOrder());

        for (int i = 0; i < cantidad; ++i){
            System.out.println(dados.get(i).obtenerValor());
        }
    }
}
