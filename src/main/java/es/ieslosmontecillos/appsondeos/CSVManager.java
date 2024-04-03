package es.ieslosmontecillos.appsondeos;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CSVManager {

    //Attributes
    String data;

    //Constructor
    public CSVManager(){
    }

    //Methods

    //Food check Method
    boolean CheckFoodData (ToggleGroup tgFirstQue, ToggleGroup tgSecondQue, ArrayList<CheckBox> alThirdQue, TextField tfThirdQueOther, ArrayList<CheckBox> alForthQue, ToggleGroup tgFifthQue)
    {
        boolean dataIsCorrect = true;

        //Check if the text field is null
        String tfThird = (tfThirdQueOther.getText().isEmpty()) ? "" : "["+tfThirdQueOther.getText()+"]";

        //Check if obligatory field are filled
        if (tgFirstQue.getSelectedToggle() == null ||
                tgSecondQue.getSelectedToggle() == null ||
                tgFifthQue.getSelectedToggle() == null) {
            dataIsCorrect = false;
        } else {
            //Make the data into it's attribute
            this.data = ((RadioButton)tgFirstQue.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)tgSecondQue.getSelectedToggle()).getText()  + ";"
                    + arrayToString(alThirdQue) + tfThird + ";" + arrayToString(alForthQue) + ";"
                    + ((RadioButton)tgFifthQue.getSelectedToggle()).getText();
        }

        return dataIsCorrect;
    }

    //Animals check Method
    boolean CheckAnimalsData (ToggleGroup tgFirstQue, ToggleGroup tgSecondQue, ArrayList<CheckBox> alThirdQue, ArrayList<CheckBox> alForthQue, TextField tfForthQueOther, ArrayList<CheckBox> alFifthhQue,  TextField tfFifthQueOther)
    {
        boolean dataIsCorrect = true;

        //Check if the text field is null
        String tfForth = (tfForthQueOther.getText().isEmpty()) ? "" : "["+tfForthQueOther.getText()+"]";
        String tfFifth = (tfFifthQueOther.getText().isEmpty()) ? "" : "["+tfFifthQueOther.getText()+"]";

        //Check if obligatory field are filled
        if (tgFirstQue.getSelectedToggle() == null ||
                tgSecondQue.getSelectedToggle() == null) {
            dataIsCorrect = false;
        } else {
            //Make the data into it's attribute
            this.data = ((RadioButton)tgFirstQue.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)tgSecondQue.getSelectedToggle()).getText()  + ";"
                    + arrayToString(alThirdQue) + ";" + arrayToString(alForthQue) + tfForth + ";"
                    + arrayToString(alFifthhQue) + tfFifth;
        }

        return dataIsCorrect;
    }

    //Reading check Method
    boolean CheckReadingData(ToggleGroup tgFirstQue, ToggleGroup tgSecondQue, ArrayList<CheckBox> alThirdQue, ToggleGroup tgFourthQue, ToggleGroup tgFifthQues)
    {
        boolean dataIsCorrect = true;


        //Check if obligatory field are filled
        if (tgFirstQue.getSelectedToggle() == null ||
                tgSecondQue.getSelectedToggle() == null ||
                tgFourthQue.getSelectedToggle() == null||
                tgFifthQues.getSelectedToggle() == null) {
            dataIsCorrect = false;
        } else {
            //Make the data into it's attribute
            this.data = ((RadioButton)tgFirstQue.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)tgSecondQue.getSelectedToggle()).getText()  + ";"
                    + arrayToString(alThirdQue) + ";"
                    + ((RadioButton)tgFourthQue.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)tgFifthQues.getSelectedToggle()).getText();
        }

        return dataIsCorrect;
    }

    //Travel check Method
    boolean CheckTravelData(ToggleGroup tgFirstQue, ToggleGroup tgSecondQue, ToggleGroup tgThirdQues, ToggleGroup tgFourthQue, ArrayList<CheckBox> alFifthQues)
    {
        boolean dataIsCorrect = true;


        //Check if obligatory field are filled
        if (tgFirstQue.getSelectedToggle() == null ||
                tgSecondQue.getSelectedToggle() == null ||
                tgThirdQues.getSelectedToggle() == null ||
                tgFourthQue.getSelectedToggle() == null) {
            dataIsCorrect = false;
        } else {
            //Make the data into it's attribute
            this.data = ((RadioButton)tgFirstQue.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)tgSecondQue.getSelectedToggle()).getText()  + ";"
                    + ((RadioButton)tgThirdQues.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)tgFourthQue.getSelectedToggle()).getText() + ";"
                    + arrayToString(alFifthQues);
        }

        return dataIsCorrect;
    }

    //Sports check Method
    boolean CheckSportsData(TextField nameTextField, TextField ageTextField, TextField dniTextField, ToggleGroup genderToggleGroup,
                            ToggleGroup exerciseToggleGroup, TextField sportTextField, ToggleGroup daysPerWeekToggleGroup, ToggleGroup hoursPerDayToggleGroup)
    {
        boolean dataIsCorrect = true;


        //Check if obligatory field are filled
        if (nameTextField.getText().isEmpty() ||
                ageTextField.getText().isEmpty() ||
                dniTextField.getText().isEmpty() ||
                //comprueba que el textfield no este deshabilitado y su texto vacio
                (!sportTextField.isDisabled() && sportTextField.getText().isEmpty()) ||
                genderToggleGroup.getSelectedToggle() == null ||
                exerciseToggleGroup.getSelectedToggle() == null ||
                daysPerWeekToggleGroup.getSelectedToggle() == null ||
                hoursPerDayToggleGroup.getSelectedToggle() == null) {
            dataIsCorrect = false;
        } else {
            //Make the data into it's attribute
            this.data = nameTextField.getText() + ";"
                    + ageTextField.getText()  + ";"
                    + dniTextField.getText() + ";"
                    + ((RadioButton)genderToggleGroup.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)exerciseToggleGroup.getSelectedToggle()).getText()  + ";"
                    + sportTextField.getText() + ";"
                    + ((RadioButton)daysPerWeekToggleGroup.getSelectedToggle()).getText() + ";"
                    + ((RadioButton)hoursPerDayToggleGroup.getSelectedToggle()).getText();
        }

        return dataIsCorrect;
    }
    //Convert an ArrayList<Checkbox> into a String
    String arrayToString (ArrayList<CheckBox> arrayList){
        String string = "";

        for (CheckBox checkBox : arrayList) {
            if (checkBox.isSelected())
                string += "[" + checkBox.getText() + "]";
        }

        return string;
    }


    // Method to generate the CSV file
    public void CsvMaker(String fileName) {

        boolean directoryCreated;

        try {
            // Gets the current route in text type
            String currentPath = Paths.get("").toAbsolutePath().normalize().toString();
            String csvFolder = "/csvFolder";  // Name of the folder
            String csvPath = currentPath + csvFolder;   // File path
            File newFolder = new File(csvPath); // Create the directory at the path given by csvPath
            directoryCreated = newFolder.mkdir(); // Create the directory if it is not already created

            // Get current date
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            // Initialization of the class that will write to our txt
            File statText = new File(csvPath + "/" + fileName + ".csv");
            FileOutputStream fileOS = new FileOutputStream(statText, true); // Adds the text
            OutputStreamWriter outputSW = new OutputStreamWriter(fileOS);

            Writer writer = new BufferedWriter(outputSW);
            writer.write(dateTimeFormatter.format(now) + ";" + this.data + ";\n");// Final text
            writer.close();


        } catch (IOException e) {
            System.err.println("An error has occurred writing to the file. Error:  " + e);
        }
    }


}
