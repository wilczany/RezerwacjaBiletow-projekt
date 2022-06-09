package samoloty;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.Controller;
import main.NaszaFirma;
import trasy.Lotnisko;

import java.util.ArrayList;

public class SamolotyController extends Controller {
    ArrayList<Samolot>samoloty;

    @FXML
    ListView listSamoloty;

    @FXML
    void initialize(){
        samoloty= NaszaFirma.getInstance().obslugaSamolotow.getSamoloty();
        for(Samolot s:samoloty){
            listSamoloty.getItems().add(s);
        }
    }


    @FXML
    void addSamolot(){

    }

    @FXML
    void delSamolot(){

    }

    public void refresh(){
        listSamoloty.getItems().clear();
        for (Samolot s:NaszaFirma.getInstance().obslugaSamolotow.getSamoloty()
        ) {
            listSamoloty.getItems().add(String.valueOf(s));
        }

    }
}
