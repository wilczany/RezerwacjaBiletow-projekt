package trasy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import main.Controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


//dodanie parametru do metod wypisujacych informacje dla uzytkownika, ktory by blokowal wypisywanie/przelaczal na tryb graficzny?

public class ObslugaTras extends Controller{
    private ArrayList<Lotnisko> lotniska = new ArrayList<Lotnisko>();
    private ArrayList<Trasa> trasy = new ArrayList<Trasa>();


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
        return true;
    }

    //Kontroler


        //TrasyController(ObslugaTras outer){this.outer=outer;}
        @FXML
        ListView<String> listLotniska;

        public void initialize(java.net.URL url, java.util.ResourceBundle rbndl){
            listLotniska.getItems().addAll(String.valueOf(lotniska));
        }

        @FXML
        public void dodajLotnisko(ActionEvent event) {
            //analogicznie do metody utworzLotnisko dodalem tą metodę
            //Analogicznie do wypisywania w konsoli i scannera
            Dialog<String> dialog = new TextInputDialog();
            dialog.setHeaderText("Podaj nazwę dla lotniska:");
            dialog.setContentText("Nazwa: ");
            Optional<String> result_nazwa = dialog.showAndWait();
            String nazwa = result_nazwa.get();


            dialog=new TextInputDialog();
            dialog.setHeaderText("Podaj Koordynaty:");
            dialog.setContentText("X= ");
            Optional<String> result_X = dialog.showAndWait();
            int x= Integer.parseInt(result_X.get());

            dialog=new TextInputDialog();
            dialog.setContentText("Y=");
            Optional<String> result_Y=dialog.showAndWait();
            int y=Integer.parseInt(result_Y.get());
            Lotnisko lll=new Lotnisko(nazwa,x,y);
            dodajLotnisko(lll);
            refresh();
            System.out.println(lll);




    }
    void refresh(){
            listLotniska.getItems().clear();
        for (Lotnisko l:lotniska
             ) {listLotniska.getItems().add(String.valueOf(l));

        }
    }
}