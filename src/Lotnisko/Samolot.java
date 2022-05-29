package Lotnisko;

public abstract class Samolot {
    
    public int Miejsca;
    public int Zasieg;
    public int Predkosc;

    public
    String ID;

    Samolot(String I)
    {
        this.ID=I;
    }

    void setMiejsca(int m){
        Samolot.Miejsca=m;
    }

    void setZasieg(int m)
    {
        Samolot.Zasieg=m;
    }

    void setPredkosc(int m) {
        Samolot.Predkosc=m;
    }
    
    int getMiejsca(){
        return Miejsca;
    }

    int getZasieg()
    {
        return Zasieg;
    }

    int getPredkosc() {
        return Predkosc;
    }

}
