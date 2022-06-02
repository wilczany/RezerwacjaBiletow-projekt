package Lotnisko.Samoloty;

public abstract class Samolot {

    public int Miejsca;
    public int Zasieg;
    public int Predkosc;

    public String ID;

    Samolot(String I)
    {
        this.ID=I;
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
        return Miejsca;
    }

    public int getZasieg()
    {
        return Zasieg;
    }

    int getPredkosc() {
        return Predkosc;
    }

}
