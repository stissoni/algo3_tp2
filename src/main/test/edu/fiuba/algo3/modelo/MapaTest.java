package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {
    String ruta = "src/main/java/edu/fiuba/algo3/modelo/paises.csv";
    Mapa mapa = new Mapa(ruta);

    @Test
    public void cargarPaisesTiene50Paises() {
        assertEquals(50,mapa.size());
    }

    @Test
    public void paisesAdyacentesPuedenAtacarse() {
        assertTrue(mapa.puedeAtacar("Argentina","Brasil"));
    }

    @Test
    public void paisesNoAdyacentesNoPuedenAtacarse() {
        assertFalse(mapa.puedeAtacar("Argentina","China"));
    }
}
