package uslugobiorcy;

public class Firma extends Klient {
    String NIP,Nazwa;

    public Firma(String I, String N)
    {
        this.NIP=I;
        this.Nazwa=N;
    }

    @Override
    public String[] getDane(){
        String dane[] = new String[]{NIP, Nazwa};
        return dane;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + Nazwa + ", NIP: " + NIP ;
    }
}
