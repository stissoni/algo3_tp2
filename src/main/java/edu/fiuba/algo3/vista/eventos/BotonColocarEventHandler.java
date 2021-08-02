package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.MovimientoColocacion;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonColocarEventHandler implements EventHandler<ActionEvent> {
    private ContenedorPrincipal contenedor;
    private String nombrePais;
    private int numeroTropas;
    private Partida partida;

    public BotonColocarEventHandler(ContenedorPrincipal contenedor, String nombrePais, int numeroTropas, Partida partida){
        this.contenedor = contenedor;
        this.nombrePais = nombrePais;
        this.numeroTropas = numeroTropas;
        this.partida = partida;
    }

    public void handle(ActionEvent actionEvent){
        System.out.println("Agregando "+this.numeroTropas+"a: "+this.nombrePais);
        Pais paisDestino = this.partida.obtenerUnPais(this.nombrePais);
        MovimientoColocacion nuevoMovimiento = new MovimientoColocacion();
        nuevoMovimiento.destinoPais(paisDestino);
        nuevoMovimiento.numeroTropas(this.numeroTropas);
        try{
            this.partida.ejecutarMovimiento(nuevoMovimiento);
        }
        catch (Throwable e){
            e.printStackTrace();
        }
        this.contenedor.refresh();
    }
}
