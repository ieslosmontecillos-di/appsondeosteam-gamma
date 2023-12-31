/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ieslosmontecillos.appsondeos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.io.FileNotFoundException;
import java.util.Objects;

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
        vBox.setPadding(new Insets(5));

        Scene scene = new Scene(vBox, 450, 800);
        
        primaryStage.setTitle("AppSondeos");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(AppSondeos.class.getResource("/assets/styles/main.css")).toExternalForm());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
