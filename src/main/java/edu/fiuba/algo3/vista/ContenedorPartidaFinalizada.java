package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPartidaFinalizada extends VBox{
    Stage stage;

    public ContenedorPartidaFinalizada(Stage stage, Partida partida){
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label mensajeTitulo = new Label("¡Tenemos un ganador!");
        mensajeTitulo.setStyle("-fx-font: 24 arial;");
        mensajeTitulo.setTranslateY(-100);

        Label mensajeCantidadJugadores = new Label("El ganador es el jugador "+partida.obtenerGanador().obtenerNombre());
        mensajeCantidadJugadores.setStyle("-fx-font: 18 arial;");

        Button botonSalir = new Button("Salir");
        OpcionSalirEventHandler salirHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(salirHandler);

        this.getChildren().addAll(
            mensajeTitulo,
            mensajeCantidadJugadores,
            botonSalir
        );
    }
}
