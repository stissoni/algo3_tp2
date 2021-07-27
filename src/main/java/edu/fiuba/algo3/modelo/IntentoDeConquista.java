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

        Dados dados = new Dados(generador);

        Tirada tiradaAtacante = dados.tirarDados(numeroDeDados);
        Tirada tiradaDefensor = dados.tirarDados(numeroDeDados);

        tiradaAtacante.ordenarDadosDeMayorAMenor();
        tiradaAtacante.setStrategy(new DadosParaAtaqueStrategy());

        tiradaDefensor.ordenarDadosDeMayorAMenor();
        tiradaDefensor.setStrategy(new DadosParaDefensaStrategy());

        batalla.luchar(tiradaAtacante, tiradaDefensor);

        if (paisDefensor.suEjercitoFueVencido()){
            paisDefensor.asignarEjercito(ejercitoAtacante);
        }
        else {
            paisConquistador.reagruparEjercito(ejercitoAtacante);
        }
    }
}
