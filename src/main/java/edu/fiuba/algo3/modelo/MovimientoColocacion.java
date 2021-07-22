package edu.fiuba.algo3.modelo;


public class MovimientoColocacion implements Movimiento{
    private Ejercito ejercitoAColocar;
    private Pais destinoPais;

    public void ejecutar() throws Throwable{
        destinoPais.agregarEjercito(ejercitoAColocar);
    }

    public void ejercitoAColocar(Ejercito ejercito){
        this.ejercitoAColocar = ejercito;
    }

    public void destinoPais(Pais pais){
        this.destinoPais = pais;
    }
}