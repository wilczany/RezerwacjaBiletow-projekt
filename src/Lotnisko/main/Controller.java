package main;

import javafx.fxml.FXML;

public abstract class Controller {

    static MainController main;

    public void setMainController(MainController mainController){
        main= mainController;
    }
    @FXML
    public void back() {
        main.goToMenu();
    }

    //public abstract void initialize(java.net.URL url, java.util.ResourceBundle rbndl);

}
