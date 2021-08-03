package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.MovimientoAtaque;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorPartidaFinalizada;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import edu.fiuba.algo3.excepciones.NumeroDeTropasInsuficienteException;
import edu.fiuba.algo3.excepciones.PaisSinEjercitoException;
import edu.fiuba.algo3.modelo.GeneradorAleatorio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    ContenedorPrincipal contenedor;
    Partida partida;
    String nombrePaisConquistador;
    String nombrePaisDefensor;
    int numeroTropas;
    
    public BotonAtacarEventHandler(Stage stage, ContenedorPrincipal contenedor, Partida partida){
        this.stage = stage;
        this.contenedor = contenedor;
        this.partida = partida;
    }

    public void setPaisAtacante(String paisAtacante){
        this.nombrePaisConquistador = paisAtacante;
    }

    public void setPaisDefensor(String paisDefensor){
        this.nombrePaisDefensor = paisDefensor;
    }

    public void setNumeroTropas(int numeroTropas){
        this.numeroTropas = numeroTropas;
    }
    
    public void handle(ActionEvent actionEvent){
        Pais paisConquistador = this.partida.obtenerUnPais(this.nombrePaisConquistador);
        Pais paisDefensor = this.partida.obtenerUnPais(this.nombrePaisDefensor);
        MovimientoAtaque nuevoMovimiento = new MovimientoAtaque();
        nuevoMovimiento.paisAtacante(paisConquistador);
        nuevoMovimiento.paisDefensor(paisDefensor);
        nuevoMovimiento.numeroDeTropas(this.numeroTropas);
        nuevoMovimiento.generador(new GeneradorAleatorio());
        try{
            partida.ejecutarMovimiento(nuevoMovimiento);
            if (this.partida.ganoLaPartida(this.partida.obtenerJugadorActual())){
                ContenedorPartidaFinalizada contenedorPartidaFinalizada = new ContenedorPartidaFinalizada(this.stage, this.partida);
                Scene ultimaEscena = new Scene(contenedorPartidaFinalizada, 640, 480);
        
                stage.setScene(ultimaEscena);
                stage.setFullScreenExitHint("");
                stage.setFullScreen(false);
                return;
            }
            nuevoMovimiento.entregarCarta(this.partida.obtenerMazo());
            contenedor.refresh();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("RESULTADO TIRADA");
            String alertText =(
                String.format("Batalla entre %s y %s", this.nombrePaisConquistador, this.nombrePaisDefensor)
            );
            alert.setHeaderText(alertText);
            String mensaje = (
                String.format("Victoria de %s\nResultado de las tiradas\n%s", nuevoMovimiento.obtenerGanador().obtenerNombrePais(),nuevoMovimiento.obtenerTiradas())
            );
            alert.setContentText(mensaje);
            alert.show();
        }
        catch (NumeroDeTropasInsuficienteException exceptionTropasInsuficientes){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ALERTA");
            alert.setHeaderText("¡No hay tropas suficentes para el ataque!");
            String mensaje = this.nombrePaisConquistador+ " ataca a " +this.nombrePaisDefensor+" con "+this.numeroTropas+ " tropa(s) pero solo dispone de "+ paisConquistador.obtenerNumeroTotalDeTropas() +" tropa(s)"; 
            alert.setContentText(mensaje);
            alert.show();
        }
        catch(PaisSinEjercitoException exceptionSinTropas){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ALERTA");
            alert.setHeaderText("¡Debe quedar por lo menos una tropa en el pais!");
            String mensaje;
            int numeroTropasEnElPaisAtacante = this.partida.obtenerUnPais(this.nombrePaisConquistador).obtenerNumeroTotalDeTropas();
            if (numeroTropasEnElPaisAtacante - 1 <= 0){
                mensaje = "Este pais no puede realizar ataques";
            }
            else {
                mensaje = "Puedes atacar con maximo "+(numeroTropasEnElPaisAtacante-1)+" tropa(s)";
            }
            alert.setContentText(mensaje);
            alert.show();
        }
        catch (Throwable exception2){
            exception2.printStackTrace();
        }
        contenedor.refresh();
    }
}
