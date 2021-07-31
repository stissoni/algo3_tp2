package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.excepciones.NoSePermiteColocarEseNumeroDeTropasException;
import edu.fiuba.algo3.modelo.MovimientoColocacion;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonColocarEventHandler implements EventHandler<ActionEvent> {
    private ContenedorPrincipal contenedor;
    private String nombrePais;
    private int numeroTropas;
    private Partida partida;

    public BotonColocarEventHandler(ContenedorPrincipal contenedor, Partida partida){
        this.contenedor = contenedor;
        this.partida = partida;
    }

    public void setNombrePais(String nombrePais){
        this.nombrePais = nombrePais;
    }

    public void setNumeroTropas(int numeroTropas){
        this.numeroTropas = numeroTropas;
    }

    public void handle(ActionEvent actionEvent){
        System.out.println("Agregando "+this.numeroTropas+"a: "+this.nombrePais);
        Pais paisDestino = this.partida.obtenerUnPais(this.nombrePais);
        MovimientoColocacion nuevoMovimiento = new MovimientoColocacion();
        nuevoMovimiento.destinoPais(paisDestino);
        nuevoMovimiento.numeroTropas(this.numeroTropas);
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
    }
}
