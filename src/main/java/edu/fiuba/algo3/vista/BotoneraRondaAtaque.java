package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonAtacarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotoneraRondaAtaque extends VBox{
    public BotoneraRondaAtaque(ContenedorPrincipal contenedor, Partida partida){
        Label labelPaisAtacante = new Label("Pais atacante (numero de tropas)");
        
        ListView<String> listaPaisesEnControl = new ListView<String>();
        ObservableList<String> itemsPaisesEnControl = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            String cantidadTropas = String.valueOf(pais.obtenerNumeroTotalDeTropas());
            String dato = String.format("%s (%s)", nombrePais, cantidadTropas);
            itemsPaisesEnControl.addAll(dato);
        }
        listaPaisesEnControl.setItems(itemsPaisesEnControl);

        Label labelPaisAAtacar = new Label("Pais a atacar (numero de tropas)");
        
        ListView<String> listaPaisesParaAtacar = new ListView<String>();
        ObservableList<String> itemsPaisesParaAtacar = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesNoDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            String cantidadTropas = String.valueOf(pais.obtenerNumeroTotalDeTropas());
            String dato = String.format("%s (%s)", nombrePais, cantidadTropas);
            itemsPaisesParaAtacar.addAll(dato);
        }
        listaPaisesParaAtacar.setItems(itemsPaisesParaAtacar);

        Label labelCantidadDeTropas = new Label("Cantidad de tropas");
        TextField cantidadTropas = new TextField();
        cantidadTropas.setPrefWidth(40);
        cantidadTropas.setMaxWidth(40);

        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        BotonAtacarEventHandler atacarHandler = new BotonAtacarEventHandler(contenedor, partida);
        botonAtacar.setOnAction(atacarHandler);

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar Turno");
        BotonSiguienteTurnoEventHandler siguienteTurnoHandler = new BotonSiguienteTurnoEventHandler(contenedor, partida);
        botonTerminarTurno.setOnAction(siguienteTurnoHandler);

        // Set listeners.
        cantidadTropas.textProperty().addListener(
            (observable, oldValue, newValue)->{
                atacarHandler.setNumeroTropas(Integer.parseInt(newValue));
            }
        );
        listaPaisesEnControl.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue)->{
                String[] splited = newValue.split("\\s+");
                String nombrePaisAtacante = splited[0];
                atacarHandler.setPaisAtacante(nombrePaisAtacante);
            }
        );
        listaPaisesParaAtacar.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue)->{
                String[] splited = newValue.split("\\s+");
                String nombrePaisDefensor = splited[0];
                atacarHandler.setPaisDefensor(nombrePaisDefensor);
            }
        );

        this.getChildren().addAll(
            labelPaisAtacante,
            listaPaisesEnControl,
            labelPaisAAtacar,
            listaPaisesParaAtacar,
            labelCantidadDeTropas,
            cantidadTropas,
            botonAtacar,
            botonTerminarTurno
        );
        this.setSpacing(10);
        this.setPadding(new Insets(15));
    }
}
