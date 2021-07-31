package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.eventos.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.vista.eventos.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {
    public BarraDeMenu(Stage stage){
        Menu menuArchivo = new Menu("Archivo");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionAcerdaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler salirEventHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(salirEventHandler);

        OpcionAcercaDeEventHandler acercaDeEventHandler = new OpcionAcercaDeEventHandler();
        opcionAcerdaDe.setOnAction(acercaDeEventHandler);

        menuArchivo.getItems().addAll(opcionAbrir, new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcerdaDe);

        this.getMenus().addAll(menuArchivo, menuAyuda);
    }
}
