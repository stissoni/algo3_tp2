package edu.fiuba.algo3.modelo;

public class DadosParaDefensaStrategy implements IDadosStrategy {
    public int compararDados(Tirada unaTirada, Tirada otraTirada){
        int numeroDeDadosMayorOIgual = 0;
        Dado miDado;
        Dado otroDado;
        int index = 0;
        while (index < unaTirada.size()){
            miDado = unaTirada.get(index);
            otroDado = otraTirada.get(index);
            if (miDado.esMayorQue(otroDado) || miDado.esIgualQue(otroDado)){
               numeroDeDadosMayorOIgual = numeroDeDadosMayorOIgual + 1;
            }
            index = index + 1;
        }
        return numeroDeDadosMayorOIgual;
    }
}
