package edu.fiuba.algo3.modelo;

public class IntentoDeConquista {
    private Pais paisConquistador;
    private Pais paisDefensor;

    public IntentoDeConquista(Pais paisConquistador, Pais paisDefensor){
        this.paisConquistador = paisConquistador;
        this.paisDefensor = paisDefensor;
    }

    public void intentarConquista(int numeroTropasAtacante, GeneradorAleatorio generador) throws Throwable{
        Ejercito ejercitoAtacante = this.paisConquistador.ejercitoParaAtacar(numeroTropasAtacante);
        Ejercito ejercitoDefensor = this.paisDefensor.obtenerEjercito();

        Batalla batalla = new Batalla();
        batalla.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDeDados = batalla.numeroDeDadosQueSeUtilizaran();

        ConjuntoDados dadosAtacante = new ConjuntoDados(generador);
        ConjuntoDados dadosDefensor = new ConjuntoDados(generador);

        dadosAtacante.tirarDados(numeroDeDados);
        dadosAtacante.ordenarDadosDeMayorAMenor();
        dadosDefensor.tirarDados(numeroDeDados);
        dadosDefensor.ordenarDadosDeMayorAMenor();

        batalla.luchar(dadosAtacante, dadosDefensor);

        if (paisDefensor.suEjercitoFueVencido()){
            paisDefensor.asignarEjercito(ejercitoAtacante);
        }
        else {
            paisConquistador.reagruparEjercito(ejercitoAtacante);
        }
    }
}
