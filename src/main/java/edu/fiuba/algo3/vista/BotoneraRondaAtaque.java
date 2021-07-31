package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.excepciones.NumeroDeTropasInsuficienteException;
import edu.fiuba.algo3.modelo.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.MovimientoAtaque;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.eventos.BotonSiguienteTurnoEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class BotoneraRondaAtaque extends VBox{
    public BotoneraRondaAtaque(ContenedorPrincipal contenedor, Partida partida){
        Label labelPaisAtacante = new Label("Pais atacante (numero de tropas)");
        ListView<String> listaPaisesEnControl = new ListView<String>();
        ObservableList<String> itemsPaisesEnControl = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesDe(partida.obtenerJugadorActual())){
            try{
                String nombrePais = pais.obtenerNombrePais();
                String cantidadTropas = String.valueOf(pais.obtenerNumeroTotalDeTropas());
                String dato = nombrePais+ " ("+cantidadTropas+")";
                itemsPaisesEnControl.addAll(dato);
            }
            catch (Throwable e){
                e.printStackTrace();
            }
        }
        listaPaisesEnControl.setItems(itemsPaisesEnControl);

        Label labelPaisAAtacar = new Label("Pais a atacar (numero de tropas)");
        ListView<String> listaPaisesParaAtacar = new ListView<String>();
        ObservableList<String> itemsPaisesParaAtacar = FXCollections.observableArrayList();
        for (Pais pais: partida.obtenerPaisesNoDe(partida.obtenerJugadorActual())){
            String nombrePais = pais.obtenerNombrePais();
            String cantidadTropas = String.valueOf(pais.obtenerNumeroTotalDeTropas());
            String dato = nombrePais+ " ("+cantidadTropas+")";
            itemsPaisesParaAtacar.addAll(dato);
        }
        listaPaisesParaAtacar.setItems(itemsPaisesParaAtacar);
        
        Label labelCantidadDeTropas = new Label("Cantidad de tropas");
        TextField cantidadTropas = new TextField("3");
        cantidadTropas.setPrefWidth(40);
        cantidadTropas.setMaxWidth(40);

        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        EventHandler<ActionEvent> atacarHandler = e->{
            String nombrePaisAtacante = listaPaisesEnControl.getSelectionModel().getSelectedItem();
            String[] splited = nombrePaisAtacante.split("\\s+");
            nombrePaisAtacante = splited[0];
            Pais paisAtacante = partida.obtenerUnPais(nombrePaisAtacante);
            
            String nombrePaisDefensor = listaPaisesParaAtacar.getSelectionModel().getSelectedItem();
            splited = nombrePaisDefensor.split("\\s+");
            nombrePaisDefensor = splited[0];
            Pais paisDefensor = partida.obtenerUnPais(nombrePaisDefensor);
            int numeroTropasPaisDefensor = paisDefensor.obtenerNumeroTotalDeTropas();

            MovimientoAtaque nuevoMovimiento = new MovimientoAtaque();
            nuevoMovimiento.paisAtacante(paisAtacante);
            nuevoMovimiento.paisDefensor(paisDefensor);
            nuevoMovimiento.numeroDeTropas(Integer.parseInt(cantidadTropas.getText()));
            nuevoMovimiento.generador(new GeneradorAleatorio());
            System.out.println(nombrePaisAtacante+" ATACA A: "+nombrePaisDefensor+" CON "+cantidadTropas.getText());
            try{
                partida.ejecutarMovimiento(nuevoMovimiento);
                // MOSTRAR RESULTADO TIRADA
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("RESULTADO TIRADA");
                String alertText = "Batalla entre "+
                    nombrePaisAtacante+ " ("+cantidadTropas.getText()+")"+
                    " y "+
                    nombrePaisDefensor+ " ("+numeroTropasPaisDefensor+")";
                alert.setHeaderText(alertText);
                String mensaje = "Victoria de " + 
                    nuevoMovimiento.obtenerGanador().obtenerNombrePais()+ 
                    "\nResultado de las tiradas\n"+
                    nuevoMovimiento.obtenerTiradas();
                alert.setContentText(mensaje);
                alert.show();
            }
            catch (NumeroDeTropasInsuficienteException exception){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("ALERTA");
                alert.setHeaderText("¡No hay tropas suficentes para el ataque!");
                String mensaje = nombrePaisAtacante+ " ataca a " + nombrePaisDefensor+" con "+cantidadTropas.getText()+ " tropa(s) pero solo dispone de "+ paisAtacante.obtenerNumeroTotalDeTropas() +" tropa(s)"; 
                alert.setContentText(mensaje);
                alert.show();
            }
            catch (Throwable exception2){
                exception2.printStackTrace();
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
