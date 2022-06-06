package Lotnisko.Uslugobiorcy;

public class Klient {

    protected Bilet b;

    void dodajBilet()
    {
        this.b.dodajBilet();
    }

    void usunBilet()
    {
        this.b.usunBilet();
    }

    void toString()
    {
        return this.b;
    }
}
