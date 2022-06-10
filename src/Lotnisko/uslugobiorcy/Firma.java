package uslugobiorcy;

public class Firma extends Klient {
    String NIP, Nazwa;

    /**
     * Konstruktor
     * @param I NIP
     * @param N nazwa
     */
    public Firma(String I, String N) {
        this.NIP = I;
        this.Nazwa = N;
    }

    /**
     *
     * @return tablica-NIP oraz nazwa firmy
     */
    @Override
    public String[] getDane() {
        String dane[] = new String[]{NIP, Nazwa};
        return dane;
    }

    /**
     * sprawdz czy firmy sa tkie same
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean czyTenSam(String x, String y) {
        if (x.equals(NIP) && y.equals(Nazwa)) return true;
        return false;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + Nazwa + ", NIP: " + NIP;
    }
}
