package samoloty;

import java.util.Calendar;

/**
 * Tworzenie samolotow
 */
public abstract class Samolot {
    public int Miejsca;
    public int Zasieg;
    public String ID;
    int i;
    Calendar[] tab;

    /**
     * Konstruktor
     * @param I ID samolotu
     */
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

    public int getMiejsca() {
        return this.Miejsca;
    }

    /**
     * settery
     * @param m
     */
    void setMiejsca(int m) {
        Miejsca = m;
    }

    void setZasieg(int m) {
        Zasieg = m;
    }

    /**
     * Gettery
     * @return
     */
    public int getZasieg() {
        return this.Zasieg;
    }

    public String getID() {
        return ID;
    }

    /**
     * Porownywanie zawartosci obiektow
     * @param obj
     * @return
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
     * Wypisywanie danych Samolotu
     * @return
     */
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + "ID Samolotu: " + ID + " Miejsca: " + Miejsca + " Zasieg: " + Zasieg;
    }

}
