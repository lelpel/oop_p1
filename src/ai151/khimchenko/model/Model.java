package ai151.khimchenko.model;


/**
 * Создан Химченко М. в 30.11.2016.
 */
public class Model {
    private double operand1;
    private double operand2;
    private double result;

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    private Operator operator;

    private void evaluate() {
        switch (operator) {
            case ADDITION:
                result = operand1 + operand2;
                break;
            case SUBTRACTION:
                result = operand1 - operand2;
                break;
            case MULTIPLICATION:
                result = operand1 * operand2;
                break;
            case DIVISION:
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("На ноль делить нельзя");
                }
                break;
            default:
                System.err.println("Данный оператор не поддеррживается");
        }
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public void clearOperands() {
        operand1 = 0;
        operand2 = 0;
    }

    public void clearResult() {
        result = 0;
    }

    public void resultToFirstOperand() {
        operand1 = result;
        operand2 = 0;
    }

    public double getResult() {
        evaluate();
        return result;
    }
}
