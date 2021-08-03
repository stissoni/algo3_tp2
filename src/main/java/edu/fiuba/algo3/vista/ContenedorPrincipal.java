package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ObjetivoConquista;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
    Partida partida;
    BarraDeMenu menuBar;
    VBox botonera;
    VBox panelControl;
    VBox contenedorCentral;
    Stage stage;

    public ContenedorPrincipal(Stage stage, Partida partida){
        this.partida = partida;
        this.stage = stage;
        this.setMenu();
        this.setCentro();
        this.setBotonera();
        this.setPanelControl();
    }

    private void setBotonera(){
        if (this.partida.esRondaDeColocacion()){
            this.botonera = new BotoneraRondaColocacion(this, this.partida);
        }
        else if (this.partida.esRondaDeReagrupamiento()){
            this.botonera = new BotoneraRondaReagrupar(this, this.partida);
        }
        else {
            this.botonera = new BotoneraRondaAtaque(this.stage, this, this.partida);
        }
        this.setLeft(botonera);
    } 

    public void refresh(){
        this.setPanelControl();
        this.setBotonera();
        this.setPanelControl();
    }

    private void setPanelControl(){
        Label jugadorActual = new Label();
        jugadorActual.setText("Jugando ahora\n"+this.partida.obtenerJugadorActual().obtenerNombre());
        jugadorActual.setStyle("-fx-font: 18 arial;");
        this.panelControl = new VBox();
        this.panelControl.setSpacing(10);
        this.panelControl.setPadding(new Insets(15));

        Label objetivoDelJugador = new Label();
        ObjetivoConquista objetivo = this.partida.obtenerJugadorActual().obtenerObjetivo();
        objetivoDelJugador.setText(objetivo.descripcionDelObjetivo());

        if (this.partida.esRondaDeColocacion()){
            Label numeroTropasAColocar = new Label();
            numeroTropasAColocar.setText(String.valueOf(this.partida.tropasDisponiblesParaColocar())+ " tropa(s)");
            Label tropasDisponibles = new Label("Tropas disponibles");
            tropasDisponibles.setStyle("-fx-font: 18 arial;");
            numeroTropasAColocar.setStyle("-fx-font: 18 arial;");
            this.panelControl.getChildren().addAll(jugadorActual, tropasDisponibles, numeroTropasAColocar, objetivoDelJugador);
        }
        else {
            this.panelControl.getChildren().addAll(jugadorActual, objetivoDelJugador);
        }
        this.setRight(this.panelControl);
    }

    private void setMenu(){
        this.menuBar = new BarraDeMenu(this.stage);
        this.setTop(this.menuBar);
    }

    private void setCentro(){
        this.contenedorCentral = new VBox();
        this.contenedorCentral.setAlignment(Pos.CENTER);
        this.contenedorCentral.setSpacing(20);
        this.contenedorCentral.setPadding(new Insets(25));

        Image imagen = new Image("file:src/data/tablero.png");
        BackgroundImage imagenFondo = new BackgroundImage(
            imagen,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT
        );
        this.contenedorCentral.setBackground(new Background(imagenFondo));

        this.setCenter(this.contenedorCentral);
    }

    public BarraDeMenu getBarraDeMenu(){
        return this.menuBar;
    }
}
