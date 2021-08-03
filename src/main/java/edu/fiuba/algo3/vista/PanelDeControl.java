package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ObjetivoConquista;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonVerObjetivoHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelDeControl extends VBox{
    public PanelDeControl(Stage stage, ContenedorPrincipal contenedor, Partida partida){
        this.setSpacing(10);
        this.setPadding(new Insets(15));
        Label jugadorActual = new Label();
        jugadorActual.setText("Jugando ahora\n"+partida.obtenerJugadorActual().obtenerNombre());
        jugadorActual.setStyle("-fx-font-size: 14;");

        Button verObjetivo = new Button("Ver objetivo");
        BotonVerObjetivoHandler verObjetivoHandler= new BotonVerObjetivoHandler(partida);
        verObjetivo.setOnAction(verObjetivoHandler);
        
        this.getChildren().addAll(jugadorActual, new Separator(), verObjetivo);
        
        if (partida.esRondaDeColocacion()){
            Label numeroTropasAColocar = new Label();
            numeroTropasAColocar.setText("Tropas disponibles\n"+String.valueOf(partida.tropasDisponiblesParaColocar())+ " tropa(s)");
            numeroTropasAColocar.setStyle("-fx-font-size: 14;");
            this.getChildren().addAll(new Separator(), numeroTropasAColocar);
        }
    }
}
