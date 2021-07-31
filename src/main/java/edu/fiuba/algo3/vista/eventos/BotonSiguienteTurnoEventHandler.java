package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSiguienteTurnoEventHandler implements EventHandler<ActionEvent>{
    ContenedorPrincipal contenedor;
    Partida partida;

    public BotonSiguienteTurnoEventHandler(ContenedorPrincipal contenedor, Partida partida){
        this.contenedor = contenedor;
        this.partida = partida;
    }
    
    public void handle(ActionEvent actionEvent){
        System.out.println("Termina turno jugador: "+this.partida.obtenerJugadorActual().obtenerNombre());
        this.partida.terminarTurno();
        System.out.println("Pasando al turno de: "+this.partida.obtenerJugadorActual().obtenerNombre());
        this.contenedor.refresh();
    }
}
