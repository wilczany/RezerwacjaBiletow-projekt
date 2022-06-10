package samoloty;
/**
 * Pochodna klasy Samolot z ustalonymi wartosciami Miejsc i Zasiegu
 */
public class Airbus extends Samolot {

    public Airbus(String id) {
        super(id);
        super.Miejsca = 160;
        super.Zasieg = 2400;
    }

}
