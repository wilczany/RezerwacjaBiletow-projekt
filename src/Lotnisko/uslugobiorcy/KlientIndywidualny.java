package uslugobiorcy;


public class KlientIndywidualny extends Klient {
    String Imie, Nazwisko;

    public KlientIndywidualny(String I, String N) {
        this.Imie = I;
        this.Nazwisko = N;
    }

    @Override
    public String[] getDane() {
        String dane[] = new String[]{Imie, Nazwisko};
        return dane;
    }

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
