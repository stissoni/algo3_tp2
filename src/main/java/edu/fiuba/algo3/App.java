package edu.fiuba.algo3;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setResizable(true);
        stage.setTitle("A.L.T.E.G.O");
        stage.setScene(pantallaDeBienvenida(stage));
        stage.show();
    }

    public Scene pantallaDeBienvenida(Stage stage){
        var mensajeTitulo = new Label("A.L.T.E.G.O");
        mensajeTitulo.setStyle("-fx-font: 26 arial; -fx-font-weight: bold");
        mensajeTitulo.setTranslateY(-30);

        Button botonInicio = new Button("Nueva partida");
        botonInicio.setTranslateY(40);
        botonInicio.setStyle("-fx-font: 18 arial; -fx-border-color: #000000;");

        final App self = this;
        botonInicio.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                self.pedirJugadores(stage);
            }
        });

        StackPane panelBienvenida = new StackPane(mensajeTitulo, botonInicio);
        return new Scene(panelBienvenida, 500, 300);
    }

    public void pedirJugadores(Stage stage){
        var mensajeTitulo = new Label("Bienvenido a A.L.T.E.G.O");
        mensajeTitulo.setStyle("-fx-font: 24 arial;");
        mensajeTitulo.setTranslateY(-100);

        var mensajeCantidadJugadores = new Label("Numero de jugadores");
        mensajeCantidadJugadores.setStyle("-fx-font: 18 arial;");
        mensajeCantidadJugadores.setTranslateY(-35);

        Button botonInicio = new Button("Iniciar");
        botonInicio.setTranslateY(50);
        botonInicio.setStyle("-fx-font: 18 arial; -fx-border-color: #000000;");

        TextField cantidadJugadores = new TextField("2");
        cantidadJugadores.setTranslateY(0);
        cantidadJugadores.setPrefWidth(80);
        cantidadJugadores.setMaxWidth(80);

        StackPane panelBienvenida = new StackPane(mensajeTitulo, mensajeCantidadJugadores, cantidadJugadores, botonInicio);
        stage.setScene(new Scene(panelBienvenida, 500, 300));
    }

    public static void main(String[] args) {
        launch();
    }

}