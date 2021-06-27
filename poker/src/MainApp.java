package poker.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/fxml_example.fxml"));
    
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("Poker statistics");
        stage.setScene(scene);
        stage.show();
    }

}