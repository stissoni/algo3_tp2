package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class MazoPaisBuilder {
    private MazoPaises resultado;

    public void reset(){
        this.resultado = new MazoPaises();
    }

    public void cargarTarjetas() throws IOException{
        Parser parser = new Parser();

        ArrayList<String[]> tarjetas = parser.cargarTarjetasPais("./src/main/java/edu/fiuba/algo3/modelo/tarjetas.csv");
        for (String[] tarjeta: tarjetas){
            CartaPais nuevaCarta = new CartaPais(tarjeta[0], tarjeta[1]);
            this.resultado.agregarCarta(nuevaCarta);
        }
    }

    public MazoPaises obtenerResultado(){
        return this.resultado;
    }
}
