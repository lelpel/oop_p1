package ai151.khimchenko.view.controls;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

/**
 * Создан Химченко М. в 22.11.2016.
 */
public class TextFieldWithCaption extends TilePane {
    public TextFieldWithCaption(@NamedArg("title") String caption) {
        super();
        setTileAlignment(Pos.TOP_LEFT);
        setPrefColumns(2);

        Text label = new Text(caption);
        TextField textField = new TextField("Ввод значения");
        getChildren().addAll(label, textField);
    }
}
