package samoloty;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.Controller;
import main.NaszaFirma;
import trasy.Lotnisko;

import java.util.ArrayList;

public class SamolotyController extends Controller {
    ArrayList<Samolot> samoloty;

    @FXML
    ListView listSamoloty;

    @FXML
    void initialize() {
        samoloty = NaszaFirma.getInstance().obslugaSamolotow.getSamoloty();
        for (Samolot s : samoloty) {
            listSamoloty.getItems().add(s);
        }
    }

    @FXML
    void addSamolot() {

        Dialog<String> dialog = new TextInputDialog();
        dialog.setHeaderText("Podaj ID Samolotu:");
        dialog.setContentText("ID: ");
        Optional<String> result_nazwa = dialog.showAndWait();
        String nazwa = result_nazwa.get();
        if (NaszaFirma.getInstance().obslugaSamolotow.sprawdzNazwe(nazwa) || nazwa == "") {
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Podana nazwa jest już zajeta.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }
        Samolot sss = new Samolot(nazwa);
        NaszaFirma.getInstance().obslugaSamolotow.getSamoloty().add(sss);
    }

   

    refresh();

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
