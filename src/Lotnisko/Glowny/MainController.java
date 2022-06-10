package Glowny;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    Object firma = null;

    @FXML
    private StackPane mainStackPane;


    @FXML
    public void initialize() {
        goToMenu();
    }


    public void goToMenu() {
        FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("/fxml/menu.fxml"));
        Parent pane = null;
        try {
            pane = fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuController menu = fxml.getController();
        menu.setMainController(this);
        NaszaFirma.getInstance();
        setScreen(pane);
    }

    public void setScreen(Parent pane) {

        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);

    }

}
