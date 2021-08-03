package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ObjetivosBuilderTest {
    @Test
    public void testCreacionDeObjetivos() throws IOException{
        Director director = new Director();
        ObjetivosBuilder objetivosBuilder = new ObjetivosBuilder();
        MapaBuilder mapaBuilder = new MapaBuilder();
        director.crearMapa(mapaBuilder);
        
        Mapa mapa = mapaBuilder.obtenerResultado();

        director.crearObjetivos(objetivosBuilder, mapa);

        ArrayList<ObjetivoConquista> objetivos = objetivosBuilder.obtenerResultado();
        
        assertEquals(6, objetivos.size());

        for (ObjetivoConquista objetivo: objetivos){
            System.out.println(objetivo.descripcionDelObjetivo());
        }

    }
}
