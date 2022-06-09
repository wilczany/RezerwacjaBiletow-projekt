package samoloty;

public class Boeing extends Samolot {

    protected
    int Miejsca = 30, Zasieg = 3300, Predkosc = 240;

    protected Boeing(String id) {
        super(id);
        super.Miejsca = 30;
        super.Zasieg = 3300;
    }

}
