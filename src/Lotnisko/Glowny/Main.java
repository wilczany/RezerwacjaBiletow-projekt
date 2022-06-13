package Glowny;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxml = null;
        fxml = new FXMLLoader(Main.class.getResource("/fxml/main-screen.fxml"));
        Scene scene = new Scene(fxml.load());


        stage.setTitle("WiatrLinia S.A.");
        Image ico = new Image("/ikona.jpg");

        stage.getIcons().clear();
        stage.getIcons().add(ico);
        stage.setResizable(false);


        stage.setScene(scene);
        stage.show();
    }
}
