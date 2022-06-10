package loty;

public class BrakMiejscException extends LotyException {
    Lot l;
/**
 * Wyjatek na brak miejsc
 * @param message
 * @param l
 */
    public BrakMiejscException(String message, Lot l) {
        super(message);
        this.l = l;

    }
}
