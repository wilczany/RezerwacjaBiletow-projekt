package samoloty;

import javafx.fxml.FXML;
import loty.Lot;
import main.Controller;

import java.util.ArrayList;
import main.NaszaFirma;

public class ObslugaSamolotow extends Controller{

        public ArrayList<Samolot> samoloty=new ArrayList<>();

        //FXML



        public ArrayList<Samolot> getSamoloty() {
                return samoloty;
        }


        public void dodajSamolot(Samolot s){
                for(Samolot sm : samoloty){
                        if(s.equals(sm)) return;
                }
                samoloty.add(s);
        }

        public boolean sprawdzID(String id) {
                for (Samolot s : samoloty) {
                    if (id.equals(s.getID())) return true;
                }
                return false;
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