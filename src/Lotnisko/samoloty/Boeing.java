package samoloty;

/**
 * Pochodna Samolotu z okreslonymi wartosciami
 */
public class Boeing extends Samolot {

    public Boeing(String id) {
        super(id);
        super.Miejsca = 30;
        super.Zasieg = 3300;
    }

}
