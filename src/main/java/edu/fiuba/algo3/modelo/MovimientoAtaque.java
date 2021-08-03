package edu.fiuba.algo3.modelo;

public class MovimientoAtaque implements Movimiento {
    private Jugador unJugador;
    private Pais paisConquistador;
    private Pais paisDefensor;
    private GeneradorAleatorio generador;
    private String tirada;
    private int numeroTropas;
    private Pais paisGanador;

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
        if (!paisDefensor.esLimitrofeDe(this.paisConquistador)){
            // Lanzar exception.
        }
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

        Tirada tiradaAtacante = dados.tirarDados(ejercitoAtacante.obtenerNumeroTotalDeTropas());
        Tirada tiradaDefensor = dados.tirarDados(ejercitoDefensor.obtenerNumeroTotalDeTropas());

        tiradaAtacante.ordenarDadosDeMayorAMenor();
        tiradaAtacante.setStrategy(new DadosParaAtaqueStrategy());

        tiradaDefensor.ordenarDadosDeMayorAMenor();
        tiradaDefensor.setStrategy(new DadosParaDefensaStrategy());

        String stringTiradaAtacante = tiradaAtacante.obtenerStringTirada();
        String stringTiradaDefensor = tiradaDefensor.obtenerStringTirada();
        this.tirada = "Dados atacante: "+stringTiradaAtacante+"\nDados defensor: "+stringTiradaDefensor;

        batalla.luchar(tiradaAtacante, tiradaDefensor, numeroDeDados);

        if (paisDefensor.suEjercitoFueVencido()){
            paisDefensor.asignarEjercito(ejercitoAtacante);
            this.paisGanador = paisConquistador;
        }
        else {
            paisConquistador.reagruparEjercito(ejercitoAtacante);
            this.paisGanador = paisDefensor;
        }
    }

    public Pais obtenerGanador(){
        return this.paisGanador;
    }

    public String obtenerTiradas(){
        return this.tirada;
    }
}
