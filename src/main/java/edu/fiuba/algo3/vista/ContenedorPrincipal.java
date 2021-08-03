package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
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
    
    public void refresh(){
        this.setPanelControl();
        this.setBotonera();
        this.setPanelControl();
    }

    private void setBotonera(){
        String nombreRonda = this.partida.nombreDeLaRonda();
        if (this.partida.esRondaDeColocacion()){
            this.botonera = new BotoneraRondaColocacion(this, this.partida, nombreRonda);
        }
        else if (this.partida.esRondaDeReagrupamiento()){
            this.botonera = new BotoneraRondaReagrupar(this, this.partida, nombreRonda);
        }
        else {
            this.botonera = new BotoneraRondaAtaque(this.stage, this, this.partida, nombreRonda);
        }
        this.setLeft(botonera);
    } 


    private void setPanelControl(){
        this.panelControl = new PanelDeControl(this.stage, this, this.partida);
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
