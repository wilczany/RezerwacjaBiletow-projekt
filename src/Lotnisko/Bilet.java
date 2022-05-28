package Lotnisko;

import java.util.Calendar;
import java.util.Date;

public class Bilet {
    Calendar data=Calendar.getInstance();
    Calendar powrot=null;
    Trasa trasa;
    public final int id;
    boolean czyDwustronny;
    boolean zajety =false;

    public Bilet(Date data,Trasa trasa) {
        this.data.setTime(data);
        this.trasa=trasa;
        czyDwustronny=false;
        id=this.hashCode();
    }
    public Bilet(Date data1,Date data2){
        czyDwustronny=true;
        id=this.hashCode();
    }
    /*
    public void zmienDwustronny(Date powrot){
        Calendar.getInstance().setTime(powrot);
    }
     */

    public boolean czyZajety(){
        return zajety;
    }
    public Bilet zajmij(){
        zajety =true;
        return this;
    }
}

