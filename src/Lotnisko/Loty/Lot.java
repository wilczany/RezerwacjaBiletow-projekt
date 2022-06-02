package Lotnisko.Loty;

import Lotnisko.Samoloty.Samolot;
import Lotnisko.Trasy.Trasa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Klasa reprezetujaca lot
 */

public class Lot {

    Trasa trasa;
    Samolot samolot;
    Calendar data,przylot;
    int numer_lotu;
    ArrayList<Bilet> bilety= new ArrayList<>();

    /***
     * Zwykle tworzenie lotow. Klasa samolot zawiera predkosc, koniecznie uwzglednic
     * @param t trasa lotu
     * @param s samolot przeznaczony do lotu
     * @param d data odlotu
     */
    Lot(Trasa t, Samolot s, Date d){
        trasa=t;
        samolot=s;
        numer_lotu=this.hashCode();
        //DYSTANS NA CALKOWITE
        setDate(d, (int) t.getDystans());
        for(int i=0;i<s.getMiejsca();i++){
            bilety.add(new Bilet(data.getTime(),trasa));
        }

    }

    /***
     * Konstruktor przeznaczony do lotow powtarzajacych sie
     * @param l podanie isntiejacego lotu
     * @param d data odlotu
     */
    Lot(Lot l,Date d){
        trasa=l.getTrasa();
        samolot=l.getSamolot();
        numer_lotu=this.hashCode();
        setDate(d,(int)l.getTrasa().getDystans());
        for(int i=0;i<l.getSamolot().getMiejsca();i++){
            bilety.add(new Bilet(data.getTime(),trasa));
        }
    }

    /***
     *prywatna metoda do zmiany daty lotu
     * @param d data odlotu
     * @param dlugosc odlegosc miedzy lotniskami
     */

    private void setDate(Date d,int dlugosc){
       this.data=Calendar.getInstance();
       this.przylot=Calendar.getInstance();
       data.setTime(d);
       przylot.setTime(d);
       przylot.add(Calendar.HOUR,dlugosc*100);
    }

    /***
     * sprawdzanie czy lot ma wolne bilety
     * @return
     */
    public boolean czyPelen(){

        for (Bilet b:bilety) {
            if(b.czyZajety())
                return false;
        }
        return true;
    }

    /***
     * pobranie wolnego bietu
     * @return ww. bilet
     * @throws Exception
     */
    public Bilet dejBilet()throws Exception{
        for (Bilet b:bilety) {
            if(b.czyZajety()){
                return b.zajmij();
            }
        }
        throw new Exception("SAMOLOT PELNY");
    }
    //GETTERS
    public Trasa getTrasa() {
        return trasa;
    }

    public Samolot getSamolot() {
        return samolot;
    }

    public ArrayList<Bilet> getBilety() {
        return bilety;
    }

    public Calendar getData() {
        return data;
    }

    public Calendar getPrzylot() {
        return przylot;
    }

    @Override
    public String toString() {

        SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd  HH:mm");
        String dataf=SDF.format(data);
        String przylotf=SDF.format(przylot);

        return "Lot: "+numer_lotu+
                "\ntrasa=" + trasa +
                "\nsamolot=" + samolot +
                "\ndata=" + dataf +
                "\nprzylot=" + przylotf;
    }

}
