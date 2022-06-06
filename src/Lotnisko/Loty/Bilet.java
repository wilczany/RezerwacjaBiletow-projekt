package lotnisko.loty;

import lotnisko.trasy.Trasa;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * bileciki do kontroli
 */
public class Bilet {
    LocalDateTime data;
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

    protected Bilet(LocalDateTime data,Trasa trasa) {
        this.data=data;
        this.trasa=trasa;
      //  czyDwustronny=false;
        id=this.hashCode();
    }

    /**
     * chyba nie bede uzywac tego konstrukotra.Bilety powrotne robimy tworzac oddziela pule biletow c:
     * @param data1
     * @param data2
     */

    /*
    private Bilet(Date data1,Date data2,Trasa trasa){
        this.data.setTime(data1);
        this.trasa=trasa;
        //this.powrot.setTime(data2)
        //czyDwustronny=true;
        id=this.hashCode();
    }
    */

    /*
    public void zmienDwustronny(Date powrot){
        Calendar.getInstance().setTime(powrot);
    }
     */



    /**
     * Rezerwacja biletu
     * @return zarezerwowany bilet
     */
    public Bilet zajmij(){
        zajety =true;
        return this;
    }
    public void anuluj(){

    }

    public boolean czyZajety() {
        return zajety;
    }

    @Override
    public String toString() {
        SimpleDateFormat SDF=new SimpleDateFormat();
        return "data:" + data +
                ", trasa:" + trasa +
                ", numer Biletu:" + id;

    }
}

