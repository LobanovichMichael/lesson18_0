package org.example.lesson18_0;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {

    private Calculator calculator = new Calculator();
    @FXML
    private Label resultLabel;
    @FXML
    private TextField userInput;

    @FXML
    private void evaluate() {
        float num1 = calculator.evaluateResult(userInput.getText());
        if (calculator.getIsError()) {
            resultLabel.setText(calculator.getErrorText());
            resultLabel.setTextFill(Color.RED);
        } else {
            resultLabel.setText(String.valueOf(num1));
            resultLabel.setTextFill(Color.BLACK);
        }
    }
}