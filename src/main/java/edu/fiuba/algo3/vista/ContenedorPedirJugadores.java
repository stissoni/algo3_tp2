package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.eventos.BotonIniciarPartidaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPedirJugadores extends VBox{
    Stage stage;

    public ContenedorPedirJugadores(Stage stage){
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label mensajeTitulo = new Label("Bienvenido a A.L.T.E.G.O");
        mensajeTitulo.setStyle("-fx-font: 24 arial;");
        mensajeTitulo.setTranslateY(-100);

        Label mensajeCantidadJugadores = new Label("Numero de jugadores");
        mensajeCantidadJugadores.setStyle("-fx-font: 18 arial;");
        mensajeCantidadJugadores.setTranslateY(-20);
        
        TextField cantidadJugadores = new TextField();
        cantidadJugadores.setPrefWidth(80);
        cantidadJugadores.setMaxWidth(80);

        Button botonIniciarPartida = new Button("Iniciar");
        botonIniciarPartida.setTranslateY(50);
        botonIniciarPartida.setStyle("-fx-font: 18 arial; -fx-border-color: #000000;");
        BotonIniciarPartidaEventHandler iniciarPartidaEventHandler = new BotonIniciarPartidaEventHandler(stage);
        
        cantidadJugadores.textProperty().addListener(
            (observable, oldValue, newValue)->{
                iniciarPartidaEventHandler.setNumeroJugadores(Integer.parseInt(newValue));
                System.out.println("textfield changed from " + oldValue + " to " + newValue);
            }
        );

        /*
        EventHandler<ActionEvent> iniciarPartidaEventHandler = e -> {
            this.iniciarPartida(Integer.parseInt(cantidadJugadores.getText()));

            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, this.partida);
            Scene proximaEscena = new Scene(contenedorPrincipal, 640, 480);
            stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(false);
        };

        /* 
        Parece que para crear el objeto tiene que usar si o si el valor del campo textfield.
        Esta solucion esta mejor porque encapsula la creacion de la partida en el controlador.
        Pero no funciona :(
        BotonIniciarPartidaEventHandler iniciarPartidaEventHandler = new BotonIniciarPartidaEventHandler(stage, Integer.parseInt(cantidadJugadores.getText()));
        */

        botonIniciarPartida.setOnAction(iniciarPartidaEventHandler);

        this.getChildren().addAll(
            mensajeTitulo,
            mensajeCantidadJugadores,
            cantidadJugadores,
            botonIniciarPartida
        );

    }

}
