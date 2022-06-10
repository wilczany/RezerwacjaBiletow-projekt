package Glowny;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Nasza firma, za jej pomocą pracujemy na wszystkich danych
 */

public class NaszaFirma {
    public ObslugaTras obslugaTras = new ObslugaTras();
    public ObslugaSamolotow obslugaSamolotow = new ObslugaSamolotow();
    public ObslugaLotow obslugaLotow = new ObslugaLotow();
    public ObslugaKlientow obslugaKlientow = new ObslugaKlientow();



    String n1;
    int m1, m2;

    /**
     * Konstruktor naszej firmy, automatycznie czyta dane z plików po utworzeniu obiektu
     */
    private NaszaFirma() {
        Scanner scLotn, scTr, scSam, scKl, scLoty;
        /**
         * Wczytywanie plikow
         */
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //odczyt lotnisk
        odczytLotnisk(scLotn);
        scLotn.close();

        //odczyt samolotow
        odczytSamolotow(scSam);
        scSam.close();

        //odczyt klientow
        odczytKlientow(scKl);
        scKl.close();

        //odczyt tras
        odczytTras(scTr);
        scTr.close();

        odczytLotow(scLoty);
        scLoty.close();
    }

    /**
     * Odczytywanie danych lotniska z wczytanego pliku
     * @param scLotn
     */
    private void odczytLotnisk(Scanner scLotn) {

        while (scLotn.hasNextLine()) {
            try{n1 = scLotn.next();}catch (Exception e){
                return;
            }

            if(n1.equals("")) return;
            m1 = scLotn.nextInt();
            m2 = scLotn.nextInt();
            Lotnisko l = new Lotnisko(n1, m1, m2);
            obslugaTras.getLotniska().add(l);
        }
    }

    /**
     * Odczytywanie danych samolotu z wczytanego pliku
     * @param scSam
     */
    private void odczytSamolotow(Scanner scSam) {
        while (scSam.hasNextLine()) {
            String dane[] = scSam.nextLine().replace("\n","").split(";");
            if(dane[0].equals("")) return;
            if (dane[0].equals("ATR")) {
                for (int i = 1; i < dane.length; i++) {
                    ATR s = new ATR(dane[i]);
                    obslugaSamolotow.getSamoloty().add(s);

                }
            }
            if (dane[0].equals("Boeing")) {
                for (int i = 1; i < dane.length; i++) {
                    Boeing s = new Boeing(dane[i]);
                    obslugaSamolotow.getSamoloty().add(s);

                }
            }
            if (dane[0].equals("Airbus")) {
                for (int i = 1; i < dane.length; i++) {
                    Airbus s = new Airbus(dane[i]);
                    obslugaSamolotow.getSamoloty().add(s);

                }
            }
        }
    }

    /**
     * Odczytywanie danych klienta z wczytanego pliku
     * @param scKl
     */
    private void odczytKlientow(Scanner scKl) {
        while (scKl.hasNextLine()) {
            String dane[] = scKl.nextLine().replace("\n", "").split(";");
            if (dane[0].equals("")) return;
            if (dane[0].equals("KlientIndywidualny")) {
                Klient k = new KlientIndywidualny(dane[1], dane[2]);
                obslugaKlientow.getKlienci().add(k);
            }
            if (dane[0].equals("Firma")) {
                Klient kl = new Firma(dane[1], dane[2]);
                obslugaKlientow.getKlienci().add(kl);
            }
        }
    }

    /**
     * Odczytywanie danych trasy z wczytanego pliku
     * @param scTr
     */
    private void odczytTras(Scanner scTr) {
        while (scTr.hasNextLine()) {
            String[] dane = scTr.nextLine().replace("\n","").split(";");
            if(dane[0].equals("")) return;
            Lotnisko l1 = new Lotnisko("1", 1, 1), l2 = new Lotnisko("2", 2, 2);
            if (obslugaTras.sprawdzNazwe(dane[0]) && obslugaTras.sprawdzNazwe(dane[1])) {
                for (Lotnisko l : obslugaTras.getLotniska()) {
                    if (dane[0].equals(l.getNazwa())) l1 = l;
                    if (dane[1].equals(l.getNazwa())) l2 = l;
                }
                Trasa t = new Trasa(l1, l2);
                obslugaTras.getTrasy().add(t);
            }
        }
    }

