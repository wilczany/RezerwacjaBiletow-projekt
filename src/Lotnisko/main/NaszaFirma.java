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

public class NaszaFirma {
    public ObslugaTras obslugaTras = new ObslugaTras();
    public ObslugaSamolotow obslugaSamolotow = new ObslugaSamolotow();
    public ObslugaLotow obslugaLotow = new ObslugaLotow();
    public ObslugaKlientow obslugaKlientow = new ObslugaKlientow();
    //
    // ALBO TO
    //
    public ArrayList<Lotnisko> lotniska = new ArrayList<>();
    public ArrayList<Trasa> trasy = new ArrayList<>();
    public ArrayList<Samolot> samoloty = new ArrayList<>();
    public ArrayList<Klient> klienci = new ArrayList<>();
    public ArrayList<Lot> loty = new ArrayList<>();

    String n1, n2;
    int m1, m2;

    private NaszaFirma() {
        File plik1 = new File("/resources/lotniska.txt");
        Scanner sc1 = new Scanner(plik1);
        File plik2 = new File("/resources/samoloty.txt");
        Scanner sc2 = new Scanner(plik2);
        File plik3 = new File("/resources/klienci.txt");
        Scanner sc3 = new Scanner(plik3);
        File plik4 = new File("/resources/loty.txt");
        Scanner sc4 = new Scanner(plik4);
        File plik5 = new File("/resources/bilety.txt");
        Scanner sc5 = new Scanner(plik5);
        while (sc1.hasNextLine()) {
            n1 = sc1.next();
            m1 = sc1.nextInt();
            m2 = sc1.nextInt();
            Lotnisko l = new Lotnisko(n1, m1, m2);
            lotniska.add(l);
        }
        while (sc2.hasNextLine()) {
            n1 = sc2.next();
            m1 = sc2.nextInt();
            m2 = sc2.nextInt();
            Samolot s = new Samolot(n1, m1, m2);
            samoloty.add(l);
        }
        while (sc3.hasNextLine()) {
            n1 = sc3.next();
            n2 = sc3.next();
            Klienc l = new Klienc(n1, n2);
            klienci.add(l);
        }

    }

    public static NaszaFirma getInstance() {
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
        private static final NaszaFirma FIRMA = new NaszaFirma();

    }

}
