package es.ieslosmontecillos.appsondeos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Sport extends GridPane {

    //Creating elements variables
    Label lblTitle = new Label("Inicio");

    public Sport() {
        super();
        //Set aligment
        this.setAlignment(Pos.TOP_CENTER);

        //Add elements to layout
        this.setConstraints(lblTitle, 1, 0);

        this.getChildren().add(lblTitle);


    }

}