package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.MovimientoReagrupacion;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonReagruparEventHandler implements EventHandler<ActionEvent> {
    private ContenedorPrincipal contenedor;
    private Partida partida;
    private String nombrePaisOrigen;
    private String nombrePaisDestino;
    private int numeroTropas;

    public BotonReagruparEventHandler(ContenedorPrincipal contenedor, Partida partida){
        this.contenedor = contenedor;
        this.partida = partida;
    }

    public void setPaisOrigen(String pais){
        this.nombrePaisOrigen = pais;
    }

    public void setPaisDestino(String pais){
        this.nombrePaisDestino = pais;
    }

    public void setNumeroTropas(int numeroTropas){
        this.numeroTropas = numeroTropas;
    }

    public void handle(ActionEvent actionEvent){
        Pais paisOrigen = this.partida.obtenerUnPais(this.nombrePaisOrigen);
        Pais paisDestino = this.partida.obtenerUnPais(this.nombrePaisDestino);
        MovimientoReagrupacion movimiento = new MovimientoReagrupacion();
        movimiento.paisOrigen(paisOrigen);
        movimiento.paisDestino(paisDestino);
        movimiento.cantidadDeTropas(this.numeroTropas);
        try{
            this.partida.ejecutarMovimiento(movimiento);
        }
        catch (Throwable e){

        }
        this.contenedor.refresh();
    }
}
