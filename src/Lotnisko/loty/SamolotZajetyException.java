package loty;

import samoloty.Samolot;

import java.time.LocalDateTime;

public class SamolotZajetyException extends LotyException{
    Samolot s;
    LocalDateTime odlot,przylot;

    public SamolotZajetyException(String message, Samolot s, LocalDateTime odlot, LocalDateTime przylot) {
            super(message);
            this.s=s;
            this.odlot=odlot;
            this.przylot=przylot;
    }
}
