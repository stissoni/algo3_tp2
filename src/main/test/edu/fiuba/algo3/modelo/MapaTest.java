package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {
    String ruta = "src/main/java/edu/fiuba/algo3/modelo/paises.csv";
    Mapa mapa = new Mapa(ruta);

    public MapaTest() throws LeerArchivoError {
    }

    @Test
    public void testMapaCreadoCorrectamente(){
        assertTrue(mapa.mapaFueCreadoCorrectamente());
    }
}
