package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.MovimientoAtaque;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotoneraRondaAtaque extends VBox{
    public BotoneraRondaAtaque(ContenedorPrincipal contenedor, Partida partida){
        Label labelPaisAtacante = new Label("Pais atacante");
        ListView<String> listaPaisesEnControl = new ListView<String>();
        ObservableList<String> itemsPaisesEnControl = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            itemsPaisesEnControl.addAll(nombrePais);
        }
        listaPaisesEnControl.setItems(itemsPaisesEnControl);

        Label labelPaisAAtacar = new Label("Pais a atacar");
        ListView<String> listaPaisesParaAtacar = new ListView<String>();
        ObservableList<String> itemsPaisesParaAtacar = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesNoDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            itemsPaisesParaAtacar.addAll(nombrePais);
        }
        listaPaisesParaAtacar.setItems(itemsPaisesParaAtacar);
        
        Label labelCantidadDeTropas = new Label("Cantidad de tropas");
        TextField cantidadTropas = new TextField("3");
        cantidadTropas.setPrefWidth(40);
        cantidadTropas.setMaxWidth(40);

        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        EventHandler<ActionEvent> atacarHandler = e->{
            Pais paisAtacante = partida.obtenerUnPais(listaPaisesEnControl.getSelectionModel().getSelectedItem());
            Pais paisDefensor = partida.obtenerUnPais(listaPaisesParaAtacar.getSelectionModel().getSelectedItem());
            MovimientoAtaque nuevoMovimiento = new MovimientoAtaque();
            nuevoMovimiento.paisAtacante(paisAtacante);
            nuevoMovimiento.paisDefensor(paisDefensor);
            nuevoMovimiento.numeroDeTropas(Integer.parseInt(cantidadTropas.getText()));
            try{
                partida.ejecutarMovimiento(nuevoMovimiento);
            }
            catch (Throwable exception){
                exception.printStackTrace();
            }
            contenedor.refresh();
        };
        botonAtacar.setOnAction(atacarHandler);

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar Turno");
        BotonSiguienteTurnoEventHandler siguienteTurnoHandler = new BotonSiguienteTurnoEventHandler(contenedor, partida);
        botonTerminarTurno.setOnAction(siguienteTurnoHandler);

        this.getChildren().addAll(
            labelPaisAtacante,
            listaPaisesParaAtacar,
            labelPaisAAtacar,
            listaPaisesEnControl,
            labelCantidadDeTropas,
            cantidadTropas,
            botonAtacar,
            botonTerminarTurno
        );
        this.setSpacing(10);
        this.setPadding(new Insets(15));
    }
}
