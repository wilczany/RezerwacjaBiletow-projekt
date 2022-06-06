package Lotnisko.Uslugobiorcy;

public class FirmaPos extends Klient {
    String NIP,Nazwa;

    FirmaPos(String I, String N)
    {
        this.NIP=I;
        this.Nazwa=N;
    }
    @Override
    String toString()
    {
        return this.getClass().getName() + ":\n" + "Nazwa Firmy:" + Nazwa + '\t' + "NIP Firmy:" + NIP + '\n' + super.toString();
    }
}
