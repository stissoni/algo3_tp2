package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.RondaColocacion;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

    public ContenedorPrincipal(Stage stage, Partida partida){
        this.partida = partida;
        this.setMenu(stage);
        this.setCentro();
        this.setBotonera();
        this.setPanelControl();
    }

    private void setBotonera(){
        if (this.partida.esRondaDeColocacion()){
            this.botonera = new BotoneraRondaColocacion(this, this.partida);
        }
        else {
            this.botonera = new BotoneraRondaAtaque(this, this.partida);
        }
        this.setLeft(botonera);
    }

    public void refresh(){
        this.setPanelControl();
        this.setBotonera();
    }

    private void setPanelControl(){
        Label jugadorActual = new Label();
        jugadorActual.setText(this.partida.obtenerJugadorActual().obtenerNombre());

        this.panelControl = new VBox(jugadorActual);
        this.panelControl.setSpacing(10);
        this.panelControl.setPadding(new Insets(15));

        this.setRight(this.panelControl);
    }

    private void setMenu(Stage stage){
        this.menuBar = new BarraDeMenu(stage);
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
