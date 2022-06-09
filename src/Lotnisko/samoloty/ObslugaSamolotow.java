package samoloty;

import javafx.fxml.FXML;
import loty.Lot;
import main.Controller;

import java.util.ArrayList;
import main.NaszaFirma;

public class ObslugaSamolotow extends Controller{
        ArrayList<Samolot> samoloty;

        //FXML



        //Kontroler

        public void dodajSamolot(Samolot s){
                for(Samolot sm : samoloty){
                        if(s.equals(sm)) return;
                }
                samoloty.add(s);
        }

        public void usunSamolot(String ID){
                int i=0, j=-1;
                for(Samolot sm : samoloty){
                        if(sm.getID().equals(ID)) j=i;
                        i++;
                }
                if(j!=-1) samoloty.remove(j);
                else return;

                /*for(Lot l : NaszaFirma.getInstance().obslugaLotow.loty){
                        //if(l.getSamolot().getID().equals(ID)) NaszaFirma.getInstance().obslugaLotow.anulujLot(l);
                }*/

        }

}