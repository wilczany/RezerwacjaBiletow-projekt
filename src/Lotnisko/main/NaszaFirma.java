package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import loty.ObslugaLotow;
import samoloty.ObslugaSamolotow;
import trasy.ObslugaTras;
import uslugobiorcy.ObslugaKlientow;

import java.io.IOException;

public class NaszaFirma{
    @FXML
    MainController mainController;
    ObslugaLotow lotyController;
    ObslugaTras trasyController;
    ObslugaKlientow klienciController;
    ObslugaSamolotow samolotyController;


    ObslugaLotow loty=new ObslugaLotow();
    ObslugaTras trasy=new ObslugaTras();
    ObslugaKlientow klienci=new ObslugaKlientow();
    ObslugaSamolotow samoloty=new ObslugaSamolotow();

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
        trasyController.setFirma(this);
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


