package es.ieslosmontecillos.appsondeos;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Food extends VBox {

    //Title
    Text foodTitle;

    //First Question
    Label lbFirstQue;
    HBox hbFirstQue;
    RadioButton rbFirstQueYes;
    RadioButton rbFirstQueNo;
    ToggleGroup tgFirstQue;

    //Second Question
    Label lbSecondQue;
    HBox hbSecondQue;
    RadioButton rbSecondQueYes;
    RadioButton rbSecondQueNo;
    ToggleGroup tgSecondQue;

    //Third Question
    Label lbThirdQue;
    CheckBox cbThirdQueMD;
    CheckBox cbThirdQueBK;
    CheckBox cbThirdQueGo;
    CheckBox cbThirdQueTP;
    CheckBox cbThirdQue100M;
    TextField tfThirdQueOther;
    ArrayList<CheckBox> alThirdQue = new ArrayList<>();

    //Forth Question
    Label lbForthQue;
    HBox hbForthQue;
    CheckBox cbForthQueBreakfast;
    CheckBox cbForthQueLunch;
    CheckBox cbForthQueSnack;
    CheckBox cbForthQueDinner;
    ArrayList<CheckBox> alForthQue = new ArrayList<>();

    //Fifth Question
    Label lbFifthQue;
    HBox hbFifthQue;
    RadioButton rbFifthQueYes;
    RadioButton rbFifthQueNo;
    ToggleGroup tgFifthQue;

    //Image
    FileInputStream imginput;
    Image imglogo;
    ImageView imgViewLogo;

    public Food() throws FileNotFoundException {
        super();
        //Root vbox properties
        this.setSpacing(10);

        //Making CSVManager object
        CSVManager csvm = new CSVManager();

        //Title
        foodTitle = new Text("Comidas");
        foodTitle.setId("title-text");

        //First Question elements
        lbFirstQue = new Label("¿Considera usted que es importante cuidar su alimentación?");
        rbFirstQueYes = new RadioButton("Sí");
        rbFirstQueNo = new RadioButton("No");
        tgFirstQue = new ToggleGroup();
        rbFirstQueYes.setToggleGroup(tgFirstQue);
        rbFirstQueNo.setToggleGroup(tgFirstQue);

        //Second Question elements
        lbSecondQue = new Label("¿Le gusta la comida saludable?");
        rbSecondQueYes = new RadioButton("Sí");
        rbSecondQueNo = new RadioButton("No");
        tgSecondQue = new ToggleGroup();
        rbSecondQueYes.setToggleGroup(tgSecondQue);
        rbSecondQueNo.setToggleGroup(tgSecondQue);

        //Third Question elements
        lbThirdQue = new Label("¿Dónde pide habitualmente su comida?");
        cbThirdQueMD = new CheckBox("McDonald");
        cbThirdQueBK = new CheckBox("BurgerKing");
        cbThirdQueGo = new CheckBox("Goiko");
        cbThirdQueTP = new CheckBox("TelePizza");
        cbThirdQue100M = new CheckBox("100 Montaditos");
        tfThirdQueOther = new TextField();
        //Adding checkboxes to an arraylist
        alThirdQue.add(cbThirdQueMD);
        alThirdQue.add(cbThirdQueBK);
        alThirdQue.add(cbThirdQueGo);
        alThirdQue.add(cbThirdQueTP);
        alThirdQue.add(cbThirdQue100M);

        //Forth Question elements
        lbForthQue = new Label("¿En que horarios consumes comida para llevar?");
        cbForthQueBreakfast = new CheckBox("Desayuno");
        cbForthQueLunch = new CheckBox("Almuerzo");
        cbForthQueSnack = new CheckBox("Merienda");
        cbForthQueDinner = new CheckBox("Cena");
        //Adding checkboxes to an arraylist
        alForthQue.add(cbForthQueBreakfast);
        alForthQue.add(cbForthQueLunch);
        alForthQue.add(cbForthQueSnack);
        alForthQue.add(cbForthQueDinner);


        //Fifth Question elements
        lbFifthQue = new Label("¿Estarías dispuesto a dejar de comer carne para ser vegano?");
        rbFifthQueYes = new RadioButton("Sí");
        rbFifthQueNo = new RadioButton("No");
        tgFifthQue = new ToggleGroup();
        rbFifthQueYes.setToggleGroup(tgFifthQue);
        rbFifthQueNo.setToggleGroup(tgFifthQue);


        //Image
        imginput = new FileInputStream("src/main/resources/assets/images/food.jpg");
        imglogo = new Image(imginput);
        imgViewLogo = new ImageView(imglogo);
        imgViewLogo.setFitHeight(340);
        imgViewLogo.setFitWidth(430);



        //Adding elements to root
        this.getChildren().add(foodTitle);

        hbFirstQue = new HBox(10);
            hbFirstQue.getChildren().addAll(rbFirstQueYes, rbFirstQueNo);
        this.getChildren().addAll(lbFirstQue, hbFirstQue);

            hbSecondQue = new HBox(10);
            hbSecondQue.getChildren().addAll(rbSecondQueYes, rbSecondQueNo);
        this.getChildren().addAll(lbSecondQue, hbSecondQue);

            GridPane gpThirdQue = new GridPane();
            gpThirdQue.add(cbThirdQueMD, 0, 0);
            gpThirdQue.add(cbThirdQueBK, 1, 0);
            gpThirdQue.add(cbThirdQueGo, 2, 0);
            gpThirdQue.add(cbThirdQueTP, 0, 1);
            gpThirdQue.add(cbThirdQue100M, 1, 1);
            gpThirdQue.add(tfThirdQueOther, 2, 1);
        this.getChildren().addAll(lbThirdQue, gpThirdQue);

            hbForthQue = new HBox(10);
            hbForthQue.getChildren().addAll(cbForthQueBreakfast, cbForthQueLunch, cbForthQueSnack, cbForthQueDinner);
        this.getChildren().addAll(lbForthQue, hbForthQue);

            hbFifthQue = new HBox(10);
            hbFifthQue.getChildren().addAll(rbFifthQueYes, rbFifthQueNo);
        this.getChildren().addAll(lbFifthQue, hbFifthQue);

        //Provisional Button to make the CSV
        Button btnCheckNmake = new Button("Enviar");
        btnCheckNmake.setStyle("-fx-background-color: #25FB54;");
        this.getChildren().add(btnCheckNmake);

        this.getChildren().add(imgViewLogo);


        //Try to make the CSV
        btnCheckNmake.setOnAction(e -> {
            if (csvm.CheckFoodData(tgFirstQue, tgSecondQue, alThirdQue, tfThirdQueOther, alForthQue, tgFifthQue))
                csvm.CsvMaker("Food");
            else
                System.out.println("Debe rellenar los campos vacios.");
        });



    }

}