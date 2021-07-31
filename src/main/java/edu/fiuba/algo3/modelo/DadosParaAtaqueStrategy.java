package edu.fiuba.algo3.modelo;

public class DadosParaAtaqueStrategy implements IDadosStrategy{
    public int compararDados(Tirada unaTirada, Tirada otraTirada, int numeroDeDados){
        int numeroDeDadosMayor = 0;
        Dado miDado;
        Dado otroDado;
        int index = 0;
        while (index < numeroDeDados){
            miDado = unaTirada.get(index);
            otroDado = otraTirada.get(index);
            if (miDado.esMayorQue(otroDado)){
               numeroDeDadosMayor = numeroDeDadosMayor + 1;
            }
            index = index + 1;
        }
        return numeroDeDadosMayor;
    }
}
