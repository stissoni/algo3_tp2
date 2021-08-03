package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIniciarPartidaEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    int numeroJugadores;

    public BotonIniciarPartidaEventHandler(Stage stage){
        this.stage = stage;
    }

    public void setNumeroJugadores(int numeroJugadores){
        this.numeroJugadores = numeroJugadores;
    }
    
    public void handle(ActionEvent actionEvent){
        System.out.println("Iniciando partida de "+this.numeroJugadores+" jugadores");
        Partida nuevaPartida = this.iniciarPartida(this.numeroJugadores);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, nuevaPartida);
        Scene proximaEscena = new Scene(contenedorPrincipal, 1080, 720);
        
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }

    private Partida iniciarPartida(int cantidadJugadores){
        Partida partida = new Partida();
        try {
            partida.crearMapa();
            for (int i = 0; i < cantidadJugadores; i++){
                // Pedir nombre de jugadores
                String nombre = "Jugador " + (i+1);
                Jugador nuevoJugador = new Jugador(nombre, i);
                partida.agregarJugador(nuevoJugador);
            }
            GeneradorAleatorio generador = new GeneradorAleatorio();
            int jugadorInicial = generador.generar(0, cantidadJugadores);
            partida.jugadorInicial(jugadorInicial);
            partida.iniciarPartida();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        return partida;
    }
}
