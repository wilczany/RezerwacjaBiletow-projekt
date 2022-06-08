package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import uslugobiorcy.ObslugaKlientow;
import loty.ObslugaLotow;
import trasy.ObslugaTras;

import java.io.IOException;

public class MenuController {

    private MainController mainController;
    public ObslugaTras ot= new ObslugaTras();

    @FXML
    public void openTrasy() {
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/trasy.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ot=fxml.getController();
        ot.setMainController(mainController);
        mainController.setScreen(root);
    }

    @FXML
    public void openLoty(){
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/loty.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObslugaLotow.LotyController control=fxml.getController();
        control.setMainController(mainController);
        mainController.setScreen(root);
    }

    public void openObsluga(){
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/ObslugaKlientow.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObslugaKlientow.KlienciController control=fxml.getController();
        control.setMainController(mainController);
        mainController.setScreen(root);
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

    public void setMainCont(MainController mainCont) {
        this.mainController = mainCont;
    }
}
