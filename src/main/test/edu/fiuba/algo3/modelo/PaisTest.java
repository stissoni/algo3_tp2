package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PaisTest {

    @Test
    public void testPaisEjercitoControlando(){
        Ejercito unEjercito = new Ejercito(2);
        Ejercito otroEjercito = new Ejercito(2);

        Pais unPais = new Pais("Argentina", unEjercito);
        assertSame(unPais.obtenerEjercito(), unEjercito);

        unPais.entregarControlAlEjercitoDe(otroEjercito);
        assertSame(unPais.obtenerEjercito(), otroEjercito);
    }
}
