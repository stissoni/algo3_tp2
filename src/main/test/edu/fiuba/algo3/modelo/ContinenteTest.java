package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContinenteTest {
    Continente continente;
    Pais unPais;

    @BeforeEach
    public void setUp() {
        continente = new Continente("Westeros");
        unPais = new Pais("Pentos");
    }

    @Test
    public void continenteCreadoCorrectamente(){
        assertTrue(continente.tieneElMismoNombre("Westeros"));
    }

    @Test
    public void continenteSeIniciaSinPaisesAgregados(){
        assertEquals(0,continente.cantidadDePaises());
    }

    @Test
    public void paisSeAgregaAContinente(){
        continente.agregarPais(unPais);
        assertEquals(1,continente.cantidadDePaises());
    }

    @Test
    public void paisAgregadoExisteEnElContinente(){
        continente.agregarPais(unPais);
        assertEquals(unPais,continente.buscarPais("Pentos"));
    }

    @Test
    public void paisNoAgregadoNoExisteEnElContinente(){
        assertNull(continente.buscarPais("Pentos"));
    }
}




