package lotnisko.uslugobiorcy;

public class Firma extends Klient {
    String NIP,Nazwa;

    Firma(String I, String N)
    {
        this.NIP=I;
        this.Nazwa=N;
    }
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + Nazwa + '\t' + "NIP :" + NIP ;
    }
}
