package trasy;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import Glowny.NaszaFirma;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


//dodanie parametru do metod wypisujacych informacje dla uzytkownika, ktory by blokowal wypisywanie/przelaczal na tryb graficzny?

public class ObslugaTras {
    // NaszaFirma firma=NaszaFirma.getInstance();
    protected ArrayList<Lotnisko> lotniska = new ArrayList<>();
    ArrayList<Trasa> trasy = new ArrayList<>();
    //TrasyController(ObslugaTras outer){this.outer=outer;}
    @FXML
    ListView<String> listLotniska;

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }

    public ArrayList<Trasa> getTrasy() {
        return trasy;
    }

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
        if (!P) {
            lotniska.add(l);
            return true;
        }
        return false;
    }

    /**
     * Zwraca tablice otniks trasy
     * @param l1
     * @param l2
     * @return tablica
     */
    public Trasa znajdzTrase(Lotnisko l1, Lotnisko l2) {
        Trasa t = null;
        for (Trasa tr : trasy) {
            Lotnisko lt[] = tr.getLotniska();
            if (l1.equals(lt[0]) && l2.equals(lt[1])) return t;
        }
        return t;
    }

    /**
     * Usun lotniska z lsity lotnisk
     * @param l obiekt lotniska
     * @return powodzenie metody
     */
    public boolean usunLotnisko(Lotnisko l) {
        if (NaszaFirma.getInstance().obslugaLotow.czyLotniskoUzywane(l)) return false;
        ArrayList<Integer> doUsuniecia = new ArrayList<>();
        Integer i = 0;
        for (Trasa t : trasy) {
            Lotnisko lotn[] = t.getLotniska();
            if (l.equals(lotn[0]) || l.equals(lotn[1])) doUsuniecia.add(i);
            i++;
        }
        for (int j = doUsuniecia.size() - 1; j >= 0; j--) {
            System.out.println(trasy.get(doUsuniecia.get(j).intValue()));
            trasy.remove(doUsuniecia.get(j).intValue());
        }
        lotniska.remove(l);
        return true;
    }

    /**
     * usuwanie trasy z listy trasy
     * @param t obiekt trasy
     * @return powodzenie działania
     */
    public boolean usunTrase(Trasa t) {
        if (NaszaFirma.getInstance().obslugaLotow.czyTrasaUzywana(t)) return false;
        for (Trasa tr : trasy) {
            Lotnisko lt[] = t.getLotniska();
            if (t.equals(tr)) {
                trasy.remove(t);
                return true;
            }
        }
        return true;
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



    /**
     * do uzycia przy generowaniu lotu!!
     * @return boolean
     */
    public boolean sprawdzNazwe(String nazwa) {
        for (Lotnisko l : lotniska) {
            if (nazwa.equals(l.getNazwa())) return true;
        }
        return false;
    }
    /**
     * do uzycia przy generowaniu lotu!!
     * @return boolean
     */
    public boolean sprawdzKoordynaty(int x, int y) {
        for (Lotnisko l : lotniska) {
            if (x == l.getX() && y == l.getY()) return true;
        }
        return false;
    }
    /**
     * do uzycia przy generowaniu lotu!!
     * @return boolean
     */
    public boolean sprawdzTrase(Trasa tt) {
        for (Trasa t : trasy) {
            if (tt.equals(t)) return true;
        }
        return false;
    }

}