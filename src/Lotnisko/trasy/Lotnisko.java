
package trasy;


public class Lotnisko {
    private String nazwa;

    private int x, y;

    /**
     * Konstruktor lotniska
     * @param nazwa nazwa lotniska
     * @param x X
     * @param y Y

     */

    /**
     * Konstruktor kopiujący
     * @param nazwa nazwa lotniska
           * @param x X
          * @param y Y
     */
     public Lotnisko(String nazwa, int x, int y) {
        this.nazwa = nazwa;
        this.x = x;
        this.y = y;
    }


    public Lotnisko(Lotnisko l) {
        this.nazwa = l.nazwa;
        this.x = l.x;
        this.y = l.y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * sama nazwa wskazuje...
     * @return
     */
    public String getNazwa() {
        return this.nazwa;
    }

    public String toString() {
        return this.nazwa + ", pozycja: (" + this.x + "," + this.y + ")";
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Lotnisko l = (Lotnisko) obj;
        if (nazwa.equals(l.nazwa) && x == l.x && y == l.y) return true;
        return false;
    }
}
