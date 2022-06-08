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

public class NaszaFirma extends Controller{
    ObslugaLotow obslugaLotow;
    ObslugaTras obslugaTras;
    ObslugaKlientow obslugaKlientow;
    ObslugaSamolotow obslugaSamolotow;
    @FXML
    public void initiaize(){


    }

    @FXML
    public void openTrasy() {
        Parent root= null;
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/trasy.fxml"));
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        obslugaTras=fxml.getController();
        obslugaTras.setMainController(mainController);
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

        obslugaLotow=fxml.getController();
        obslugaLotow.setMainController(mainController);


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
        obslugaSamolotow=fxml.getController();
        obslugaSamolotow.setMainController(mainController);
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
        obslugaKlientow=fxml.getController();
        obslugaKlientow.setMainController(mainController);
        mainController.setScreen(root);
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

}


