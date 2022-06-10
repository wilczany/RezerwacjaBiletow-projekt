package samoloty;
/**
 * Pochodna klasy Samolot z ustalonymi wartosciami Miejsc i Zasiegu
 */
public class Boeing extends Samolot {

    public Boeing(String id) {
        super(id);
        super.Miejsca = 30;
        super.Zasieg = 3300;
    }

}
