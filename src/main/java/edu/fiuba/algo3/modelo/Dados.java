package edu.fiuba.algo3.modelo;

public class Dados {
    private GeneradorAleatorio generador;

    public Dados(GeneradorAleatorio generador){
        this.generador = generador;
    }

    public Tirada tirarDados(int cantidadDados){
        int numeroDadosMaximos = 3;
        if (cantidadDados > numeroDadosMaximos){
            cantidadDados = numeroDadosMaximos;
        }
        Tirada unaTirada = new Tirada();
        for (int i = 0; i < cantidadDados; i++){
            int numeroDeTirada = this.generador.generar();
            Dado unDado = new Dado(numeroDeTirada);
            unaTirada.agregarDado(unDado);
        }
        return unaTirada;
    }
}
