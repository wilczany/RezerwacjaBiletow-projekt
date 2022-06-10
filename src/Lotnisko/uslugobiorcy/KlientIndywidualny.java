package uslugobiorcy;


public class KlientIndywidualny extends Klient {
    String Imie, Nazwisko;

    /**
     * Tworzenie klienta indywidualnego
     * @param I imię
     * @param N nazwisko
     */
    public KlientIndywidualny(String I, String N) {
        this.Imie = I;
        this.Nazwisko = N;
    }

    /**
     * pobieranie danych
     * @return tablica-Imie oraz nazwisko klienta
     */
    @Override
    public String[] getDane() {
        String dane[] = new String[]{Imie, Nazwisko};
        return dane;
    }

    /**
     * porownanie imion i nazwisko
     * @param x imie
     * @param y nazwisko
     * @return
     */
    @Override
    public boolean czyTenSam(String x, String y) {
        if (x.equals(Imie) && y.equals(Nazwisko)) return true;
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + Imie + ' ' + Nazwisko + '\n';
    }
}
