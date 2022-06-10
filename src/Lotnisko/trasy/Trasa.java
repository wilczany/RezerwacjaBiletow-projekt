//Patryk
package trasy;

public class Trasa {
    final private double dystans;

    final private Lotnisko l1, l2;

    public Trasa(Lotnisko l1, Lotnisko l2) {
        Lotnisko l3 = new Lotnisko(l1);
        Lotnisko l4 = new Lotnisko(l2);
        this.l1 = l3;
        this.l2 = l4;

        //należałoby dogadać skalę do odgległości powiązaną z
        //możliwościami naszych modeli samolotów
        //do tego ogólne wskazówki tworzenia lotnisk zgodnych
        //z naszą skalą

        //do pierwiastkowania
        double a = (l4.getX() - l3.getX()), b = (l4.getY() - l3.getY());
        a *= a;
        b *= b;
        this.dystans = Math.sqrt(a + b) * 10;
    }

    //trasy powrotnej
    public Trasa(Trasa startowa) {
        this.l1 = new Lotnisko(startowa.l2);
        this.l2 = new Lotnisko(startowa.l1);
        this.dystans = startowa.dystans;
    }

    public  Lotnisko[] getLotniska() {
        Lotnisko[] l = new Lotnisko[2];
        l[0] = l1;
        l[1] = l2;
        return l;
    }

    public double getDystans() {
        return dystans;
    }

    public String toString() {
        return "Trasa z " + l1 + " do " + l2 + ", odległość: " + this.dystans/*+"?km?"+*/;
    }

    public String krotkiString(){
        return "Z "+l1.getNazwa()+" do "+l2.getNazwa();
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Trasa t = (Trasa) obj;
        if (l1.equals(t.l1) && l2.equals(t.l2)) return true;
        return false;
    }
}
