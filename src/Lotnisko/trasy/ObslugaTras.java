package trasy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import main.Controller;
import main.NaszaFirma;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;


//dodanie parametru do metod wypisujacych informacje dla uzytkownika, ktory by blokowal wypisywanie/przelaczal na tryb graficzny?

public class ObslugaTras{

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }

    // NaszaFirma firma=NaszaFirma.getInstance();
    ArrayList<Lotnisko>lotniska=new ArrayList<>();
    ArrayList<Trasa>trasy=new ArrayList<>();
    /**
     * @param l
     * @return boolean
     */
    public boolean dodajLotnisko(Lotnisko l) {
        //na wyjatki zmienic 

        //P -- czy lotnisko juz jest dodane
        boolean P = false;
        for (Lotnisko lt : lotniska) {
            if (l.equals(lt)) {
                P = true;
                break;
            }
        }
        if (P == false) {
            lotniska.add(l);
            return true;
        }
        return false;
    }

    /**
     * @param t
     * @return boolean
     */
    public boolean dodajTrase(Trasa t) {
        //na wyjatki zmienic

        //P - czy trasa juz jest dodana
        //L1, L2 - czy lotnisko 1/2 jest w naszej bazie lotnisk
        //l[] - lotniska dodawanej trasy
        boolean P = false, L1 = false, L2 = false;
        Lotnisko[] l = t.getLotniska();
        for (Lotnisko lt : lotniska) {
            if (l[0].equals(lt)) L1 = true;
            else if (l[1].equals(lt)) L2 = true;
            if (L1 && L2) break;
        }
        if (!L1 || !L2) return false;
        for (Trasa tr : trasy) {
            if (t.equals(tr)) {
                P = true;
                break;
            }
        }
        if (P == false) {
            trasy.add(t);
            return true;
        }
        return false;
    }

    double wyliczZasieg(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }


    /**
     * @return boolean
     */
    //do uzycia przy generowaniu lotu!!
    
    public boolean utworzTrase() {
        Scanner scan = new Scanner(System.in);
        int nr;

        System.out.println("Wybierz lotnisko początkowe spośród niżej podanych. ");
        int i = 1;
        for (Lotnisko l : lotniska) {
            System.out.println(i++ + ". " + l.toString());
        }

        System.out.print("Numer wybranego: ");
        nr = scan.nextInt() - 1;
        while (nr < 0 || nr > lotniska.size() - 1) {
            System.out.print("Podaj prawidłowy numer lotniska :");
            nr = scan.nextInt() - 1;
        }
        Lotnisko l1 = lotniska.get(nr);
        lotniska.add(l1);
        lotniska.remove(nr);

        System.out.println("Wybierz lotnisko końcowe spośród niżej podanych. ");
        i = 1;
        for (Lotnisko l : lotniska) {
            if (!(l.equals(l1))) System.out.println(i++ + ". " + l.toString());
        }
        System.out.print("Numer wybranego: ");
        nr = scan.nextInt() - 1;
        while (nr < 0 || nr > lotniska.size() - 2) {
            System.out.print("Podaj prawidłowy numer lotniska :");
            nr = scan.nextInt() - 1;
        }
        scan.close();
        Lotnisko l2 = lotniska.get(nr);
        Trasa t = new Trasa(l1, l2);
        if (dodajTrase(t)) return true;
        System.out.println("Dodawanie się nie powiodło, trasa jest duplikatem istniejącej.");
        return false;
    }

    private boolean sprawdzNazwe(String nazwa) {
        for (Lotnisko l : lotniska) {
            if (nazwa.equals(l.getNazwa())) return true;
        }
        return false;
    }

    private boolean sprawdzKoordynaty(int x, int y) {
        for (Lotnisko l : lotniska) {
            if (x == l.getX() && y == l.getY()) return true;
        }
        return false;
    }

    //jakkolwiek ta nazwa brzmi..
    public boolean utworzLotnisko() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwę dla lotniska: ");
        String nazwa = scan.nextLine();
        while (sprawdzNazwe(nazwa)) {
            System.out.print("'" + nazwa + "' jest już zajęte, podaj inną nazwę: ");
            nazwa = scan.nextLine();
        }
        System.out.print("Podaj koordynaty dla lotniska.\nx: ");
        int x = scan.nextInt();
        System.out.print("y: ");
        int y = scan.nextInt();
        while (sprawdzKoordynaty(x, y)) {
            System.out.print("Koordynaty (" + x + "," + y + ") są już zajęte, podaj inne.\nx: ");
            x = scan.nextInt();
            System.out.print("y: ");
            y = scan.nextInt();
        }
        Lotnisko lt = new Lotnisko(nazwa, x, y);
        lotniska.add(lt);
        scan.close();
        return true;
    }

    //rozszerzyc o usuwanie rowniez lotow
    public boolean usunLotnisko(String nazwa) {
        for (Lotnisko l : lotniska) {
            if (nazwa.equals(l.getNazwa())) lotniska.remove(l);
        }
        for (Trasa t : trasy) {
            if (nazwa.equals(t.getLotniska()[0].getNazwa()) || nazwa.equals(t.getLotniska()[1].getNazwa()))
                trasy.remove(t);
        }
        /*
        for(Lot l : loty){
            if (nazwa.equals(l.getTrasa().getLotniska()[0].getNazwa()) || nazwa.equals(l.getTrasa().getLotniska()[0].getNazwa())) ObslugaLotow.anulujLot(ten lot);
        }
        */
        return true;
    }

    //rozszerzyc o usuwanie rowniez lotow
    //moze inne parametry? przy usuwaniu interfejsem wystarczyc powinien obiekt trasy?
    public boolean usunTrase(String nazwa1, String nazwa2) {
        Lotnisko[] lt = new Lotnisko[2];
        for (Trasa t : trasy) {
            lt = t.getLotniska();
            if (nazwa1.equals(lt[0].getNazwa()) && nazwa2.equals(lt[0].getNazwa())) trasy.remove(t);
        }
        /*
        for(Lot l : loty){
            if (nazwa.equals(l.getTrasa().getLotniska()[0].getNazwa()) && nazwa.equals(l.getTrasa().getLotniska()[0].getNazwa())) ObslugaLotow.anulujLot(ten lot);
        }
        */
        return true;
    }

    //Kontroler


        //TrasyController(ObslugaTras outer){this.outer=outer;}
        @FXML
        ListView<String> listLotniska;



    public void refresh(){
            ArrayList<Lotnisko>llll=new ArrayList<>();
            llll=lotniska;
            listLotniska.getItems().clear();
        for (Lotnisko l:llll
             ) {listLotniska.getItems().add(String.valueOf(l));
                System.out.println(l);
        }

    }
    public void odczyt(){
        // public void getLotniska() {
        ArrayList<Lotnisko> lotniska2=new ArrayList<>();
        String nazwa;
        int x, y;
        Scanner scan=null;
        File plik=new File("src/resources/Lotniska.txt");
        try {scan = new Scanner(plik);}catch (Throwable t){
            System.out.println("wyjatek");
        }
        while (scan.hasNextLine()) {

            nazwa=scan.next();
            x=scan.nextInt();
            y=scan.nextInt();
            System.out.println(nazwa+" "+x+y);
            Lotnisko l=new Lotnisko(nazwa,x,y);
            lotniska.add(l);
            System.out.println(l);
        }
        lotniska=lotniska2;
        // }
        System.out.println("odczyt");
    }
}