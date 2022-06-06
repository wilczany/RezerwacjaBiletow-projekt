package lotnisko.uslugobiorcy;

public abstract class Klient {

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
    public  abstract String toString();



}
