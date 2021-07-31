package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.MovimientoColocacion;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonColocarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotoneraRondaColocacion extends VBox {
    public BotoneraRondaColocacion(ContenedorPrincipal contenedor, Partida partida){
        ListView<String> listaPaises = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            items.addAll(nombrePais);
        }
        listaPaises.setItems(items);
        
        TextField cantidadTropas = new TextField("3");
        cantidadTropas.setPrefWidth(40);
        cantidadTropas.setMaxWidth(40);

        Button botonColocar = new Button();
        botonColocar.setText("Colocar");
        EventHandler<ActionEvent> colocarHandler = e->{
            System.out.println("Agregando "+Integer.parseInt(cantidadTropas.getText())+" a: "+listaPaises.getSelectionModel().getSelectedItem());
            Pais paisDestino = partida.obtenerUnPais(listaPaises.getSelectionModel().getSelectedItem());
            MovimientoColocacion nuevoMovimiento = new MovimientoColocacion();
            nuevoMovimiento.destinoPais(paisDestino);
            nuevoMovimiento.numeroTropas(Integer.parseInt(cantidadTropas.getText()));
            try{
                partida.ejecutarMovimiento(nuevoMovimiento);
            }
            catch (Throwable exception){
                exception.printStackTrace();
            }
            contenedor.refresh();
        };
        botonColocar.setOnAction(colocarHandler);

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar Turno");
        BotonSiguienteTurnoEventHandler siguienteTurnoHandler = new BotonSiguienteTurnoEventHandler(contenedor, partida);
        botonTerminarTurno.setOnAction(siguienteTurnoHandler);

        this.getChildren().addAll(listaPaises, cantidadTropas, botonColocar, botonTerminarTurno);
        this.setSpacing(10);
        this.setPadding(new Insets(15));
    }
}
