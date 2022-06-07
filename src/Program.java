//import Lotnisko.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Program {
  public static void main(String[] args) {

    //Wyglada obslugi dat!
    LocalDateTime data=LocalDateTime.of(2022,02,30,12,00);
    SimpleDateFormat SDF=new SimpleDateFormat();
    System.out.println(data);

  }
}

//Stosujemy javadocs??