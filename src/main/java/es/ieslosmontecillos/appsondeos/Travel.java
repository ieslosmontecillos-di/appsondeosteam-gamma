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

public class Travel extends VBox {

    //DECLARACION VARIABLES
    Text travelTittle;

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
    RadioButton rb5SecondQue;
    ToggleGroup tgSecondQue;

    //TERCERA PREGRUNTA
    Label lbThirdQues;
    HBox hbThirdQues;
    RadioButton rb1ThirdQues;
    RadioButton rb2ThirdQues;
    RadioButton rb3ThirdQues;
    RadioButton rb4ThirdQues;
    RadioButton rb5ThirdQues;
    ToggleGroup tgThirdQues;

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
    CheckBox cb1FifthQues;
    CheckBox cb2FifthQues;
    CheckBox cb3FifthQues;
    CheckBox cb4FifthQues;
    CheckBox cb5FifthQues;

    //IMAGEN
    FileInputStream imginput;
    Image imglogo;
    ImageView imgViewLogo;

    public Travel() throws FileNotFoundException {
        super();
        this.setSpacing(10);

        //TITULO
        travelTittle = new Text("Viajes");
        travelTittle.setId("title-text");

        //PRIMERA PREGUNTA
        lbFirstQue = new Label("¿Tiene usted pensado viajar proximamente?");

        hbFirstQue = new HBox(10);

        rbFirstQueYes = new RadioButton("Sí");
        rbFirstQueNo = new RadioButton("No");

        tgFirstQue = new ToggleGroup();

        rbFirstQueYes.setToggleGroup(tgFirstQue);
        rbFirstQueNo.setToggleGroup(tgFirstQue);

        hbFirstQue.getChildren().addAll(rbFirstQueYes, rbFirstQueNo);

        this.getChildren().addAll(travelTittle,lbFirstQue, hbFirstQue);

        //SEGUNDA PREGUNTA
        lbSecondQue = new Label("¿Hace cuanto fue su ultimo viaje?");

        gpSecondQue = new GridPane();

        rb1SecondQue = new RadioButton("Hace unos meses ");
        rb2SecondQue = new RadioButton("1 año");
        rb3SecondQue = new RadioButton("2 años");
        rb4SecondQue = new RadioButton("3 años");
        rb5SecondQue = new RadioButton("Mas de 3 años");

        tgSecondQue = new ToggleGroup();

        rb1SecondQue.setToggleGroup(tgSecondQue);
        rb2SecondQue.setToggleGroup(tgSecondQue);
        rb3SecondQue.setToggleGroup(tgSecondQue);
        rb4SecondQue.setToggleGroup(tgSecondQue);
        rb5SecondQue.setToggleGroup(tgSecondQue);

        gpSecondQue.add(rb1SecondQue,0,0);
        gpSecondQue.add(rb2SecondQue,1,0);
        gpSecondQue.add(rb3SecondQue,2,0);
        gpSecondQue.add(rb4SecondQue,0,1);
        gpSecondQue.add(rb5SecondQue,1,1);

        this.getChildren().addAll(lbSecondQue,gpSecondQue);


        //TERCERA PREGUNTA
        lbThirdQues = new Label("¿Cuantos viajes sueles realizar al año?");

        hbThirdQues = new HBox(10);

        rb1ThirdQues = new RadioButton("1");
        rb2ThirdQues = new RadioButton("2");
        rb3ThirdQues = new RadioButton("3");
        rb4ThirdQues = new RadioButton("4 o mas");
        rb5ThirdQues = new RadioButton("ninguno");

        tgThirdQues = new ToggleGroup();

        rb1ThirdQues.setToggleGroup(tgFirstQue);
        rb2ThirdQues.setToggleGroup(tgFirstQue);
        rb3ThirdQues.setToggleGroup(tgFirstQue);
        rb4ThirdQues.setToggleGroup(tgFirstQue);
        rb5ThirdQues.setToggleGroup(tgFirstQue);

        hbThirdQues.getChildren().addAll(rb1ThirdQues,rb2ThirdQues,rb3ThirdQues,rb4ThirdQues,rb5ThirdQues);

        this.getChildren().addAll(lbThirdQues,hbThirdQues);

        //CUARTA PREGUNTA
        lbFourthQue= new Label("¿Cuantos dias sueles estar de viaje?");

        gpFourthQue = new GridPane();

        rb1FourthQue = new RadioButton("Entre 2 y 3 dias ");
        rb2FourthQue = new RadioButton("Entre 4 y 6 dias ");
        rb3FourthQue = new RadioButton("Entre 1 y 2 semanas ");
        rb4FourthQue = new RadioButton("Mas de 2 semanas ");

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
        lbFifthQues = new Label("Que medio/s sueles usar para viajar");

        hbFifthQues = new HBox(10);

        cb1FifthQues = new CheckBox("Coche");
        cb2FifthQues = new CheckBox("Moto");
        cb3FifthQues = new CheckBox("Bus");
        cb4FifthQues = new CheckBox("Barco");
        cb5FifthQues = new CheckBox("Avion");

        hbFifthQues.getChildren().addAll(cb1FifthQues,cb2FifthQues,cb3FifthQues,cb4FifthQues,cb5FifthQues);

        this.getChildren().addAll(lbFifthQues,hbFifthQues);

        //Provisional Button to make the CSV
        Button btnCheckNmake = new Button("Enviar");
        this.getChildren().add(btnCheckNmake);

        //IMAGEN
        imginput = new FileInputStream("src/main/resources/assets/images/travel.jpg");
        imglogo = new Image(imginput);
        imgViewLogo = new ImageView(imglogo);
        imgViewLogo.setFitHeight(340);
        imgViewLogo.setFitWidth(430);

        this.getChildren().add(imgViewLogo);
    }

}
