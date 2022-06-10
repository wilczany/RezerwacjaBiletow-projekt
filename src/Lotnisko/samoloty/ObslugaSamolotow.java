package samoloty;

import Glowny.Controller;
import Glowny.NaszaFirma;

import java.util.ArrayList;

public class ObslugaSamolotow extends Controller {

    public ArrayList<Samolot> samoloty = new ArrayList<>();

    //FXML


    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }


    public void dodajSamolot(Samolot s) {
        for (Samolot sm : samoloty) {
            if (s.equals(sm)) return;
        }
        samoloty.add(s);
    }

    public boolean sprawdzID(String id) {
        for (Samolot s : samoloty) {
            if (id.equals(s.getID())) return true;
        }
        return false;
    }

    public boolean usunSamolot(Samolot s) {
        if (NaszaFirma.getInstance().obslugaLotow.czySamolotUzywany(s)) return false;
        for (Samolot sm : samoloty) {
            if (sm.equals(s)) {
                NaszaFirma.getInstance().obslugaSamolotow.samoloty.remove(s);
                return true;
            }
        }
        return true;

                /*for(Lot l : NaszaFirma.getInstance().obslugaLotow.loty){
                        //if(l.getSamolot().getID().equals(ID)) NaszaFirma.getInstance().obslugaLotow.anulujLot(l);
                }*/

    }

}