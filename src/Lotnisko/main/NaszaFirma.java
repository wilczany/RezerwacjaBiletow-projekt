package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import loty.Lot;
import loty.ObslugaLotow;
import samoloty.*;
import trasy.Lotnisko;
import trasy.ObslugaTras;
import trasy.Trasa;
import uslugobiorcy.Firma;
import uslugobiorcy.Klient;
import uslugobiorcy.KlientIndywidualny;
import uslugobiorcy.ObslugaKlientow;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class NaszaFirma {
    public ObslugaTras obslugaTras = new ObslugaTras();
    public ObslugaSamolotow obslugaSamolotow = new ObslugaSamolotow();
    public ObslugaLotow obslugaLotow = new ObslugaLotow();
    public ObslugaKlientow obslugaKlientow = new ObslugaKlientow();
    //
    // ALBO TO
    // JEDNAK NIE TO, WYPIERDOLMY TO
    //
    /*
    public ArrayList<Lotnisko> lotniska = new ArrayList<>();
    public ArrayList<Trasa> trasy = new ArrayList<>();
    public ArrayList<Samolot> samoloty = new ArrayList<>();
    public ArrayList<Klient> klienci = new ArrayList<>();
    public ArrayList<Lot> loty = new ArrayList<>();
*/
    String n1, n2, n3;
    int m1, m2;

    private NaszaFirma() {
       Scanner scLotn, scTr, scSam, scKl, scLoty;
        try {
            File plik1 = new File("src/resources/lotniska.txt");
             scLotn = new Scanner(plik1);
            File plik2 = new File("src/resources/samoloty.txt");
             scSam = new Scanner(plik2);
            File plik3 = new File("src/resources/klienci.txt");
             scKl = new Scanner(plik3);
            File plik4 = new File("src/resources/loty.txt");
             scLoty = new Scanner(plik4);
            File plik5 = new File("src/resources/trasy.txt");
             scTr = new Scanner(plik5);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //odczyt lotnisk
        while (scLotn.hasNextLine()) {
            n1 = scLotn.next();
            m1 = scLotn.nextInt();
            m2 = scLotn.nextInt();
            Lotnisko l = new Lotnisko(n1, m1, m2);
            obslugaTras.getLotniska().add(l);
            System.out.println(l);
        } scLotn.close();

        //odczyt samolotow
        while (scSam.hasNextLine()) {
            String dane[] = scSam.nextLine().split(";");
            if(dane[0].equals("ATR")) {
                for (int i = 1; i < dane.length; i++) {
                    ATR s = new ATR(dane[i]);
                    obslugaSamolotow.getSamoloty().add(s);

                }
            }
            if(dane[0].equals("Boeing")) {
                for (int i = 1; i < dane.length; i++) {
                    Boeing s = new Boeing(dane[i]);
                    obslugaSamolotow.getSamoloty().add(s);

                }
            }
            if(dane[0].equals("Airbus")){
                for(int i=1;i<dane.length;i++){
                    Airbus s = new Airbus(dane[i]);
                    obslugaSamolotow.getSamoloty().add(s);

                }
            }
        } scSam.close();

        //odczyt klientow
        while (scKl.hasNextLine()) {
            String dane[] = scKl.nextLine().split(";");
            System.out.println(dane[0]);
            if(dane[0].equals("KlientIndywidualny")){
                Klient k = new KlientIndywidualny(dane[1],dane[2]);
                obslugaKlientow.getKlienci().add(k);
            }
            if(dane[0].equals("Firma")){
                Klient kl = new Firma(dane[1],dane[2]);
                obslugaKlientow.getKlienci().add(kl);
            }
        } scKl.close();

        //odczyt tras
        while (scTr.hasNextLine()) {
            String dane[] = scTr.nextLine().split(";");
            Lotnisko l1=new Lotnisko("1",1,1),l2=new Lotnisko("2",2,2);
            if(obslugaTras.sprawdzNazwe(dane[0]) && obslugaTras.sprawdzNazwe(dane[1])) {
                for (Lotnisko l : obslugaTras.getLotniska()) {
                    if (dane[0].equals(l.getNazwa())) l1 = l;
                    if (dane[1].equals(l.getNazwa())) l2 = l;
                }
                Trasa t = new Trasa(l1, l2);
                obslugaTras.getTrasy().add(t);
            }
        } scTr.close();

        //odczyt lotow
        while(scLoty.hasNextLine()){
            String dane[] = scLoty.nextLine().split(";");
            Samolot s = null; Trasa t = null;
            for(Samolot st : obslugaSamolotow.getSamoloty()){
                if(dane[0].equals(st.getID())) s=st;
            }

            Lotnisko l1=new Lotnisko("1",1,1),l2=new Lotnisko("2",2,2);
            if(obslugaTras.sprawdzNazwe(dane[1]) && obslugaTras.sprawdzNazwe(dane[2])) {
                for (Lotnisko l : obslugaTras.getLotniska()) {
                    if (dane[1].equals(l.getNazwa())) l1 = l;
                    if (dane[2].equals(l.getNazwa())) l2 = l;
                }
                t = new Trasa(l1, l2);
            }
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");
            LocalDateTime d = LocalDateTime.parse(dane[3],format);
            assert s != null;
            assert t != null;
            Lot lot = new Lot(t, s, d);
            obslugaLotow.getLoty().add(lot);
        } scLoty.close();

    }


    void zapis() throws Exception{
        /*
            PrintWriter zapis = new PrintWriter("src/resources/lotniska.txt");
            for(Lotnisko l : NaszaFirma.getInstance().obslugaTras.getLotniska()){
                zapis.println(l.getNazwa()+"\t"+l.getX()+"\t"+l.getY()+"\n");
                zapis.close();
            }
            zapis = new PrintWriter("src/resources/samoloty.txt");
            for(Samolot s : obslugaSamolotow.getSamoloty()){
                zapis.println(s.getClass().getSimpleName()+"\t"+s.getID()+"\t"+s.getMiejsca()+"\t"+s.getZasieg());
                zapis.close();
            }
            zapis = new PrintWriter("src/resources/klienci.txt");
            for(Klient k : obslugaKlientow.getKlienci()){
                String dane[] = k.getDane();
                zapis.println(k.getClass().getSimpleName()+"\t"+dane[0]+"\t"+dane[1]);
                zapis.close();
            }/*
            zapis = new PrintWriter("src/resources/loty.txt");
            for(Lot lo : obslugaLotow.getLoty()){
                zapis.println();
                zapis.close();
            }*//*
            zapis = new PrintWriter("src/resources/trasy.txt");
            //trasy ja ogarne bo to praca z lotniskami dodatkowo w logice
            for(Trasa t : obslugaTras.getTrasy()){
                Lotnisko lt[] = new Lotnisko[2];
                zapis.println(lt[0].getNazwa()+"\t"+lt[1].getNazwa());
                zapis.close();
            }
    */



    }

    public static NaszaFirma getInstance() {
        return inner.FIRMA;
    }
/*
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
*/
    public static class inner {
        private static final NaszaFirma FIRMA = new NaszaFirma();

    }



}
