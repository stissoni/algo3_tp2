package edu.fiuba.algo3.modelo;

public class Batalla {
    private Ejercito ejercitoAtacante;
    private Ejercito ejercitoDefensor;

    public void asignarEjercitos(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
        this.ejercitoAtacante = ejercitoAtacante;
        this.ejercitoDefensor = ejercitoDefensor;
    }

    public int numeroDeDadosQueSeUtilizaran(){
        int numeroDados = Math.min(
            ejercitoAtacante.obtenerNumeroTotalDeTropas(),
            ejercitoDefensor.obtenerNumeroTotalDeTropas()
        );
        if (numeroDados > 3){
            numeroDados = 3;
        }
        return numeroDados;
    }

    public Ejercito obtenerEjercitoAtacante(){
        return this.ejercitoAtacante;
    }

    public Ejercito obtenerEjercitoDefensor(){
        return this.ejercitoDefensor;
    }

    public void luchar(ConjuntoDados dadosAtacante, ConjuntoDados dadosDefensor) throws Throwable{
        int numeroDeTropasPerdidasPorDefensor = 
            dadosAtacante.numeroDeDadosQueSonMayores(dadosDefensor);

        int numeroDeTropasPerdidasPorAtacante =
            dadosDefensor.numeroDeDadosQueSonMayoresOIguales(dadosAtacante);

        this.ejercitoAtacante.reducirTropas(numeroDeTropasPerdidasPorAtacante);
        this.ejercitoDefensor.reducirTropas(numeroDeTropasPerdidasPorDefensor);
    }
}
