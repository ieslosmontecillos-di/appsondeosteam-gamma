package es.ieslosmontecillos.appsondeos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.UnaryOperator;

public class Sport extends VBox {

    // Title
    Text titleLabel;

    // Personal Info
    VBox personalInfoVBox;
    HBox nameHBox;
    Label nameLabel;
    TextField nameTextField;
    HBox ageHBox;
    Label ageLabel;
    TextField ageTextField;
    Label dniLabel;
    TextField dniTextField;

    // Gender
    HBox genderHBox;
    Label genderLabel;
    RadioButton maleRadioButton;
    RadioButton femaleRadioButton;
    RadioButton otherRadioButton;
    ToggleGroup genderToggleGroup;

    Separator separator1;

    // ¿Practicas deporte?
    Label doYouExerciseLabel;
    HBox exerciseOptionsHBox;
    RadioButton yesRadioButton;
    RadioButton noRadioButton;

    // ¿Qué deporte practicas?
    VBox sportVBox;
    Label sportLabel;
    TextField sportTextField;

    // ¿Cuántos días a la semana lo practicas?
    VBox daysPerWeekVBox;
    Label daysPerWeekLabel;
    HBox daysPerWeekOptionsHBox;
    RadioButton oneDayRadioButton;
    RadioButton twoDaysRadioButton;
    RadioButton threeDaysRadioButton;
    RadioButton noneRadioButton;

    // ¿Cuántas horas al día practicas deporte?
    VBox hoursPerDayVBox;
    Label hoursPerDayLabel;
    HBox hoursPerDayOptionsHBox;
    RadioButton oneHourRadioButton;
    RadioButton twoHoursRadioButton;
    RadioButton threeHoursRadioButton;
    RadioButton noneHoursRadioButton;

    // Image
    FileInputStream imgInput;
    Image imgLogo;
    ImageView imgViewLogo;

