package Lotnisko;

import java.util.Calendar;
import java.util.Date;



public class Lot {
    Trasa trasa;
    Samolot samolot;
    Calendar data,przylot;
    int numer_lotu;
    Bilet[] bilety;
    Lot(Trasa t, Samolot s, Date d){
        trasa=t;
        samolot=s;
        numer_lotu=this.hashCode();
        bilety=new Bilet[s.getLiczbaMiejsc];
        setDate(d,s.getOdleglosc)

    }
    Lot(Lot l,Date d){
        trasa=t.getTrasa();
        samolot=l.getSamolot();
        numer_lotu=this.hashCode();
        bilety=new Bilet[l.getSamolot().getLiczbaMiejsc];
        setDate(d,s.getOdleglosc);
    }

    public Trasa getTrasa() {
        return trasa;
    }

    public Samolot getSamolot() {
        return samolot;
    }

    private void setDate(Date d,int dlugosc){
       this.data=Calendar.getInstance();
       this.przylot=Calendar.getInstance();
       data.setTime(d);
       przylot.setTime(d);
       przylot.add(Calendar.HOUR,dlugosc*100);
    }
}
