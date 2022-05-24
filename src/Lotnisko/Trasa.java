//Patryk
package Lotnisko;
import java.lang.Math;

public class Trasa {
    private double dystans;
    
    private Lotnisko l1, l2;

    public Trasa(Lotnisko l1, Lotnisko l2){
        Lotnisko l3 = new Lotnisko(l1);
        Lotnisko l4 = new Lotnisko(l2);
        this.l1 = l3; this.l2 = l4;

        //należałoby dogadać skalę do odgległości powiązaną z
        //możliwościami naszych modeli samolotów
        //do tego ogólne wskazówki tworzenia lotnisk zgodnych
        //z naszą skalą

        //do pierwiastkowania
        double a = (l4.getX() - l3.getX()), b = (l4.getY() - l3.getY());
        a*=a; b*=b;
        this.dystans = Math.sqrt(a+b);
    }

    public String toString(){
        return "Trasa z "+l1+" do "+l2+", odległość "+this.dystans/*+"?km?"+*/;
    }
    
}
