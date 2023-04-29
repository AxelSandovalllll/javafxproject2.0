package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class InformationPane extends GridPane {

    // individual attribute
    private Information axel;

    // add a textfield attirbute for the name
    private TextField nameField;

    // add a textfield attribute for the email
    private TextField colorField;
    // add a textfield attribute for the phone
    private TextField animalField;

    // add a submit button attribute
    private Button submitButton;
    private Button lionButton;
    private Button monkeyButton;

    // step 1; declare a Checkbox attribute
    // add checkbox attribute
    private CheckBox yellowBox;
    private CheckBox pinkBox;

    // three label attributes for name, email, and phone
    private Label nameLabel;
    private Label colorLabel;
    private Label animalLabel;

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
        yellowBox = new CheckBox("Yellow Background");
        pinkBox = new CheckBox("Pink Background");

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
        colorField = new TextField();
        // instantiate phone field
        animalField = new TextField();

        // instantiate label attributes
        nameLabel = new Label("Name: " + axel.getName());
        colorLabel = new Label("Favorite Color: " + axel.getFavColor());
        animalLabel = new Label("Favorite Animal: " + axel.getFavAnimal());

        // add a label to the pane
        this.add(nameLabel, 15, 3);
        this.add(colorLabel, 15, 5);
        this.add(animalLabel, 15, 7);

        // add a name field to the pane nex to the name label
        this.add(nameField, 15, 4);
        // add an email field to the pane next to the email label
        this.add(colorField, 15, 6);
        // add a phone field to the pane next to the phone label
        this.add(animalField, 15, 8);
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
        submitButton.setOnAction(e -> {
            // set the name label to the name field
            nameLabel.setText("Name: " + nameField.getText());
            // set the email label to the email field
            colorLabel.setText("Favorite Color: " + colorField.getText());
            // set the phone label to the phone field
            animalLabel.setText("Favorite Animal: " + animalField.getText());
            // update the individual attribute with the new data
            axel.setName(nameField.getText());
            axel.setFavColor(colorField.getText());
            axel.setFavAnimal(animalField.getText());
            System.out.println(e.toString());
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
}
