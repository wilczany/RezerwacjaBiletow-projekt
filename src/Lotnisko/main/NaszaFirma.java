package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import loty.Lot;
import loty.ObslugaLotow;
import samoloty.ObslugaSamolotow;
import samoloty.Samolot;
import trasy.Lotnisko;
import trasy.ObslugaTras;
import trasy.Trasa;
import uslugobiorcy.Klient;
import uslugobiorcy.ObslugaKlientow;

import java.io.IOException;
import java.util.ArrayList;

public class NaszaFirma{
    public ArrayList<Lotnisko> lotniska = new ArrayList<Lotnisko>();
    public ArrayList<Trasa> trasy = new ArrayList<Trasa>();
    public ArrayList<Samolot> samoloty=new ArrayList<>();
    public ArrayList<Klient> klienci = new ArrayList<>();
    public ArrayList<Lot> loty = new ArrayList<>();

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }

    public ArrayList<Trasa> getTrasy() {
        return trasy;
    }

    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    public ArrayList<Lot> getLoty() {
        return loty;
    }

    @FXML
    MainController mainController;
    ObslugaLotow lotyController;
    ObslugaTras trasyController=new ObslugaTras();
    ObslugaKlientow klienciController;
    ObslugaSamolotow samolotyController;
/*
Array
getArray

0 */


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


