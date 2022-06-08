package main;

import javafx.fxml.FXML;

import java.util.ArrayList;

public abstract class Controller {

    MainController mainController;
    NaszaFirma firma;

    public void setFirma(NaszaFirma firma) {
        this.firma = firma;
    }

    public void setMainController(MainController mainController){
        this.mainController=mainController;
    }

    @FXML
    public void back() {
        mainController.goToMenu();
    }
    public abstract void refresh();
    //Pobieranie list??
    protected ArrayList getTrasy(){

         return new ArrayList<>();
    }
    protected ArrayList getSamoloty(){

         return new ArrayList();
    }
    protected ArrayList getLoty(){

         return new ArrayList();
    }
    protected ArrayList getKlienci(){

         return new ArrayList();
    }

    //public abstract void initialize(java.net.URL url, java.util.ResourceBundle rbndl);

}
