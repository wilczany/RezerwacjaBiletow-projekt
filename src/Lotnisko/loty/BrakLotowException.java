package loty;

import trasy.Trasa;
/**
 * Wyjatek na brak lotow
 */
public class BrakLotowException extends LotyException {
    Trasa t;

    BrakLotowException(String message, Trasa t) {
        super(message);
        this.t = t;
    }

}
