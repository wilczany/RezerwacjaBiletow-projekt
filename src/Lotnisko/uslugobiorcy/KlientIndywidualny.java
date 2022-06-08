package uslugobiorcy;


public class KlientIndywidualny extends Klient {
    String Imie,Nazwisko;

    KlientIndywidualny(String I, String N)
    {
        this.Imie=I;
        this.Nazwisko=N;
    }
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + Imie + '\t' + Nazwisko + '\n';
    }
}
