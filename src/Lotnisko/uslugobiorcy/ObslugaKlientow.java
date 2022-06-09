package uslugobiorcy;

import loty.Bilet;
import main.Controller;
import main.MainController;
import main.NaszaFirma;

import java.util.ArrayList;

public class ObslugaKlientow {

    ArrayList<Klient>klienci=new ArrayList<>();

    public void anulujBilet(Bilet b){
        for (Klient k:klienci
             ) {
            for (Bilet bb:k.getBilety()
                 ) {
                if(bb.getId()==b.getId()){
                    k.bilety.remove(b);
                    return;
                }

            }
        }
    }
    public void refresh(){

    }

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    //Kontroler

}
