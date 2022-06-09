package samoloty;

import javafx.fxml.FXML;
import loty.Lot;
import main.Controller;

import java.util.ArrayList;
import main.NaszaFirma;

public class ObslugaSamolotow extends Controller{
        NaszaFirma firma;
        ArrayList<Samolot>samoloty;

        //FXML



        //Kontroler
        //ArrayList<Lot> loty; jednak UML troszke przestarzaly xDD

        public void dodajSamolot(Samolot s){
                for(Samolot sm : firma.getSamoloty()){
                        if(s.equals(sm)) return;
                }
                firma.getSamoloty().add(s);
        }

        public void usunSamolot(String ID){
                int i=0, j=-1;
                for(Samolot sm : firma.getSamoloty()){
                        if(sm.getID().equals(ID)) j=i;
                        i++;
                }
                if(j!=-1) firma.getSamoloty().remove(j);
                else return;

                for(Lot l : NaszaFirma.getInstance().loty){
                        //if(l.getSamolot().getID().equals(ID)) NaszaFirma.getInstance().obslugaLotow.anulujLot(l);
                }

        }

}