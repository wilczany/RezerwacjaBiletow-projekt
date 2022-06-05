package lotnisko.samoloty;

public class Airbus extends Samolot {
    
    protected
    int Miejsca = 160, Zasieg = 2400, Predkosc = 100;

    protected Airbus(String id) {
        super(id);
        super.Miejsca = Miejsca;
        super.Zasieg = Zasieg;
        super.Predkosc = Predkosc;
    }

}
