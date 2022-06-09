package loty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import main.Controller;
import main.NaszaFirma;

import java.io.DataInput;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class LotyController extends Controller {

    ArrayList<Lot>loty;

    @FXML
    ListView listLoty;


    @FXML
    public void dodajLot(){

    }


    @FXML
    public void refresh(){

    }
    public void wyborDaty(ActionEvent event) {
        try {
            Dialog<String> dialog = new TextInputDialog();
            dialog.setHeaderText("Podaj datę w formacie DD/MM/YYYY");
            Optional<String> result_data = dialog.showAndWait();
            String data = result_data.get();

        } catch (Exception e) {

        }

    }
    public void dodajKolejnyLot(ActionEvent event){}
    public void dodajPowrotnyLot(ActionEvent event){}
    public void anulujLot(ActionEvent event){}

}