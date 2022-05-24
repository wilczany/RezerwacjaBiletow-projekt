//Patryk
package Lotnisko;
//Zmiany w lotniskach nie są przewidywane, ale może dodamy w przyszłości
//zmianę nazw lotnisk. Ze względu na to niepotrzebne są settery.

public class Lotnisko {
    private String nazwa;

    //nad zapisem koordynatów musimy jeszcze pomyśleć
    private int x, y;

    public Lotnisko(String nazwa, int x, int y){
        this.nazwa = nazwa;
        this.x = x; this.y = y;
    }

    public Lotnisko(Lotnisko l){
        this.nazwa = l.nazwa;
        this.x = l.x; this.y=l.y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString(){
        return "Lotnisko "+this.nazwa+", pozycja: ("+this.x+","+this.y+").";
    }
    
}
