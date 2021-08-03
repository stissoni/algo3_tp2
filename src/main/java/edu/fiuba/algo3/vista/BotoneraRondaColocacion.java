package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotoneraRondaColocacion extends VBox {
    public BotoneraRondaColocacion(ContenedorPrincipal contenedor, Partida partida, String nombreRonda){
        Label nombreDeLaRonda = new Label(nombreRonda);
        nombreDeLaRonda.setStyle("-fx-font-size: 16");
        Label paisesParaColocar = new Label("Paises para colocar");
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
        
        listaPaises.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue)->{
                String nombrePais = listaPaises.getSelectionModel().getSelectedItem();
                String[] splited = nombrePais.split("\\s+");
                nombrePais = splited[0];
                colocarHandler.setNombrePais(nombrePais);
                System.out.println("Pais destino changed " + oldValue + " to " + newValue);
            }
        );
        
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

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar Turno");
        BotonSiguienteTurnoEventHandler siguienteTurnoHandler = new BotonSiguienteTurnoEventHandler(contenedor, partida);
        botonTerminarTurno.setOnAction(siguienteTurnoHandler);

        this.getChildren().addAll(
            nombreDeLaRonda,
            paisesParaColocar,
            listaPaises,
            cantidadTropas,
            botonColocar,
            botonTerminarTurno);
        this.setSpacing(10);
        this.setPadding(new Insets(15));
    }
}
