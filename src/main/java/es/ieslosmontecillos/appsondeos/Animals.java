package es.ieslosmontecillos.appsondeos;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Animals extends VBox {

    //Title
    Text AnimalsTitle;

    //First Question
    Label lbFirstQue;
    HBox hbFirstQue;
    RadioButton rbFirstQueYes;
    RadioButton rbFirstQueNo;
    ToggleGroup tgFirstQue;

    //Second Question
    Label lbSecondQue;
    HBox hbSecondQue;
    RadioButton rbSecondQue1;
    RadioButton rbSecondQue2;
    RadioButton rbSecondQue3;
    RadioButton rbSecondQueM3;
    ToggleGroup tgSecondQue;

    //Third Question
    Label lbThirdQue;
    HBox hbThirdQue;
    CheckBox cbThirdQueAd;
    CheckBox cbThirdQueCo;
    CheckBox cbThirdQueRe;
    ArrayList<CheckBox> alThirdQue = new ArrayList<>();

    //Forth Question
    Label lbForthQue;
    CheckBox cbForthQueUm;
    CheckBox cbForthQueUa;
    CheckBox cbForthQueN;
    CheckBox cbForthQueDa;
    CheckBox cbForthQueE;
    TextField tfForthQueOther;
    ArrayList<CheckBox> alForthQue = new ArrayList<>();

    //Fifth Question
    Label lbFifthQue;
    HBox hbFifthQue;
    CheckBox chFifthQuePa;
    CheckBox chFifthQueHo;
    CheckBox chFifthQueLi;
    TextField tfFifthQueOther;
    ArrayList<CheckBox> alFifthhQue = new ArrayList<>();

    //Image
    FileInputStream imginput;
    Image imglogo;
    ImageView imgViewLogo;


    public Animals() throws FileNotFoundException {
        super();
        //Root vbox properties
        this.setSpacing(10);

        //Making CSVManager object
        CSVManager csvm = new CSVManager();

        //Title
        AnimalsTitle = new Text("Animales");
        AnimalsTitle.setId("title-text");

        //First Question elements
        lbFirstQue = new Label("¿Tienes alguna mascota?");
        rbFirstQueYes = new RadioButton("Sí");
        rbFirstQueNo = new RadioButton("No");
        tgFirstQue = new ToggleGroup();
        rbFirstQueYes.setToggleGroup(tgFirstQue);
        rbFirstQueNo.setToggleGroup(tgFirstQue);

        //Second Question elements
        lbSecondQue = new Label("¿De cuantas mascotas dispones?");
        rbSecondQue1 = new RadioButton("1");
        rbSecondQue2 = new RadioButton("2");
        rbSecondQue3 = new RadioButton("3");
        rbSecondQueM3 = new RadioButton("Más de 3");
        tgSecondQue = new ToggleGroup();
        rbSecondQue1.setToggleGroup(tgSecondQue);
        rbSecondQue2.setToggleGroup(tgSecondQue);
        rbSecondQue3.setToggleGroup(tgSecondQue);
        rbSecondQueM3.setToggleGroup(tgSecondQue);

        //Third Question elements
        lbThirdQue = new Label("¿Como adquirio su mascota?");
        cbThirdQueAd = new CheckBox("Adoptada");
        cbThirdQueCo = new CheckBox("Comprada");
        cbThirdQueRe= new CheckBox("Regalada");

        //Adding checkboxes to an arraylist
        alThirdQue.add(cbThirdQueAd);
        alThirdQue.add(cbThirdQueCo);
        alThirdQue.add(cbThirdQueRe);

        //Forth Question elements
        lbForthQue = new Label("¿Con que frecuencia llevas su mascota al veterinario?");
        cbForthQueUm = new CheckBox("Una Vez al mes");
        cbForthQueUa = new CheckBox("Una vez al año");
        cbForthQueN = new CheckBox("Nunca");
        cbForthQueDa = new CheckBox("Dos veces al año");
        cbForthQueE = new CheckBox("Cuando enferma");
        tfForthQueOther = new TextField();

        //Adding checkboxes to an arraylist
        alForthQue.add(cbForthQueUm);
        alForthQue.add(cbForthQueUa);
        alForthQue.add(cbForthQueN);
        alForthQue.add(cbForthQueDa);
        alForthQue.add(cbForthQueE);

        //Fifth Question elements
        lbFifthQue = new Label("¿Donde pasa la mayoria del tiepo su mascota?");
        chFifthQuePa = new CheckBox("En el patio");
        chFifthQueHo = new CheckBox("Dentro del hogar");
        chFifthQueLi = new CheckBox("Libre");
        tfFifthQueOther = new TextField();

        //Adding checkboxes to an arraylist
        alFifthhQue.add(chFifthQuePa);
        alFifthhQue.add(chFifthQueHo);
        alFifthhQue.add(chFifthQueLi);

        //Image
        imginput = new FileInputStream("src/main/resources/assets/images/animals.png");
        imglogo = new Image(imginput);
        imgViewLogo = new ImageView(imglogo);
        imgViewLogo.setFitHeight(340);
        imgViewLogo.setFitWidth(430);

        //Adding elements to root
        this.getChildren().addAll(AnimalsTitle);

        hbFirstQue = new HBox(10);
        hbFirstQue.getChildren().addAll(rbFirstQueYes, rbFirstQueNo);
        this.getChildren().addAll(lbFirstQue, hbFirstQue);

        hbSecondQue = new HBox(10);
        hbSecondQue.getChildren().addAll(rbSecondQue1, rbSecondQue2, rbSecondQue3, rbSecondQueM3);
        this.getChildren().addAll(lbSecondQue, hbSecondQue);

        hbThirdQue = new HBox(10);
        hbThirdQue.getChildren().addAll(cbThirdQueAd, cbThirdQueCo, cbThirdQueRe);
        this.getChildren().addAll(lbThirdQue, hbThirdQue);

        GridPane gpForthQue = new GridPane();
        gpForthQue.add(cbForthQueUm, 0, 0);
        gpForthQue.add(cbForthQueUa, 1, 0);
        gpForthQue.add(cbForthQueN, 2, 0);
        gpForthQue.add(cbForthQueDa, 0, 1);
        gpForthQue.add(cbForthQueE, 1, 1);
        gpForthQue.add(tfForthQueOther, 2, 1);
        this.getChildren().addAll(lbForthQue, gpForthQue);

        hbFifthQue = new HBox(10);
        hbFifthQue.getChildren().addAll(chFifthQuePa, chFifthQueHo, chFifthQueLi, tfFifthQueOther);
        this.getChildren().addAll(lbFifthQue, hbFifthQue);

        //Provisional Button to make the CSV
        Button btnCheckNmake = new Button("Enviar");
        btnCheckNmake.setStyle("-fx-background-color: #25FB54;");
        this.getChildren().add(btnCheckNmake);

        //Texto de confirmacion
        Text texto = new Text();
        texto.setFont(new Font(20));

        this.getChildren().add(texto);

        this.getChildren().add(imgViewLogo);


        //Try to make the CSV
        btnCheckNmake.setOnAction(e -> {
            if (csvm.CheckAnimalsData(tgFirstQue, tgSecondQue, alThirdQue, alForthQue, tfForthQueOther, alFifthhQue, tfFifthQueOther)) {
                csvm.CsvMaker("Animals");
                texto.setText("Encuesta enviada con exito");
                texto.setFill(Color.GREEN);
            }
            else {
                texto.setText("Debe rellenar los campos vacios.");
                texto.setFill(Color.RED);
            }
        });

    }

}