package uslugobiorcy;

import loty.Bilet;

import java.util.ArrayList;

public abstract class Klient {

    protected ArrayList<Bilet> b=new ArrayList<>();

    void dodajBilet(Bilet bilet)
    {
        b.add(bilet);
    }

    void usunBilet()
    {
        this.b=null;
    }

    @Override
    public  abstract String toString();



}
