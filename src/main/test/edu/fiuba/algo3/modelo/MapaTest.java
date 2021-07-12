package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.LeerArchivoError;
import edu.fiuba.algo3.excepciones.PaisNoExisteError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {
    String ruta = "src/main/java/edu/fiuba/algo3/modelo/paises.csv";
    Mapa mapa = new Mapa(ruta);

    public MapaTest() throws LeerArchivoError {
    }

    @Test
    public void cargarPaisesTiene50Paises() {
        assertEquals(50,mapa.size());
    }

    @Test
    public void paisesAdyacentesPuedenAtacarse() throws PaisNoExisteError {
        assertTrue(mapa.puedeAtacar("Argentina","Brasil"));
    }

    @Test
    public void paisesNoAdyacentesNoPuedenAtacarse() throws PaisNoExisteError {
        assertFalse(mapa.puedeAtacar("Argentina","China"));
    }

    @Test
    public void mezclarPaisesLosMezcla() {
        List<String> paisesEnOrden = mapa.obtenerPaises();
        List<String> paisesDesordenados = mapa.obtenerPaisesMezclados();
        assertNotEquals(paisesEnOrden, paisesDesordenados);
    }

    @Test
    public void crearMapaConRutaInexistenteLanzaError() {
        String nuevaRuta = "a";
        assertThrows(LeerArchivoError.class, ()->new Mapa(nuevaRuta));
    }

    @Test
    public void atacarAUnPaisQueNoExisteLanzaError() {
        assertThrows(PaisNoExisteError.class, ()->mapa.puedeAtacar("Argentina","Honduras"));
    }
}
