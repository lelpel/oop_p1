package ai151.khimchenko.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("http://icons.iconarchive.com/icons/dtafalonso/android-lollipop/512/MainCalculatorPanel-icon.png"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/calculator.fxml"));

        VBox root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setTitle("My calc");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
