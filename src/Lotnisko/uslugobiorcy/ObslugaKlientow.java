package uslugobiorcy;

import loty.Bilet;

import java.util.ArrayList;

public class ObslugaKlientow {

    ArrayList<Klient> klienci = new ArrayList<>();

    public boolean sprawdzKlienta(String x, String y) {
        for (Klient k : klienci) {
            if (k.czyTenSam(x, y)) return true;
        }
        return false;
    }

    public void usunKlienta(Klient k) {
        for (Bilet b : k.getBilety()) {
            b.anuluj();
        }
        klienci.remove(k);
    }

    public void anulujBilet(Bilet b) {
        for (Klient k : klienci
        ) {
            for (Bilet bb : k.getBilety()
            ) {
                if (bb.getId() == b.getId()) {
                    k.bilety.remove(b);
                    return;
                }

            }
        }
    }

    public void refresh() {

    }

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    //Kontroler

}
