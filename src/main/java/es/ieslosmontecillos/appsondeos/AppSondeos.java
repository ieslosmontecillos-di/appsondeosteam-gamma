/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ieslosmontecillos.appsondeos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class AppSondeos extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        //Instanciar clases
        Home home = new Home();
        Sport sport = new Sport();
        Animals animals = new Animals();
        Food food = new Food();
        Travel travel = new Travel();
        Reading reading = new Reading();

        TabPane tabPane = new TabPane();

        //Creacion de las distintas pestañas
        Tab TabHome = new Tab("Home", home);
        Tab TabSport = new Tab("Deporte", sport);
        Tab TabAnimals = new Tab("Animales", animals);
        Tab TabFood = new Tab("Comida", food);
        Tab TabTravel = new Tab("Viajes", travel);
        Tab TabReding = new Tab("Lectura", reading);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //asignacion de las pestañas al elemento visual tabPane
        tabPane.getTabs().add(TabHome);
        tabPane.getTabs().add(TabSport);
        tabPane.getTabs().add(TabAnimals);
        tabPane.getTabs().add(TabFood);
        tabPane.getTabs().add(TabTravel);
        tabPane.getTabs().add(TabReding);


        VBox vBox = new VBox(tabPane);

        Scene scene = new Scene(vBox, 400, 700);
        
        primaryStage.setTitle("AppSondeos");
        primaryStage.setScene(scene);
        //impide ajustar la ventana al tamaño que queramos
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
