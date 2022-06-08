package uslugobiorcy;

import loty.Bilet;

public abstract class Klient {

    protected ArrayList<Bilet> b=new ArrayList<>();

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
