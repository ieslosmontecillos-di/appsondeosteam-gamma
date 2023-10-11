package es.ieslosmontecillos.appsondeos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Home extends GridPane {

    //Creating elements variables
    Label lblTitle = new Label("Inicio");
    Button btnAbout = new Button("Creditos");
    //Image imglogo = new Image("assets/images/gamma.jpg");
    Label lblSepu = new Label("Salvador");
    Label lblThiago = new Label("Thiago");
    Label lblAdrian = new Label("Adrian");
    Label lblMiguel = new Label("Miguel Gil Nebro");

    public Home() {
        super();
        //Set aligment
        this.setAlignment(Pos.TOP_CENTER);

        //Style
        //ImageView imgLogo = new ImageView(imglogo);

        //Add elements to layout
        this.setConstraints(lblTitle, 1, 0);
        //this.setConstraints(imgLogo, 2, 1);
        this.setConstraints(btnAbout, 3, 1);
        this.getChildren().add(lblTitle);
        //this.getChildren().add(imgLogo);
        this.getChildren().add(btnAbout);

        //Button Event
        btnAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Creating Stage, VBox and Scene
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UTILITY);
                VBox vbox = new VBox(lblSepu,lblThiago,lblAdrian,lblMiguel);
                vbox.setAlignment(Pos.CENTER);
                Scene pagina = new Scene(vbox, 400, 150);
                //Modality
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(pagina);
                stage.show();
            }

        });

    }



}