    /**
     * Odczytywanie danych lotu z wczytanego pliku
     * @param scLoty
     */
    private void odczytLotow(Scanner scLoty) {
        while(scLoty.hasNextLine()){
            String[] dane = scLoty.nextLine().replace("\n","").split(";");
            if(dane[0].equals("")) return;
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
            if(t != null && s!= null) { Lot lot = new Lot(t, s, d); obslugaLotow.getLoty().add(lot); }
        }
        scLoty.close();
    }

    /**
     * Użycie wzorca Singleton, zapewnienie tylko jednego obiektu danej klasy
     * @return
     */
    public static NaszaFirma getInstance() {
        return inner.FIRMA;
    }


    void zapis() throws Exception {

        zapisLotnisk();

        zapisSamolotow();

        zapisKlientow();

        zapisLotow();


    }

    /**
     * Zapisuje lotniska do pliku src/resources/lotniska.txt oraz trasy do pliku src/resources/trasy.txt
     * @throws FileNotFoundException
     */

    private void zapisLotnisk() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("src/resources/lotniska.txt");
        for(Lotnisko l : NaszaFirma.getInstance().obslugaTras.getLotniska()){
            zapis.print(l.getNazwa()+" "+l.getX()+" "+l.getY()+"\n");
        }
        zapis.close();
        zapis = new PrintWriter("src/resources/trasy.txt");

        for(Trasa t : obslugaTras.getTrasy()){
            Lotnisko[] lt =t.getLotniska();
            zapis.println(lt[0].getNazwa()+";"+lt[1].getNazwa());
        }
        zapis.close();
    }

    /**
     * Zapisuje klientów do pliku src/resources/klienci.txt
     * @throws FileNotFoundException
     */
    private void zapisKlientow() throws FileNotFoundException {
        PrintWriter zapis;
        zapis = new PrintWriter("src/resources/klienci.txt");
        for(Klient k : obslugaKlientow.getKlienci()){
            String[] dane = k.getDane();
            zapis.println(k.getClass().getSimpleName()+";"+dane[0]+";"+dane[1]);
        }
        zapis.close();
    }

    /**
     * Zapisuje loty do pliku src/resources/loty.txt
     * @throws FileNotFoundException
     */
    private void zapisLotow() throws FileNotFoundException {
        PrintWriter zapis;
        zapis = new PrintWriter("src/resources/loty.txt");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");

        for(Lot lo : obslugaLotow.getLoty()){
            zapis.println(lo.getSamolot().getID()+";"+
                    lo.getTrasa().getLotniska()[0].getNazwa()+";"+
                    lo.getTrasa().getLotniska()[1].getNazwa()+";"+
                    lo.getData().format(format)+";"
                    );
        }
        zapis.close();
    }

    /**
     * Zapisuje samoloty do pliku src/resources/samoloty.txt
     * @throws FileNotFoundException
     */
    private void zapisSamolotow() throws FileNotFoundException {
        PrintWriter zapis;
        zapis = new PrintWriter("src/resources/samoloty.txt");

        zapis.print(Airbus.class.getSimpleName());
        for(Samolot s: obslugaSamolotow.getSamoloty()){
            if(s.getClass()==Airbus.class){
                zapis.print(";"+s.getID());
            }
        }
        zapis.print("\n"+Boeing.class.getSimpleName());
        for(Samolot s: obslugaSamolotow.getSamoloty()){
            if(s.getClass()==Boeing.class){
                zapis.print(";"+s.getID());
            }
        }
        zapis.print("\n"+ATR.class.getSimpleName());
        for(Samolot s: obslugaSamolotow.getSamoloty()){
            if(s.getClass()==ATR.class){
                zapis.print(";"+s.getID());
            }
        }
        zapis.close();
    }

    /**
     * Statyczna klasa wewnętrzna
     */
    private static class inner {
        private static final NaszaFirma FIRMA = new NaszaFirma();

    }


}
