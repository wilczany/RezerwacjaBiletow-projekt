package samoloty;

import javafx.fxml.FXML;
import main.Controller;

import java.util.ArrayList;
import main.NaszaFirma;

public class ObslugaSamolotow extends Controller{
        NaszaFirma firma;

        //FXML

        @FXML
        void addSamolot(){

        }

        @FXML
        void delSamolot(){
        
        }

        //Kontroler
        //ArrayList<Lot> loty; jednak UML troszke przestarzaly xDD



        //exception specjalne pod takie same id? sama informacja w okienku tekstowym?
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
                /*
                for(Lot l : loty){
                        if(l.getSamolot().getID().equals(ID)) ObslugaLotow.anulujLot(tamten lot)
                }
                */
        }

        @Override
        public void refresh() {

        }
}