    public Sport() throws FileNotFoundException {
        super();

        this.setSpacing(10);

        //Making CSVManager object
        CSVManager csvm = new CSVManager();

        titleLabel = new Text("Deporte");
        titleLabel.setId("title-text");

        // Personal Info
        personalInfoVBox = new VBox(10);

        nameHBox = new HBox(10);
        nameLabel = new Label("Nombre:");
        nameTextField = new TextField();
        nameHBox.getChildren().addAll(nameLabel, nameTextField);
        HBox.setHgrow(nameTextField, Priority.ALWAYS); // Hacer que el campo de entrada ocupe todo el ancho

        ageHBox = new HBox(10);
        ageLabel = new Label("Edad:");
        ageTextField = new TextField();

        //Controla que solo se pueda escribir numeros en el campo edad
        String formatoEdad = "[0-9]*";

        ageTextField.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches(formatoEdad)) ? change : null));


        dniLabel = new Label("DNI/NIF:");
        dniTextField = new TextField();

        //controla que el formato del DNI sea de 8 numeros y una letra mayuscula
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9]{0,8}[A-Z]?"))
            {
                return change;
            }
            else
            {
                return null;
            }
        };

        // Crear un TextFormatter con el filtro
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        dniTextField.setTextFormatter(textFormatter);

        ageHBox.getChildren().addAll(ageLabel, ageTextField, dniLabel, dniTextField);
        HBox.setHgrow(ageTextField, Priority.ALWAYS); // Hacer que el campo de entrada ocupe todo el ancho
        HBox.setHgrow(dniTextField, Priority.ALWAYS); // Hacer que el campo de entrada ocupe todo el ancho

        personalInfoVBox.getChildren().addAll(nameHBox, ageHBox);

        // Gender
        genderHBox = new HBox(10);
        genderLabel = new Label("Género:");
        maleRadioButton = new RadioButton("Hombre");
        femaleRadioButton = new RadioButton("Mujer");
        otherRadioButton = new RadioButton("Otro");
        genderToggleGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);
        otherRadioButton.setToggleGroup(genderToggleGroup);
        genderHBox.getChildren().addAll(genderLabel, maleRadioButton, femaleRadioButton, otherRadioButton);

        separator1 = new Separator();

        // ¿Practicas deporte?
        doYouExerciseLabel = new Label("¿Practicas deporte?");
        exerciseOptionsHBox = new HBox(10);
        yesRadioButton = new RadioButton("Sí");
        noRadioButton = new RadioButton("No");
        ToggleGroup exerciseToggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(exerciseToggleGroup);
        noRadioButton.setToggleGroup(exerciseToggleGroup);


        exerciseToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == noRadioButton) {
                    sportTextField.setDisable(true);
                } else {
                    sportTextField.setDisable(false);
                }
            }
        });



        exerciseOptionsHBox.getChildren().addAll(yesRadioButton, noRadioButton);

        // ¿Qué deporte practicas?
        sportVBox = new VBox(10);
        sportLabel = new Label("¿Qué deporte practicas?");
        sportTextField = new TextField();

        //exerciseToggleGroup.selectedToggleProperty().addListener(obs);

        sportVBox.getChildren().addAll(sportLabel, sportTextField);
        VBox.setVgrow(sportTextField, Priority.ALWAYS); // Hacer que el campo de entrada ocupe todo el ancho

        // ¿Cuántos días a la semana lo practicas?
        daysPerWeekVBox = new VBox(10);
        daysPerWeekLabel = new Label("¿Cuántos días a la semana lo practicas?");
        daysPerWeekOptionsHBox = new HBox(10);
        oneDayRadioButton = new RadioButton("1 día");
        twoDaysRadioButton = new RadioButton("2 días");
        threeDaysRadioButton = new RadioButton("3 días");
        noneRadioButton = new RadioButton("Ninguno");
        ToggleGroup daysPerWeekToggleGroup = new ToggleGroup();
        oneDayRadioButton.setToggleGroup(daysPerWeekToggleGroup);
        twoDaysRadioButton.setToggleGroup(daysPerWeekToggleGroup);
        threeDaysRadioButton.setToggleGroup(daysPerWeekToggleGroup);
        noneRadioButton.setToggleGroup(daysPerWeekToggleGroup);
        daysPerWeekOptionsHBox.getChildren().addAll(oneDayRadioButton, twoDaysRadioButton, threeDaysRadioButton, noneRadioButton);
        daysPerWeekVBox.getChildren().addAll(daysPerWeekLabel, daysPerWeekOptionsHBox);

        // ¿Cuántas horas al día practicas deporte?
        hoursPerDayVBox = new VBox(10);
        hoursPerDayLabel = new Label("¿Cuántas horas al día practicas deporte?");
        hoursPerDayOptionsHBox = new HBox(10);
        oneHourRadioButton = new RadioButton("1 hora");
        twoHoursRadioButton = new RadioButton("2 horas");
        threeHoursRadioButton = new RadioButton("3 horas");
        noneHoursRadioButton = new RadioButton("Ninguna");
        ToggleGroup hoursPerDayToggleGroup = new ToggleGroup();
        oneHourRadioButton.setToggleGroup(hoursPerDayToggleGroup);
        twoHoursRadioButton.setToggleGroup(hoursPerDayToggleGroup);
        threeHoursRadioButton.setToggleGroup(hoursPerDayToggleGroup);
        noneHoursRadioButton.setToggleGroup(hoursPerDayToggleGroup);
        hoursPerDayOptionsHBox.getChildren().addAll(oneHourRadioButton, twoHoursRadioButton, threeHoursRadioButton, noneHoursRadioButton);
        hoursPerDayVBox.getChildren().addAll(hoursPerDayLabel, hoursPerDayOptionsHBox);

        Button submitButton = new Button("Enviar");
        submitButton.setStyle("-fx-background-color: #25FB54;");

        //Texto de confirmacion
        Text texto = new Text();
        texto.setFont(new Font(20));

        HBox imageContainer = new HBox();
        imageContainer.setAlignment(Pos.CENTER);

        imgInput = new FileInputStream("src/main/resources/assets/images/sport.png");
        imgLogo = new Image(imgInput);
        imgViewLogo = new ImageView(imgLogo);
        imgViewLogo.setFitHeight(300);
        imgViewLogo.setPreserveRatio(true);

        imageContainer.getChildren().add(imgViewLogo);

        this.getChildren().addAll(titleLabel, personalInfoVBox, genderHBox, separator1, doYouExerciseLabel, exerciseOptionsHBox, sportVBox, daysPerWeekVBox, hoursPerDayVBox, submitButton,texto, imgViewLogo);

        submitButton.setOnAction(e -> {
            if (csvm.CheckSportsData(nameTextField, ageTextField, dniTextField, genderToggleGroup, exerciseToggleGroup, sportTextField, daysPerWeekToggleGroup, hoursPerDayToggleGroup)) {
                csvm.CsvMaker("Sport");
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
