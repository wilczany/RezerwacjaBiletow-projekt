package lotnisko.samoloty;

public class ATR extends Samolot {
    
    protected
    int Miejsca = 120, Zasieg = 1200, Predkosc = 60;

    protected ATR(String id) {
        super(id);
        super.Miejsca = Miejsca;
        super.Zasieg = Zasieg;
        super.Predkosc = Predkosc;
    }

}
