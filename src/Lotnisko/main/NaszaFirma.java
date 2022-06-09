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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NaszaFirma{
    public ObslugaTras obslugaTras=new ObslugaTras();
    public ObslugaSamolotow obslugaSamolotow=new ObslugaSamolotow();
    public ObslugaLotow obslugaLotow=new ObslugaLotow();
    public ObslugaKlientow obslugaKlientow=new ObslugaKlientow();
    //
    //ALBO TO
    //
    public ArrayList<Lotnisko> lotniska = new ArrayList<>();
    public ArrayList<Trasa> trasy = new ArrayList<>();
    public ArrayList<Samolot> samoloty=new ArrayList<>();
    public ArrayList<Klient> klienci = new ArrayList<>();
    public ArrayList<Lot> loty = new ArrayList<>();

        private NaszaFirma() {
        }
        public static NaszaFirma getInstance(){
            return inner.FIRMA;
        }



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

    public static class inner {
    private static final NaszaFirma FIRMA= new NaszaFirma();

}



}


