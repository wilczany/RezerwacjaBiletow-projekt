package loty;

/**
 * Wyjatek brak miejsc
 */
public class BrakMiejscException extends LotyException {
    Lot l;

    public BrakMiejscException(String message, Lot l) {
        super(message);
        this.l = l;

    }
}
