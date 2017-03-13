package ai151.khimchenko.controller;

import ai151.khimchenko.model.Model;
import ai151.khimchenko.model.Operator;
import ai151.khimchenko.view.controls.OperatorButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Создан Химченко М. в 02.03.2017.
 */
public class ArithmeticController implements Initializable {
    private Model model = new Model();
    private String tempOperand = "";
    private Operator lastOperator = Operator.NO_OPERATOR;
    private boolean isLastButtonNumeric = true;

    private boolean operand1Available = false;
    private boolean operand2Available = false;

    @FXML
    public Text resultText;

    private void updateResult(String value) {
        resultText.setText(value);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onNumericButtonClicked(ActionEvent event) {
        Button button = (Button) event.getTarget();

        isLastButtonNumeric = true;
        tempOperand += button.getText();
        updateResult(tempOperand);

    }

    public void onOperatorButtonClicked(ActionEvent event) {
        Operator op = ((OperatorButton) event.getSource()).getOperator();
        updateOperator(op);
        lastOperator = op;
        isLastButtonNumeric = false;
    }

    public void onClearButtonClicked() {
        updateResult("0");
        tempOperand = "";

        operand1Available = false;
        operand2Available = false;

        model.clearOperands();
        model.clearResult();

        lastOperator = Operator.CLEAR;
        isLastButtonNumeric = false;
    }

    public void onEqualButtonClicked() {
        if (!tempOperand.isEmpty()) {
            model.setOperand2(Double.parseDouble(tempOperand));
        }
        if (!lastOperator.equals(Operator.EQUAL)) {
            evaluate();
        }

        lastOperator = Operator.EQUAL;
        isLastButtonNumeric = false;
    }

    private void updateOperator(Operator operator) {
        if (lastOperator.equals(Operator.EQUAL)) {
            model.resultToFirstOperand();

            tempOperand = "";
            operand1Available = true;
        } else if (isLastButtonNumeric) {
            if (!operand1Available) {
                model.setOperand1(Double.parseDouble(tempOperand));

                tempOperand = "";
                operand1Available = true;
            } else if (!operand2Available) {
                if (!tempOperand.isEmpty()) {
                    model.setOperand2(Double.parseDouble(tempOperand));

                    evaluate();

                    model.resultToFirstOperand();
                    tempOperand = resultText.getText();
                    operand1Available = true;
                }
            }
        }
        model.setOperator(operator);
    }

    private void evaluate() {
        lastOperator = Operator.EQUAL;
        updateResult(String.valueOf(model.getResult()));
        operand2Available = false;
        model.clearOperands();
    }
}
