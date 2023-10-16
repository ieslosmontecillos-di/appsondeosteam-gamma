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

public class Reading extends VBox{

    //DECLARACION VARIABLES

    Text readingTittle;

    //PRIMERA PREGUNTA
    Label lbFirstQue;
    HBox hbFirstQue;
    RadioButton rbFirstQueYes;
    RadioButton rbFirstQueNo;
    ToggleGroup tgFirstQue;

    //SEGUNDA PREGUNTA
    Label lbSecondQue;
    GridPane gpSecondQue;
    RadioButton rb1SecondQue;
    RadioButton rb2SecondQue;
    RadioButton rb3SecondQue;
    RadioButton rb4SecondQue;
    ToggleGroup tgSecondQue;

    //TERCERA PREGUNTA
    Label lbThirQues;
    HBox hbThirQues;
    CheckBox cb1ThirQues;
    CheckBox cb2ThirQues;
    CheckBox cb3ThirQues;
    CheckBox cb4ThirQues;
    CheckBox cb5ThirQues;
    ArrayList<CheckBox> alThirdQue = new ArrayList<>();

    //CUARTA PREGUNTA
    Label lbFourthQue;
    GridPane gpFourthQue;
    RadioButton rb1FourthQue;
    RadioButton rb2FourthQue;
    RadioButton rb3FourthQue;
    RadioButton rb4FourthQue;
    ToggleGroup tgFourthQue;

    //QUINTA PREGUNTA
    Label lbFifthQues;
    HBox hbFifthQues;
    RadioButton rbFifthQuesYes;
    RadioButton rbFifthQuesNo;
    ToggleGroup tgFifthQues;

    //IMAGEN
    FileInputStream imginput;
    Image imglogo;
    ImageView imgViewLogo;

    public Reading() throws FileNotFoundException {
        super();
        this.setSpacing(10);

        CSVManager csvm = new CSVManager();

        //TITULO
        readingTittle = new Text("Lecturas");
        readingTittle.setId("title-text");

        //PRIMERA PREGUNTA

        lbFirstQue = new Label("¿Considera usted que la lectura es importante?");

        hbFirstQue = new HBox(10);

        rbFirstQueYes = new RadioButton("Sí");
        rbFirstQueNo = new RadioButton("No");

        tgFirstQue = new ToggleGroup();

        rbFirstQueYes.setToggleGroup(tgFirstQue);
        rbFirstQueNo.setToggleGroup(tgFirstQue);

        hbFirstQue.getChildren().addAll(rbFirstQueYes, rbFirstQueNo);

        this.getChildren().addAll(readingTittle,lbFirstQue, hbFirstQue);

        //SEGUNDA PREGUNTA
        lbSecondQue = new Label("¿Cuanto tiempo le dedica a la lectura?");

        gpSecondQue = new GridPane();

        rb1SecondQue = new RadioButton("20 - 30 minutos ");
        rb2SecondQue = new RadioButton("1 hora");
        rb3SecondQue = new RadioButton("Mas de 1 hora");
        rb4SecondQue = new RadioButton("No tengo tiempo");

        tgSecondQue = new ToggleGroup();

        rb1SecondQue.setToggleGroup(tgSecondQue);
        rb2SecondQue.setToggleGroup(tgSecondQue);
        rb3SecondQue.setToggleGroup(tgSecondQue);
        rb4SecondQue.setToggleGroup(tgSecondQue);

        gpSecondQue.add(rb1SecondQue,0,0);
        gpSecondQue.add(rb2SecondQue,0,1);
        gpSecondQue.add(rb3SecondQue,1,0);
        gpSecondQue.add(rb4SecondQue,1,1);

        this.getChildren().addAll(lbSecondQue,gpSecondQue);

        //TERCERA PREGUNTA
        lbThirQues = new Label("Que genero/s de libro le gusta leer");

        hbThirQues = new HBox(10);

        cb1ThirQues = new CheckBox("Accion");
        cb2ThirQues = new CheckBox("Romance");
        cb3ThirQues = new CheckBox("Aventura");
        cb4ThirQues = new CheckBox("Terror");
        cb5ThirQues = new CheckBox("Otro");

        alThirdQue.add(cb1ThirQues);
        alThirdQue.add(cb2ThirQues);
        alThirdQue.add(cb3ThirQues);
        alThirdQue.add(cb4ThirQues);
        alThirdQue.add(cb5ThirQues);

        hbThirQues.getChildren().addAll(cb1ThirQues,cb2ThirQues,cb3ThirQues,cb4ThirQues,cb5ThirQues);

        this.getChildren().addAll(lbThirQues, hbThirQues);

        //CUARTA PREGUNTA
        lbFourthQue= new Label("¿Cuantos libros posee en su casa?");

        gpFourthQue = new GridPane();

        rb1FourthQue = new RadioButton("Menos de 5 ");
        rb2FourthQue = new RadioButton("Entre 5 y 20");
        rb3FourthQue = new RadioButton("Entre 20 y 50 ");
        rb4FourthQue = new RadioButton("Mas de 50 ");

        tgFourthQue = new ToggleGroup();

        rb1FourthQue.setToggleGroup(tgFourthQue);
        rb2FourthQue.setToggleGroup(tgFourthQue);
        rb3FourthQue.setToggleGroup(tgFourthQue);
        rb4FourthQue.setToggleGroup(tgFourthQue);

        gpFourthQue.add(rb1FourthQue,0,0);
        gpFourthQue.add(rb2FourthQue,0,1);
        gpFourthQue.add(rb3FourthQue,1,0);
        gpFourthQue.add(rb4FourthQue,1,1);


        this.getChildren().addAll(lbFourthQue,gpFourthQue);

        //QUINTA PREGUNTA
        lbFifthQues = new Label("¿Esta usted leyendo algun libro actualmente?");

        hbFifthQues = new HBox(10);

        rbFifthQuesYes = new RadioButton("Sí");
        rbFifthQuesNo = new RadioButton("No");

        tgFifthQues = new ToggleGroup();

        rbFifthQuesYes.setToggleGroup(tgFifthQues);
        rbFifthQuesNo.setToggleGroup(tgFifthQues);


        hbFifthQues.getChildren().addAll(rbFifthQuesYes, rbFifthQuesNo);

        this.getChildren().addAll(lbFifthQues, hbFifthQues);

        //Provisional Button to make the CSV
        Button btnCheckNmake = new Button("Enviar");
        btnCheckNmake.setStyle("-fx-background-color: #25FB54;");
        this.getChildren().add(btnCheckNmake);

        //IMAGEN
        imginput = new FileInputStream("src/main/resources/assets/images/books.jpg");
        imglogo = new Image(imginput);
        imgViewLogo = new ImageView(imglogo);
        imgViewLogo.setFitHeight(340);
        imgViewLogo.setFitWidth(430);

        btnCheckNmake.setOnAction(e -> {
            if (csvm.CheckReadingData(tgFirstQue, tgSecondQue, alThirdQue, tgFourthQue, tgFifthQues))
                csvm.CsvMaker("Reading");
            else
                System.out.println("Debe rellenar los campos vacios.");
        });

        this.getChildren().add(imgViewLogo);

    }

}
