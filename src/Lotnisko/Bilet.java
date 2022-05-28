package Lotnisko;

import java.util.Calendar;
import java.util.Date;

/**
 * bileciki do kontroli
 */
public class Bilet {
    Calendar data=Calendar.getInstance();
    //Calendar powrot=null;
    Trasa trasa;
    public final int id;
    //boolean czyDwustronny;
    boolean zajety =false;

    /**
     *Standardowy konstruktor
     * @param data data lotu
     * @param trasa trasa lotu
     */

    protected Bilet(Date data,Trasa trasa) {
        this.data.setTime(data);
        this.trasa=trasa;
      //  czyDwustronny=false;
        id=this.hashCode();
    }

    /***
     * chyba nie bede uzywac tego konstrukotra.Bilety powrotne robimy tworzac oddziela pule biletow c:
     * @param data1
     * @param data2
     */
    public Bilet(Date data1,Date data2,Trasa trasa){
        this.data.setTime(data1);
        this.trasa=trasa;
        //this.powrot.setTime(data2)
        //czyDwustronny=true;
        id=this.hashCode();
    }
    /*
    public void zmienDwustronny(Date powrot){
        Calendar.getInstance().setTime(powrot);
    }
     */

    /***
     *
     * @return
     */

    public boolean czyZajety(){
        return zajety;
    }

    /**
     * Rezerwacja biletu
     * @return zarezerwowany bilet
     */
    public Bilet zajmij(){
        zajety =true;
        return this;
    }
}

