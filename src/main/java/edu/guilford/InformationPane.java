package edu.guilford;

import java.io.File;
import java.lang.reflect.Field;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class InformationPane extends GridPane {

    // individual attribute
    private Information axel;

    // add a textfield attirbute for the name
    private TextField nameField;

    // add a textfield attribute for the email
    private TextField emailField;
    // add a textfield attribute for the phone
    private TextField gNumField;

    // add a submit button attribute
    private Button submitButton;
    private Button lionButton;
    private Button monkeyButton;

    // step 1; declare a Checkbox attribute
    // add checkbox attribute
    private RadioButton yellowBox;
    private RadioButton pinkBox;

    // three label attributes for name, email, and phone
    private Label nameLabel;
    private Label emailLabel;
    private Label gNumLabel;

    // step 1: declare an imageview attribute
    private ImageView animal1;
    private ImageView animal2;

    // constructor
    public InformationPane(Information axel) {
        // set the individual attribute to individual parameter
        this.axel = axel;

        // instantiate submit button
        submitButton = new Button("Update Information");

        lionButton = new Button("Lion");
        monkeyButton = new Button("Monkey");

        // Step 2: instantiate a checkbox to change background colors
        yellowBox = new RadioButton("Yellow Background");
        pinkBox = new RadioButton("Pink Background");

        // step 2 : // instantiate imageview
        // get the path of the file that contains the image
        File avatar = new File(this.getClass().getResource("Lion.png").getPath());
        File avatar2 = new File(this.getClass().getResource("monkey.png").getPath());
        // print the path to the console
        System.out.println("PATH: " + avatar);

        // URI stands for Uniform Resource Identifier and it is similar to URL
        animal1 = new ImageView(avatar.toURI().toString());
        animal2 = new ImageView(avatar2.toURI().toString());

        // instantiate name field
        nameField = new TextField();
        // instantiate email field
        emailField = new TextField();
        // instantiate G-Number field
        gNumField = new TextField();

        // instantiate label attributes
        nameLabel = new Label("Name: " + axel.getName());
        emailLabel = new Label("Email: " + axel.getemail());
        gNumLabel = new Label("G-Number: " + axel.getgNumber());

        // add a label to the pane
        this.add(nameLabel, 15, 3);
        this.add(emailLabel, 15, 5);
        this.add(gNumLabel, 15, 7);

        // add a name field to the pane nex to the name label
        this.add(nameField, 15, 4);
        // add an email field to the pane next to the email label
        this.add(emailField, 15, 6);
        // add a phone field to the pane next to the phone label
        this.add(gNumField, 15, 8);
        // add a submit button to the pane
        this.add(submitButton, 15, 9);
        this.add(lionButton, 15, 12);
        this.add(monkeyButton, 15, 13);

        // Step 3: add a checkbox to the pane
        this.add(yellowBox, 18, 10);
        this.add(pinkBox, 18, 11);

        // step 3: add the imageview to the pane
        // this.add(animal1, 7, 1, 2, 4);

        // steps 4 & 5: Write an event listener and connect it to the component that
        // triggers the event
        // add a listener for the button that changes the labels
        submitButton.setOnAction(e ->

        {

            // set the name label to the name field
            // nameLabel.setText("Name: " + nameField.getText());
            // set the email label to the email field
            // emailLabel.setText("Email " + emailField.getText());
            // set the phone label to the phone field
            // gNumLabel.setText("G-Number " + gNumField.getText());
            // update the individual attribute with the new data
            // axel.setName(nameField.getText());
            // axel.setemail(emailField.getText());
            // axel.setgNumber(gNumField.getText());
            System.out.println(e.toString());

            // when submit button is clicked, make sure name does not contain numbers
            try {
                validateName(nameField.getText());
            } catch (InvalidNameException ex) {
                nameError(ex.getMessage());
            }

            // when submit button is clicked, make sure email is not null using a try method
            try {
                validateEmail(emailField.getText());
            } catch (InvalidEmailException ex) {
                emailError(ex.getMessage());
            }

            // when submit button is clicked,try to validate the G-Number
            try {
                validateGNumber(gNumField.getText());
            } catch (InvalidGNumberException ex) {
                displayError(ex.getMessage());
            }

        });

        // steps 4 & 5: Write an event listener and connect it to the component that
        // triggers the event
        // if lionButton is clicked, animal1 image shows up
        lionButton.setOnAction(e -> {
            this.add(animal1, 30, 20, 1, 4);
            // set a decent height
            animal1.setFitHeight(200);
            // set a decent width
            animal1.setFitWidth(300);
            this.getChildren().remove(animal2);
            System.out.println(e.toString());
        });

        // if monkeyButton is clicked, animal2 image shows up
        monkeyButton.setOnAction(e -> {
            this.add(animal2, 30, 20, 1, 4);
            this.getChildren().remove(animal1);
            System.out.println(e.toString());
        });

        // when lion image is present, clicking on it makes it bigger
        animal1.setOnMouseClicked(e -> {
            animal1.setFitHeight(500);
            animal1.setFitWidth(500);
        });

        // when leaving the lion image, it goes small
        animal1.setOnMouseExited(e -> {
            animal1.setFitHeight(200);
            animal1.setFitWidth(200);
        });

        // when monkey image is present, once the mouse enters its perimeters, it gets
        // bigger
        animal2.setOnMouseEntered(e -> {
            animal2.setFitHeight(500);
            animal2.setFitWidth(500);
        });
        // once mouse leaves perimeters, it gets smaller
        animal2.setOnMouseExited(e -> {
            animal2.setFitHeight(200);
            animal2.setFitWidth(200);
        });

        // add a listener to the checkbox that changes the background color to yellow or
        // pink when the checkbox is selected
        yellowBox.setOnAction(e -> {
            if (yellowBox.isSelected()) {
                this.setStyle("-fx-background-color: yellow");
            } else {
                this.setStyle("-fx-background-color: white");
            }
        });

        pinkBox.setOnAction(e -> {
            if (pinkBox.isSelected()) {
                this.setStyle("-fx-background-color: pink");
            } else {
                this.setStyle("-fx-background-color: white");
            }
        });

    }

    // custom exception class that extends Exception and throw it if the G-Number is
    // invalid
    class InvalidGNumberException extends Exception {
        public InvalidGNumberException(String message) {
            super(message);
        }
    }

    // custom exception class that extends Exception and throw it if the name is
    // invalid
    class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    // custom exception class that extends Exception and throw it if the email is
    // invalid
    class InvalidEmailException extends Exception {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    // method that validates the G-Number
    // throws the custom exception if the G-Number is invalid
    // otherwise, it removes the error label
    private void validateGNumber(String gNum) throws InvalidGNumberException {
        if (!gNum.startsWith("G") || gNum.contains("G... (Ex.G00734859)")) {
            throw new InvalidGNumberException("G... (Ex.G00734859)");
        } else {
            gNumLabel.setText("G-Number: " + gNumField.getText());

        }
    }

    // method that validates the email
    // throws the custom exception if the email is invalid
    // otherwise, it removes the error label
    private void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@") || email.contains("Invalid Input: No @")) {
            throw new InvalidEmailException("Invalid Input: No @");
        } else {
            emailLabel.setText("Email: " + emailField.getText());

        }
    }

    // method that validates the name field to make sure it does not contain numbers
    // throws the custom exception if the name is invalid
    // otherwise, it removes the error label
    private void validateName(String name) throws InvalidNameException {
        if (name.matches(".*\\d.*") || name.contains("Invalid Input: No Numbers")) {
            throw new InvalidNameException("Invalid Input: No Numbers");
        } else {
            nameLabel.setText("Name: " + nameField.getText());

        }
    }

    // method that displays the error message for gnumber
    private void displayError(String message) {
        // instantiate the error label
        gNumField.setText(message);

    }

    // method that displays the error message for email
    private void emailError(String message) {
        // instantiate the error label
        emailField.setText(message);

    }

    // method that displays the error message for name
    private void nameError(String message) {
        // instantiate the error label
        nameField.setText(message);

    }

    // Show the error label in your GUI, e.g., using a dialog or adding it to the
    // scene

}
