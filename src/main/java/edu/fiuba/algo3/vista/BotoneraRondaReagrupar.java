package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonReagruparEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotoneraRondaReagrupar extends VBox {
    public BotoneraRondaReagrupar(ContenedorPrincipal contenedor, Partida partida){
        Label labelPaisOrigen = new Label("Pais origen (numero de tropas)");
            
        ListView<String> listaPaisesEnControl = new ListView<String>();
        ObservableList<String> itemsPaisesEnControl = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            String cantidadTropas = String.valueOf(pais.obtenerNumeroTotalDeTropas());
            String dato = String.format("%s (%s)", nombrePais, cantidadTropas);
            itemsPaisesEnControl.addAll(dato);
        }
        listaPaisesEnControl.setItems(itemsPaisesEnControl);

        Label labelPaiDestino= new Label("Pais destino (numero de tropas)");
        
        ListView<String> listaPaisesParaDestinarTropas = new ListView<String>();
        //ObservableList<String> itemsPaisesParaDestinarTropas = FXCollections.observableArrayList();
        //listaPaisesParaDestinarTropas.setItems(itemsPaisesParaDestinarTropas);

        Label labelCantidadDeTropas = new Label("Cantidad de tropas");
        TextField cantidadTropas = new TextField();
        cantidadTropas.setPrefWidth(40);
        cantidadTropas.setMaxWidth(40);

        Button botonTransferir = new Button();
        botonTransferir.setText("Transferir tropas");
        BotonReagruparEventHandler transferirHandler = new BotonReagruparEventHandler(contenedor, partida);
        botonTransferir.setOnAction(transferirHandler);

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar Turno");
        BotonSiguienteTurnoEventHandler siguienteTurnoHandler = new BotonSiguienteTurnoEventHandler(contenedor, partida);
        botonTerminarTurno.setOnAction(siguienteTurnoHandler);

        // Set listeners.
        cantidadTropas.textProperty().addListener(
            (observable, oldValue, newValue)->{
                transferirHandler.setNumeroTropas(Integer.parseInt(newValue));
            }
        );
        listaPaisesEnControl.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue)->{
                String[] splited = newValue.split("\\s+");
                String nombrePaisAtacante = splited[0];
                transferirHandler.setPaisOrigen(nombrePaisAtacante);

                ObservableList<String> itemsPaisesLimitrofesParaTransferir = FXCollections.observableArrayList();
                for (Pais pais: partida.obtenerPaisesLimitrofesDe(nombrePaisAtacante, partida.obtenerJugadorActual())){
                    String nombrePaisDelLimitrofe = pais.obtenerNombrePais();
                    System.out.println(nombrePaisDelLimitrofe);
                    String cantidadTropasDelLimitrofe = String.valueOf(pais.obtenerNumeroTotalDeTropas());
                    String dato = String.format("%s (%s)", nombrePaisDelLimitrofe, cantidadTropasDelLimitrofe);
                    itemsPaisesLimitrofesParaTransferir.addAll(dato);
                }
                listaPaisesParaDestinarTropas.setItems(itemsPaisesLimitrofesParaTransferir);
            }
        );
        listaPaisesParaDestinarTropas.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue)->{
                String[] splited = newValue.split("\\s+");
                String nombrePaisDefensor = splited[0];
                transferirHandler.setPaisDestino(nombrePaisDefensor);
            }
        );

        this.getChildren().addAll(
            labelPaisOrigen,
            listaPaisesEnControl,
            labelPaiDestino,
            listaPaisesParaDestinarTropas,
            labelCantidadDeTropas,
            cantidadTropas,
            botonTransferir,
            botonTerminarTurno
        );
        this.setSpacing(10);
        this.setPadding(new Insets(15));
    }
}
