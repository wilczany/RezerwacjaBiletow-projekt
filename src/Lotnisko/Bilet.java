package Lotnisko;

import java.util.Date;

public class Bilet {
    public final int id;
    boolean czyDwustronny;
    boolean reserved=false;

    public Bilet(Date data) {
        czyDwustronny=false;
        id=this.hashCode();
    }
    public Bilet(Date data1,Date data2){
        czyDwustronny=true;
        id=this.hashCode();
    }
    public boolean czyZajety(){
        return reserved;
    }

}

