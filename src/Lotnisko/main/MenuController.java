package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import loty.LotyController;
import samoloty.SamolotyController;
import trasy.*;
import uslugobiorcy.KlienciController;

import java.io.IOException;

public class MenuController {
    @FXML
    MainController mainController;
    LotyController lotyController;
    TrasyController trasyController;
    KlienciController klienciController;
    SamolotyController samolotyController;



    @FXML
    public void openTrasy() {
        Parent root= null;
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/trasy.fxml"));
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        trasyController =fxml.getController();

        trasyController.setMainController(mainController);

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

        lotyController=fxml.getController();

        lotyController.setMainController(mainController);

        mainController.setScreen(root);
    }

    public void openSamoloty(){
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/Samoloty.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        samolotyController =fxml.getController();
        samolotyController.setMainController(mainController);
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
        klienciController =fxml.getController();
        klienciController.setMainController(mainController);
        mainController.setScreen(root);
    }

    @FXML
    public void exit(){
        Platform.exit();
    }


    public void setMainController(MainController mainController){
        this.mainController=mainController;
    }

}
