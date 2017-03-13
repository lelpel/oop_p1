package ai151.khimchenko.view.controls;

import ai151.khimchenko.model.Operator;
import javafx.beans.NamedArg;
import javafx.scene.control.Button;

/**
 * Создан Химченко М. в 30.11.2016.
 */
public class OperatorButton extends Button {
    private Operator operator;

    public OperatorButton(@NamedArg("text") String text, @NamedArg("operator") String operator) {
        super(text);
        this.operator = Operator.valueOf(operator);
    }

    public Operator getOperator() {
        return operator;
    }
}
