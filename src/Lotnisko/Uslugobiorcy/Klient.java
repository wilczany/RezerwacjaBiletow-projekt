package Lotnisko.Uslugobiorcy;

public class Klient {

    protected Bilet b;

    void dodajBilet(Bilet bilet)
    {
        this.b=bilet;
    }

    void usunBilet()
    {
        this.b=null;
    }
    @Override
    String toString()
    {

    }
}
