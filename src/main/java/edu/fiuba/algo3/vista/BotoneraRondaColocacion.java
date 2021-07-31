package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.excepciones.NoSePermiteColocarEseNumeroDeTropasException;
import edu.fiuba.algo3.modelo.MovimientoColocacion;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class BotoneraRondaColocacion extends VBox {
    public BotoneraRondaColocacion(ContenedorPrincipal contenedor, Partida partida){
        ListView<String> listaPaises = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            String cantidadTropas = String.valueOf(pais.obtenerNumeroTotalDeTropas());
            String dato = nombrePais+ " ("+cantidadTropas+")";
            items.addAll(dato);
        }
        listaPaises.setItems(items);
        BotonColocarEventHandler colocarHandler = new BotonColocarEventHandler(contenedor, partida);
        
        listaPaises.getSelectionModel().selectedItemProperty().addListener(new javafx.beans.value.ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                String nombrePais = listaPaises.getSelectionModel().getSelectedItem();
                String[] splited = nombrePais.split("\\s+");
                nombrePais = splited[0];
                colocarHandler.setNombrePais(nombrePais);
                System.out.println("Pais destino changed " + oldValue + " to " + newValue);
            }
        });
        
        TextField cantidadTropas = new TextField();
        cantidadTropas.setPrefWidth(40);
        cantidadTropas.setMaxWidth(40);
        cantidadTropas.textProperty().addListener(
            (observable, oldValue, newValue)->{
                colocarHandler.setNumeroTropas(Integer.parseInt(newValue));
                System.out.println("Numero tropas changed from " + oldValue + " to " + newValue);
            }
        );

        Button botonColocar = new Button();
        botonColocar.setText("Colocar");
        botonColocar.setOnAction(colocarHandler);

        /*
        EventHandler<ActionEvent> colocarHandler = e->{
            System.out.println("Agregando "+Integer.parseInt(cantidadTropas.getText())+" a: "+listaPaises.getSelectionModel().getSelectedItem());
            String nombrePais = listaPaises.getSelectionModel().getSelectedItem();
            String[] splited = nombrePais.split("\\s+");
            nombrePais = splited[0];

            Pais paisDestino = partida.obtenerUnPais(nombrePais);
            MovimientoColocacion nuevoMovimiento = new MovimientoColocacion();
            nuevoMovimiento.destinoPais(paisDestino);
            nuevoMovimiento.numeroTropas(Integer.parseInt(cantidadTropas.getText()));
            try{
                partida.ejecutarMovimiento(nuevoMovimiento);
            }
            catch (NoSePermiteColocarEseNumeroDeTropasException exception){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("ALERTA");
                alert.setHeaderText("¡No se puede colocar ese numero de tropas!");
                String mensaje = exception.getMessage();
                alert.setContentText(mensaje);
                alert.show();
            }
            catch (Throwable exception2){
                exception2.printStackTrace();
            }
            contenedor.refresh();
        };
        */

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar Turno");
        BotonSiguienteTurnoEventHandler siguienteTurnoHandler = new BotonSiguienteTurnoEventHandler(contenedor, partida);
        botonTerminarTurno.setOnAction(siguienteTurnoHandler);

        this.getChildren().addAll(listaPaises, cantidadTropas, botonColocar, botonTerminarTurno);
        this.setSpacing(10);
        this.setPadding(new Insets(15));
    }
}
