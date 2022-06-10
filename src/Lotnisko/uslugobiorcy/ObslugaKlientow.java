package uslugobiorcy;

import loty.Bilet;

import java.util.ArrayList;

public class ObslugaKlientow {

    ArrayList<Klient> klienci = new ArrayList<>();

    /**
     * Porownanie dowolnego klienta
     * @param x
     * @param y
     * @return
     */
    public boolean sprawdzKlienta(String x, String y) {
        for (Klient k : klienci) {
            if (k.czyTenSam(x, y)) return true;
        }
        return false;
    }

    /**
     * usun klienta z listy klientow
     * @param k obiekt klienta
     */
    public void usunKlienta(Klient k) {
        for (Bilet b : k.getBilety()) {
            b.anuluj();
        }
        klienci.remove(k);
    }

    /**
     * Szukamy posiadacza biletu, a nastepnie anulujemy biet
     * @param b obiekt biletu
     */
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


    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    //Kontroler

}
