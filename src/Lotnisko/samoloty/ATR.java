package samoloty;
/**
 * Pochodna klasy Samolot z ustalonymi wartosciami Miejsc i Zasiegu
 */
public class ATR extends Samolot {

    public ATR(String id) {
        super(id);
        super.Miejsca = 120;
        super.Zasieg = 1200;
    }

}
