package lotnisko.loty;

import lotnisko.samoloty.Samolot;

public class ZasiegException extends LotyException{
    Samolot s;
    double Odleglosc;

    public ZasiegException(String message, Samolot s, double odleglosc) {
        super(message);
        this.s = s;
        Odleglosc = odleglosc;
    }
}
