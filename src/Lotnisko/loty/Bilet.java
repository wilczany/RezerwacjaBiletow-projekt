package loty;
import trasy.Trasa;

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


    public boolean equals(Bilet b){
        return b.id==this.id;
    }

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

    public int getId() {
        return id;
    }
}

