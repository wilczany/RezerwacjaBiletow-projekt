package uslugobiorcy;

import main.Controller;
import main.MainController;

import java.util.ArrayList;

public class ObslugaKlientow extends Controller{
    ArrayList<Klient> klienci = new ArrayList<>();
    NaszaFirma firma;

    /**
     * Konstruktor
     * @param f obiekt firmy, główny interfejs
     */
    public ObslugaLotow(Firma f){
        this.firma = f;
    }

    public void refresh(){

    }
    //Kontroler

}
