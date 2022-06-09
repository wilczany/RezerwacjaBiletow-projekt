package main;

import javafx.fxml.FXML;
import trasy.Lotnisko;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Controller {

    MainController mainController;
    NaszaFirma firma;


    public void setMainController(MainController mainController){
        this.mainController=mainController;
    }

    @FXML
    public void back() {
        mainController.goToMenu();
    }
    //public abstract void refresh();
    //Pobieranie list??


    //public abstract void initialize(java.net.URL url, java.util.ResourceBundle rbndl);

}
