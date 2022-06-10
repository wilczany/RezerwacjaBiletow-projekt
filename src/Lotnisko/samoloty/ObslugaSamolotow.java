package samoloty;

import Glowny.Controller;
import Glowny.NaszaFirma;

import java.util.ArrayList;

public class ObslugaSamolotow extends Controller {

    public ArrayList<Samolot> samoloty = new ArrayList<>();




    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }

    /**
     * dodaj samolot do listy
     * @param s obiekt samolotu
     */
    public void dodajSamolot(Samolot s) {
        for (Samolot sm : samoloty) {
            if (s.equals(sm)) return;
        }
        samoloty.add(s);
    }

    /**
     * Sprawdzenie czy istnieje samolot z takim samym ID
     * @param id
     * @return boolean
     */
    public boolean sprawdzID(String id) {
        for (Samolot s : samoloty) {
            if (id.equals(s.getID())) return true;
        }
        return false;
    }

    /**
     * usuwanie samolotu z listy
     *
     * @param s obiekt samolotu
     * @return czu udana operacja
     */
    public boolean usunSamolot(Samolot s) {
        if (NaszaFirma.getInstance().obslugaLotow.czySamolotUzywany(s)) return false;
        for (Samolot sm : samoloty) {
            if (sm.equals(s)) {
                NaszaFirma.getInstance().obslugaSamolotow.samoloty.remove(s);
                return true;
            }
        }
        return true;


    }

}