package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonVerObjetivoHandler implements EventHandler<ActionEvent>{
    Partida partida;

    public BotonVerObjetivoHandler(Partida partida){
        this.partida = partida;
    }

    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Objetivo del jugador");
        String alertText = "Objetivo de "+this.partida.obtenerJugadorActual().obtenerNombre();
        alert.setHeaderText(alertText);
        String mensaje = this.partida.obtenerJugadorActual().obtenerObjetivo().estadoDelObjetivo(this.partida.obtenerMapa());
        alert.setContentText(mensaje);
        alert.show();
    }
}
