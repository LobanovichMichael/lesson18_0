package org.example.lesson18_0;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    private Button nextButton;

    @FXML
    private void nextScene() throws IOException {
//        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
//
//        Scene scene = new Scene(root);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) nextButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
