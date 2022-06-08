package samoloty;

import java.util.Calendar;

public abstract class Samolot {
    int i;
    public int Miejsca;
    public int Zasieg;
    //public int Predkosc;
    public String ID;
    
    Calendar[] tab;

    Samolot(String I) {
        this.ID = I;
    }

    boolean czyZajety(Calendar[] x) {
        int n = 0;
        while (tab[this.i] != null) {
            if (this.tab == x) {
                n = 1;
            } else {
                i++;
            }
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    //settery tbh niepotrzebne są, chyba że dodajemy funkcję modyfikacji samolotów jako bonus xDD
    void setMiejsca(int m) {
        Miejsca = m;
    }

    void setZasieg(int m) {
        Zasieg = m;
    }

    public int getMiejsca() {
        return this.Miejsca;
    }

    public int getZasieg() {
        return this.Zasieg;
    }



    public String getID() {
        return ID;
    }

    //potrzebowałem do interfejsu
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(getClass() != obj.getClass()) return false;
        Samolot s = (Samolot) obj;
        if(ID.equals(s.ID)) return true;
        return false;
    }

    public String toString()
    {
        return this.getClass().getSimpleName() + ":\n" + "ID Samolotu: " + ID + " Miejsca: "  + Miejsca + " Zasieg: " + Zasieg + " Predkosc: " + '\n';
    }

}
