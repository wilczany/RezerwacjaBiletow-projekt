package uslugobiorcy;


public class KlientIndywidualny extends Klient {
    String Imie,Nazwisko;

    public KlientIndywidualny(String I, String N)
    {
        this.Imie=I;
        this.Nazwisko=N;
    }

    @Override
    public String[] getDane(){
        String dane[] = new String[]{Imie, Nazwisko};
        return dane;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + Imie + '\t' + Nazwisko + '\n';
    }
}
