package es.ieslosmontecillos.appsondeos;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Travel extends GridPane {

    //Creating elements variables
    Label lblTitle = new Label("Inicio");

    public Travel() {
        super();
        //Set aligment
        this.setAlignment(Pos.TOP_CENTER);

        //Add elements to layout
        this.setConstraints(lblTitle, 1, 0);

        this.getChildren().add(lblTitle);


    }

}