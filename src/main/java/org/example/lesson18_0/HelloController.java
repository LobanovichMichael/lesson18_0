package org.example.lesson18_0;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {

    Calculator calculator = new Calculator();
    @FXML
    private Label resultLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField userInput;

    @FXML
    private void evaluate() {
        errorLabel.setText("");
        float num1 = calculator.evaluateResult(userInput.getText());
        resultLabel.setText(String.valueOf(num1));
        if (calculator.getIsError()) {
            errorLabel.setText(calculator.getErrorText());
            errorLabel.setTextFill(Color.RED);
        }
    }
}