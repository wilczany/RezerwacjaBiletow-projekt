package Lotnisko.Samoloty;
import java.util.Calendar;
import javax.lang.model.util.ElementScanner14;

public abstract class Samolot {
    int i;
    public int Miejsca;
    public int Zasieg;
    public int Predkosc;

    Calendar[] tab;

    public String ID;

    Samolot(String I)
    {
        this.ID=I;
    }

    boolean czyZajety(Calendar[] x)
    {
        int n=0;
        while(tab[this.i]!=null)
        {
            if(this.tab==x)
            {
                n=1;
            }
            else
            {
                i++;
            }
        }
        if(n==1){return true;}
        else{return false;}
    }


    void setMiejsca(int m){
        Miejsca=m;
    }

    void setZasieg(int m)
    {
        Zasieg=m;
    }

    void setPredkosc(int m) {
        Predkosc=m;
    }

    public int getMiejsca(){
        return this.Miejsca;
    }

    public int getZasieg()
    {
        return this.Zasieg;
    }

    int getPredkosc() {
        return this.Predkosc;
    }
    String toString()
    {
        String n="g";
        return n;
    }
}
