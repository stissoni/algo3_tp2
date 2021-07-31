package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta){
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    public void handle(ActionEvent ActionEvent){
        if (!stage.isFullScreen()){
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }  
}
