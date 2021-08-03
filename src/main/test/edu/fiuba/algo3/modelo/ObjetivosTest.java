package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ObjetivosTest {
    @Test
    public void testObjetivo() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();
        mapaBuilder.asignarPaisesLimitrofes();
        mapaBuilder.asignarPaisesAContinentes();

        Mapa mapa = mapaBuilder.obtenerResultado();

        ObjetivoConquista conquistar1DeAmericaDelSur = new ObjetivoConquista();
        Continente americaDelSur = mapa.obtenerUnContinente("America Del Sur");

        conquistar1DeAmericaDelSur.agregarContinenteAConquistar(
            americaDelSur,
            1
        );
        Pais unPaisCualquiera = americaDelSur.obtenerPaises().get(0);
        Jugador unJugadorCualquiera = new Jugador("Santiago", 1);
        Ejercito unEjercitoCuaqluiera = new Ejercito(3, unJugadorCualquiera);
        unPaisCualquiera.asignarEjercito(unEjercitoCuaqluiera);

        conquistar1DeAmericaDelSur.setJugador(unJugadorCualquiera);

        assertTrue(conquistar1DeAmericaDelSur.logroElObjetivo(mapa));
    }

    @Test
    public void testObjetivoFallado() throws IOException{
        MapaBuilder mapaBuilder = new MapaBuilder();

        mapaBuilder.reset();
        mapaBuilder.asignarPaises();
        mapaBuilder.asignarContinentes();
        mapaBuilder.asignarPaisesLimitrofes();
        mapaBuilder.asignarPaisesAContinentes();

        Mapa mapa = mapaBuilder.obtenerResultado();

        Jugador unJugadorCualquiera = new Jugador("Santiago", 1);
        
        ObjetivoConquista conquistar1DeEuropa = new ObjetivoConquista();
        Continente europa = mapa.obtenerUnContinente("Europa");
        conquistar1DeEuropa.agregarContinenteAConquistar(
            europa,
            1
        );
        conquistar1DeEuropa.setJugador(unJugadorCualquiera);

        Continente americaDelSur = mapa.obtenerUnContinente("America Del Sur");
        Pais unPaisCualquiera = americaDelSur.obtenerPaises().get(0);
        Ejercito unEjercitoCuaqluiera = new Ejercito(3, unJugadorCualquiera);
        unPaisCualquiera.asignarEjercito(unEjercitoCuaqluiera);

        assertFalse(conquistar1DeEuropa.logroElObjetivo(mapa));
    }
}
