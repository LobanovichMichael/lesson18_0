package org.example.lesson18_0;

public class Calculator {
    private String[] history = new String[10000];
    private int currentPosition = 0;
    private final String[] operators = new String[]{"+", "-", "*", "/", "^", "%"};
    private boolean isError = false;
    private String errorText;

    public String getErrorText() {
        return errorText;
    }

    public boolean getIsError() {
        return isError;
    }

    private int checkExpression(String expression) {
        if (expression.split(" ").length == 1) {
            return 1;
        } else if (expression.split(" ").length == 3) {
            return 2;
        } else {
            return 0;
        }
    }

    private String addSpacesToExpression(String expression) {
        for (String operator : operators) {
            if (expression.contains(operator)) {
                expression = expression.replace(operator, " " + operator + " ");
            }
        }
        return expression;
    }

    private String[] parseExpression(String expression) {
        String[] splittedExpression = expression.split(" ");
        boolean isOperator = false;
        if (splittedExpression.length != 3) {
            isError = true;
            errorText = "Некорректное выражение. Выражение должно состоять из двух чисел и знака";
            return new String[]{"ERROR"};
        }
        for (String operator : operators) {
            if (operator.equals(splittedExpression[1])) {
                isOperator = true;
            }
        }
        if (!isOperator) {
            isError = true;
            errorText = "Калькулятор поддерживает только операции +, -, /, *, %, ^.";
            return new String[]{"ERROR"};
        }
        float num1, num2;
        try {
            num1 = Float.parseFloat(splittedExpression[0]);
            num2 = Float.parseFloat(splittedExpression[2]);
        } catch (NumberFormatException e) {
            isError = true;
            errorText = "Необходимо ввести число, знак и второе число.";
            return new String[]{"ERROR"};
        }
        return splittedExpression;
    }

    public float evaluateResult(String expression) {
        isError = false;
        int result = checkExpression(expression);
        if (result == 0) {
            isError = true;
            return Float.MIN_VALUE;
        } else if (result == 1) {
            expression = addSpacesToExpression(expression);
        }
        String[] parsedExpression = parseExpression(expression);
        if (parsedExpression[0].equals("ERROR")) {
            isError = true;
            return Float.MIN_VALUE;
        }
        float num1, num2;
        num1 = Float.parseFloat(parsedExpression[0]);
        num2 = Float.parseFloat(parsedExpression[2]);
        if (parsedExpression[1].equals("+")) {
            history[currentPosition] = expression + " = " + num1 + num2;
            currentPosition++;
            return num1 + num2;
        } else if (parsedExpression[1].equals("-")) {
            history[currentPosition] = expression + " = " + (num1 - num2);
            currentPosition++;
            return num1 - num2;
        } else if (parsedExpression[1].equals("*")) {
            history[currentPosition] = expression + " = " + (num1 * num2);
            currentPosition++;
            return num1 * num2;
        } else if (parsedExpression[1].equals("/")) {
            history[currentPosition] = expression + " = " + (num1 / num2);
            currentPosition++;
            return num1 / num2;
        } else if (parsedExpression[1].equals("^")) {
            history[currentPosition] = expression + " = " + Math.pow(num1, num2);
            currentPosition++;
            return (float) Math.pow(num1, num2);
        } else {
            history[currentPosition] = expression + " = " + (num1 % num2);
            currentPosition++;
            return num1 % num2;
        }
    }


}
