package samoloty;

import java.util.Calendar;

public abstract class Samolot {
    public int Miejsca;
    public int Zasieg;
    public String ID;
    int i;
    Calendar[] tab;
    /**
     * Kreator samolotu
     * @param I
     */
    Samolot(String I) {
        this.ID = I;
    }
    /**
     * Sprawdzanie czy samolot jest zajety
     * @param x
     * @return
     */
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
    /**
     * Gettery
     * @return
     */
    public int getMiejsca() {
        return this.Miejsca;
    }

    public int getZasieg() {
        return this.Zasieg;
    }  

    public String getID() {
        return ID;
    }
    /**
     * Settery
     * @param m
     */
    void setMiejsca(int m) {
        Miejsca = m;
    }

    void setZasieg(int m) {
        Zasieg = m;
    }


    /**
     * Porownywanie zawartosci obiektow
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Samolot s = (Samolot) obj;
        if (ID.equals(s.ID)) return true;
        return false;
    }
    /**
     * Wypisanie danych obiektu
     */
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + "ID Samolotu: " + ID + " Miejsca: " + Miejsca + " Zasieg: " + Zasieg;
    }

}
