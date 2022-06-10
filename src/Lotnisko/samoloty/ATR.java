package samoloty;
/**
 * Pochodna Samolotu z okreslonymi wartosciami
 */
public class ATR extends Samolot {

    public ATR(String id) {
        super(id);
        super.Miejsca = 120;
        super.Zasieg = 1200;
    }

}
