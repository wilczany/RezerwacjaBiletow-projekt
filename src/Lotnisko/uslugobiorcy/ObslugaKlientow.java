package uslugobiorcy;

import loty.Bilet;
import main.Controller;
import main.MainController;
import main.NaszaFirma;

import java.util.ArrayList;

public class ObslugaKlientow extends Controller{

    NaszaFirma firma;

    public void anulujBilet(Bilet b){
        for (Klient k:firma.getKlienci()
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
    //Kontroler

}
