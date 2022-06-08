package samoloty;

import main.Controller;

import java.util.ArrayList;

public class ObslugaSamolotow extends Controller{
        ArrayList<Samolot> flota=new ArrayList<>();



        //Kontroler
        //ArrayList<Lot> loty; jednak UML troszke przestarzaly xDD
        ArrayList<Samolot> samoloty;

        //exception specjalne pod takie same id? sama informacja w okienku tekstowym?
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
                /*
                for(Lot l : loty){
                        if(l.getSamolot().getID().equals(ID)) ObslugaLotow.anulujLot(tamten lot)
                }
                */
        }
}