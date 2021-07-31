package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("A.L.T.E.G.O");
        
        ContenedorPedirJugadores contenedorPedirJugadores = new ContenedorPedirJugadores(stage);
        Scene escenaPedirJugadores = new Scene(contenedorPedirJugadores, 640, 480);

        stage.setScene(escenaPedirJugadores);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}