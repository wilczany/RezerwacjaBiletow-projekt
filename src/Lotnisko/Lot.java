package Lotnisko;

import java.util.Calendar;
import java.util.Date;



public class Lot {
    Trasa trasa;
    Samolot samolot;
    Calendar data,przylot;
    int numer_lotu;
    Bilet[] bilety;
    Lot(Trasa t, Samolot s, Calendar data){
        trasa=t;
        samolot=s;
        numer_lotu=this.hashCode();
        Bilety=new Bilet[s.getLiczbaMiejsc];
        przylot= Calendar.getInstance();
        przylot.setTime(data.getTime());
        przylot.add(Calendar.HOUR,trasa.getOdleglosc*10);
    }
    Lot(Lot l,Calendar){

    }

}
