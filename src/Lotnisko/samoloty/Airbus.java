package samoloty;
/**
 * Pochodna Samolotu z okreslonymi wartosciami
 */
public class Airbus extends Samolot {

    public Airbus(String id) {
        super(id);
        super.Miejsca = 160;
        super.Zasieg = 2400;
    }

}
