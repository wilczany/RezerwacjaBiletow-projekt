package loty;

import samoloty.Samolot;
import trasy.Trasa;
import uslugobiorcy.Klient;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Klasa reprezentująca lot
 */

public class Lot {

    Trasa trasa;
    Samolot samolot;
    LocalDateTime data, przylot;
    Period czas_lotu;
    int numer_lotu;
    ArrayList<Bilet> bilety = new ArrayList<>();

    /***
     * Zwykle tworzenie lotow. Klasa samolot zawiera predkosc, koniecznie uwzglednic
     * @param t trasa lotu
     * @param s samolot przeznaczony do lotu
     * @param d data odlotu
     */
    public Lot(Trasa t, Samolot s, LocalDateTime d) {
        trasa = t;
        samolot = s;
        numer_lotu = this.hashCode();
        //DYSTANS NA CALKOWITE
        setDate(d, (int) t.getDystans());

        for (int i = 0; i < s.getMiejsca(); i++) {
            bilety.add(new Bilet(d, trasa));
        }

    }

    /***
     * Konstruktor przeznaczony do lotów powtarzających się
     * @param l podanie istniejącego lotu
     * @param d data odlotu
     */
    public Lot(Lot l, LocalDateTime d) {
        trasa = l.getTrasa();
        samolot = l.getSamolot();
        numer_lotu = this.hashCode();
        setDate(d, (int) l.getTrasa().getDystans());
        for (int i = 0; i < l.getSamolot().getMiejsca(); i++) {
            bilety.add(new Bilet(d, trasa));
        }
    }


    /***
     *prywatna metoda do zmiany daty lotu
     * @param d data odlotu
     * @param dlugosc odlegosc miedzy lotniskami
     */

    private void setDate(LocalDateTime d, int dlugosc) {

        this.data = d;
        this.przylot = data.plusMinutes(dlugosc * 10L);
        czas_lotu = Period.between(data.toLocalDate(), przylot.plusHours(12).toLocalDate());

    }

    /**
     * sprawdzenie czy ma wolne bilety
     * @return boolean
     */
    public boolean czyPelen() {

        for (Bilet b : bilety) {
            if (!b.czyZajety())
                return false;
        }
        return true;
    }

    /**
     * pobranie wolnego bietu
     * @return ww. bilet
     * @throws BrakMiejscException brak wolnych biletow
     */
    public Bilet dejBilet() throws BrakMiejscException {
        for (Bilet b : bilety) {
            if (!b.czyZajety()) {
                return b.zajmij();
            }
        }
        throw new BrakMiejscException("SAMOLOT PELNY", this);
    }

    public boolean zajmijBilet(Klient k) {
        for (Bilet b : bilety) {
            if (!b.czyZajety()) {
                b.zajmij();
                k.getBilety().add(b);
                return true;
            }
        }
        return false;
    }

    //GETTERS
    public Trasa getTrasa() {
        return trasa;
    }

    public Samolot getSamolot() {
        return samolot;
    }

    public ArrayList<Bilet> getBilety() {
        return bilety;
    }

    public LocalDateTime getData() {
        return data;
    }

    public LocalDateTime getPrzylot() {
        return przylot;
    }

    public Period getCzas_lotu() {
        return czas_lotu;
    }

    @Override
    public String toString() {
       DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy  kk:mm");

        String dataf = "dataf", przylotf = "przylotf";

        return "ID: " + numer_lotu +
                ", trasa: " + trasa.krotkiString() +
                ", Id samolotu: " + samolot.getID() +
                ", data: " + data.format(format) +
                ", przylot: " + przylot.format(format);
    }

    //

}
