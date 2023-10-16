package es.ieslosmontecillos.appsondeos;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Home extends VBox {

    //Creating elements variables
    Label lblTitle = new Label("Inicio");
    Button btnAbout = new Button("Creditos");

    FileInputStream imginput = new FileInputStream("src/main/resources/assets/images/gamma.jpg");
    Image imglogo = new Image(imginput);
    ImageView imgViewLogo = new ImageView(imglogo);

    Label lblSepu = new Label("Salvador Sepúlveda Millán");
    Label lblThiago = new Label("Thiago Vignolo Ferreira");
    Label lblAdrian = new Label("Adrian Gonzalez García");
    Label lblMiguel = new Label("Miguel Gil Nebro");

    public Home() throws FileNotFoundException {
        super();
        //Set aligment
        this.setAlignment(Pos.TOP_CENTER);

        //Add elements to layout (old, done with GridPane)

        //this.setConstraints(lblTitle, 1, 0);
        //this.setConstraints(imgLogo, 2, 1);
        //this.setConstraints(btnAbout, 3, 2);
        //this.getChildren().add(lblTitle);
        //this.getChildren().add(imgLogo);
        //this.getChildren().add(btnAbout);

        //Add elements to layout (done with Vbox)
        this.getChildren().addAll(lblTitle,imgViewLogo,btnAbout);


        //Button Event
        btnAbout.setOnAction(event -> {
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
        });

    }



}