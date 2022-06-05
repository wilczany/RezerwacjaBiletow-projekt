//import Lotnisko.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Program {
  public static void main(String[] args) {

    //Wyglada obslugi dat!
    Calendar cal=Calendar.getInstance();
    SimpleDateFormat SDF=new SimpleDateFormat();
    System.out.println(SDF.format(cal.getTime()));

  }
}

//Stosujemy javadocs??