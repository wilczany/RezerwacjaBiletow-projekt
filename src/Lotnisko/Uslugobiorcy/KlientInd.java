package Lotnisko.Uslugobiorcy;

public class KlientInd extends Klient {
    String Imie,Nazwisko;

    KlientInd(String I, String N)
    {
        this.Imie=I;
        this.Nazwisko=N;
    }
    @Override
    String toString()
    {
        return this.getClass().getName() + ":\n" + "Nazwa Klienta:" + Imie + '\t' + "Nazwisko Klienta:" + Nazwisko + '\n' + super.toString();
    }
}
