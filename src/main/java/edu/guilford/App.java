package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        // instantiate a VBox root node/ empty window
        VBox root = new VBox();

        // instantiate a default Information object
        Information axel = new Information();

        // instantiate an IndividualPane object and add it to the root node
        root.getChildren().add(new InformationPane(axel));

        scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}