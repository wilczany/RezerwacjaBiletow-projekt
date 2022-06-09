package uslugobiorcy;

import loty.Bilet;

import java.util.ArrayList;

public abstract class Klient {


    protected ArrayList<Bilet> bilety=new ArrayList<>();

    void dodajBilet(Bilet bilet)
    {
        bilety.add(bilet);
    }


    public ArrayList<Bilet> getBilety() {
        return bilety;
    }

    public abstract String[] getDane();

    @Override
    public  abstract String toString();



}
