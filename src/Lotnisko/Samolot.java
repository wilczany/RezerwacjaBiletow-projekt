package Lotnisko;

public class Samolot {
    String ID
    int Miejsca,Zasieg,Predkosc;

    Samolot(String I, int M, int Z, int P)
    {
        this.ID=I;
        this.Miejsca=M;
        this.Zasieg=Z;
        this.Predkosc=P;
    }

    int getLiczbaMiejsc(){
        return 1;
    }
}
