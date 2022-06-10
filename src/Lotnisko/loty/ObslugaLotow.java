package loty;

import samoloty.Samolot;
import trasy.Lotnisko;
import trasy.Trasa;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Klasa obsługująca zadania na lotach
 */
public class ObslugaLotow {


    ArrayList<Lot> loty = new ArrayList<>();

    /**
     * Dodawanie lotow
     *
     * @param t    trasa lotu
     * @param s    samolot przeznaczony na lot
     * @param data data lotu
     * @throws ZasiegException        wyjetek w wypadku za krotkiego zasiegu samolotu
     * @throws SamolotZajetyException wyjatek w wypadku zlej daty
     */


    void dodajLot(Trasa t, Samolot s, LocalDateTime data) throws LotyException {

        if (s.getZasieg() < t.getDystans())
            throw new ZasiegException("Samolot ma za krotki zasieg!", s, t.getDystans());
        for (Lot l : loty) {
            if (l.getSamolot() == s) {
                if ((data.isAfter(l.getData()) || data.isEqual(l.getData())) && (data.isBefore(l.getPrzylot()) || data.isEqual(l.getPrzylot())))
                    throw new SamolotZajetyException("Samlot jest zajety w tym czasie!", s, l.getData(), l.getPrzylot());
            }

        }

        loty.add(new Lot(t, s, data));

    }

    /**
     * Dodawanie powtarzajacych sie lotow
     *
     * @param l    lot do skopiowania danych
     * @param data data nastepnego lotu
     * @throws ZasiegException        wyjetek w wypadku za krotkiego zasiegu samolotu
     * @throws SamolotZajetyException wyjatek w wypadku zlej daty
     */

    void dodajLot(Lot l, LocalDateTime data) throws LotyException {
        //if(l.getSamolot().getZasieg()<l.getTrasa().getDystans()) throw new ZasiegException("Samolot ma za krotki zasieg!",l.getSamolot(),l.getTrasa().getDystans());
        for (Lot locik : loty) {
            if (l.getSamolot() == locik.getSamolot()) {
                if ((data.isAfter(locik.getData()) || data.isEqual(locik.getData())) && (data.isBefore(locik.getPrzylot()) || data.isEqual(locik.getPrzylot())))
                    throw new SamolotZajetyException("Samlot jest zajety w tym czasie!", l.getSamolot(), locik.getData(), locik.getPrzylot());
            }

        }

        loty.add(new Lot(l, data));

    }

    /**
     * Dodawanie lotu, oraz lotu powrotnego
     *
     * @param t      trasa pierwszego lotu
     * @param s      Samolot przeznaczony dla lotu
     * @param data   data lotu
     * @param powrot data powrotu
     * @throws ZasiegException        wyjetek w wypadku za krotkiego zasiegu samolotu
     * @throws SamolotZajetyException wyjatek w wypadku zlej daty
     */

    void dodajLot(Trasa t, Samolot s, LocalDateTime data, LocalDateTime powrot) throws LotyException {
        if (s.getZasieg() < t.getDystans())
            throw new ZasiegException("Samolot ma za krotki zasieg!", s, t.getDystans());
        for (Lot l : loty) {
            if (s == l.getSamolot()) {
                if ((data.isAfter(l.getData()) || data.isEqual(l.getData())) && (data.isBefore(l.getPrzylot()) || data.isEqual(l.getPrzylot())))
                    throw new SamolotZajetyException("Samlot jest zajety w tym czasie!", s, l.getData(), l.getPrzylot());
                if ((powrot.isAfter(l.getData()) || powrot.isEqual(l.getData())) && (powrot.isBefore(l.getPrzylot()) || powrot.isEqual(l.getPrzylot())))
                    throw new SamolotZajetyException("Samlot jest zajety w tym czasie!", s, l.getData(), l.getPrzylot());
            }

        }

    }

    //tutaj zjebalem, bo chyba logike zrobilem w kontrolerze uhh
    private void anulujLot(Lot l) {
        for (Bilet b : l.getBilety()) {
            // if(!b.czyZajety())

        }


    }

    public boolean czyLotniskoUzywane(Lotnisko l) {
        for (Lot lot : loty) {
            Lotnisko lotniska[] = lot.getTrasa().getLotniska();
            if (l.equals(lotniska[0]) || l.equals(lotniska[1])) return true;
        }
        return false;
    }

    public boolean czyTrasaUzywana(Trasa t) {
        for (Lot lot : loty) {
            if (t.equals(lot.getTrasa())) return true;
        }
        return false;
    }

    public boolean czySamolotUzywany(Samolot s) {
        for (Lot lot : loty) {
            if (s.equals(lot.getSamolot())) return true;
        }
        return false;
    }

    public ArrayList<Lot> getLoty(Trasa t) throws BrakLotowException {
        ArrayList<Lot> lotyNaTrasie = new ArrayList<>();
        for (Lot l : loty) {
            if (l.getTrasa() == t) lotyNaTrasie.add(l);
        }
        if (!lotyNaTrasie.isEmpty())
            return (lotyNaTrasie);
        throw new BrakLotowException("Brak lotow na trasie!", t);
    }

    public ArrayList<Lot> getLoty() {
        return loty;
    }


}
