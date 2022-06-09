package uslugobiorcy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Controller;
import main.NaszaFirma;

import java.util.ArrayList;
import java.util.Optional;


public class KlienciController extends Controller {
    @FXML
    ListView listKlienci;
    ArrayList<Klient> klienci;

    @FXML
    void initialize(){
        klienci= NaszaFirma.getInstance().obslugaKlientow.getKlienci();
        for(Klient k:klienci){
            listKlienci.getItems().add(k);
        }
    }
    public void refresh(){
        listKlienci.getItems().clear();
        klienci= NaszaFirma.getInstance().obslugaKlientow.getKlienci();
        for(Klient k:klienci){
            listKlienci.getItems().add(k);
        }
    }
    @FXML
    public void dodajKlienta(ActionEvent event) {
        Dialog<String> dialog = new TextInputDialog();
        dialog.setHeaderText("Podaj imie/NIP:");
        dialog.setContentText("Imie/NIP: ");
        Optional<String> result_nazwa = dialog.showAndWait();
        String nazwa = result_nazwa.get();
        if(NaszaFirma.getInstance().obslugaTras.sprawdzNazwe(nazwa) || nazwa==""){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Podana nazwa jest już zajęta.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }
        Dialog<String> dialog = new TextInputDialog();
        dialog.setHeaderText("Podaj nazwę/nazwisko:");
        dialog.setContentText("Nazwa/Nazwisko: ");
        Optional<String> result_nazwa = dialog.showAndWait();
        String nazwa2 = result_nazwa.get();
        if(NaszaFirma.getInstance().obslugaTras.sprawdzNazwe(nazwa2) || nazwa2==""){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Podana nazwa jest już zajęta.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }


        Klient kkk = new Klient(nazwa,nazwa2);
        NaszaFirma.getInstance().obslugaKlientow.getKlienci().add(kkk);
        refresh();
    }

}
