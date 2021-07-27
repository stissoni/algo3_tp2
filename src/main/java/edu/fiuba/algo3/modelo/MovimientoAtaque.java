package edu.fiuba.algo3.modelo;

public class MovimientoAtaque implements Movimiento {
    private Jugador unJugador;
    private Pais paisConquistador;
    private Pais paisDefensor;
    private GeneradorAleatorio generador;
    private int numeroTropas;

    public int tropasUtilizadas(){
        return this.numeroTropas;
    }

    public void jugador(Jugador unJugador){
        this.unJugador = unJugador;
    }

    public void paisAtacante(Pais paisAtacante){
        this.paisConquistador = paisAtacante;
    }

    public void paisDefensor(Pais paisDefensor){
        this.paisDefensor = paisDefensor;
    }

    public void numeroDeTropas(int numeroTropas){
        this.numeroTropas = numeroTropas;
    }

    public void generador(GeneradorAleatorio generador){
        this.generador = generador;
    }

    public void ejecutar() throws Throwable{
        Ejercito ejercitoAtacante = this.paisConquistador.ejercitoParaAtacar(this.numeroTropas);
        Ejercito ejercitoDefensor = this.paisDefensor.obtenerEjercito();

        Batalla batalla = new Batalla();
        batalla.asignarEjercitos(ejercitoAtacante, ejercitoDefensor);
        int numeroDeDados = batalla.numeroDeDadosQueSeUtilizaran();

        Dados dados = new Dados(this.generador);

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
