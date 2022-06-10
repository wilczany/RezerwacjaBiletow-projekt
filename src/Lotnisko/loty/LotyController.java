package loty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Controller;
import main.NaszaFirma;
import samoloty.Samolot;
import trasy.Lotnisko;
import trasy.Trasa;
import uslugobiorcy.Klient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;

public class LotyController extends Controller {

    ArrayList<Lot> loty;

    @FXML
    ListView<Lot> listLoty;

    public static boolean dobryFormat(String inputValue, DateTimeFormatter format) {
        // DateTimeFormatter format=DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
        try {
            format.parse(inputValue);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @FXML
    void initialize() {
        refresh();
    }

    @FXML
    public void dodajLot(ActionEvent AE) {
        LocalDateTime data = null;
        try {
            data = wyborDaty();
        } catch (Exception e) {
            return;
        }
        Samolot s;
        Trasa t;
        ChoiceDialog<Samolot> dialog = new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz samolot");
        dialog.getItems().addAll(NaszaFirma.getInstance().obslugaSamolotow.getSamoloty());
        Optional<Samolot> wynik = dialog.showAndWait();
        if (wynik.toString().equals("Optional.empty")) {
            Dialog<String> dialog3 = new Dialog<String>();
            dialog3.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog3.setContentText("Należy wybrać któryś z dostępnych samolotów.");
            dialog3.getDialogPane().getButtonTypes().add(bOk);
            dialog3.showAndWait();
            return;
        }
        s = wynik.get();
        ChoiceDialog<Trasa> dialog2 = new ChoiceDialog<>();
        dialog2.setHeaderText("Wybierz trasę");
        dialog2.getItems().addAll(NaszaFirma.getInstance().obslugaTras.getTrasy());
        Optional<Trasa> wynik2 = dialog2.showAndWait();
        if (wynik2.toString().equals("Optional.empty")) {
            Dialog<String> dialog3 = new Dialog<String>();
            dialog3.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog3.setContentText("Należy wybrać którąś z dostępnych tras.");
            dialog3.getDialogPane().getButtonTypes().add(bOk);
            dialog3.showAndWait();
            return;
        }
        t = wynik2.get();

        try {
            NaszaFirma.getInstance().obslugaLotow.dodajLot(t, s, data);
        } catch (LotyException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            return;
        }
        refresh();
    }

    @FXML
    public void refresh() {
        listLoty.getItems().clear();
        for (Lot l : NaszaFirma.getInstance().obslugaLotow.getLoty()) {
            listLoty.getItems().add(l);
        }
    }

    public LocalDateTime wyborDaty() throws Exception {
        LocalDateTime localDateTime;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");
        Dialog<String> dialog = new TextInputDialog();
        dialog.setHeaderText("Podaj datę w formacie DD.MM.YYYY hh:mm");
        dialog.setContentText("Data:");
        Optional<String> result_data = dialog.showAndWait();
        String data = result_data.get();

        if (!dobryFormat(data, format)) {
            dialog.close();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Zły format daty!");
            Optional<ButtonType> result = alert.showAndWait();
            throw new Exception("Niepoprawna data");
        }

        localDateTime = LocalDateTime.parse(data, format);

        return localDateTime;

    }

    //tbh nie wiem od czego to moze byc xdd
    public void dodajKolejnyLot(ActionEvent event) {
        Lot wybrany = listLoty.getSelectionModel().getSelectedItem();
        if (wybrany == null) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialogB.setContentText("Dodając powtórzony lot należy wpierw wybrać lot.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        LocalDateTime data = null;
        try {
            data = wyborDaty();
        } catch (Exception e) {
            return;
        }
        try {
            NaszaFirma.getInstance().obslugaLotow.dodajLot(wybrany.getTrasa(), wybrany.getSamolot(), data);
        } catch (LotyException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            return;
        }
        refresh();
    }

    public void dodajPowrotnyLot(ActionEvent event) {
        Lot wybrany = listLoty.getSelectionModel().getSelectedItem();
        if (wybrany == null) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialogB.setContentText("Dodając lot powrotny należy wpierw wybrać lot.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        LocalDateTime data = null;
        try {
            data = wyborDaty();
        } catch (Exception e) {
            return;
        }
        Lotnisko lt[] = wybrany.trasa.getLotniska();
        Trasa tr = NaszaFirma.getInstance().obslugaTras.znajdzTrase(lt[1], lt[0]);
        if (tr == null) {
            tr = new Trasa(lt[1], lt[0]);
            System.out.println(tr + " NULLbyl");
            NaszaFirma.getInstance().obslugaTras.getTrasy().add(tr);
        }
        try {
            NaszaFirma.getInstance().obslugaLotow.dodajLot(tr, wybrany.getSamolot(), data);
        } catch (LotyException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            return;
        }
        refresh();
    }

    public void anulujLot(ActionEvent event) {
        Lot wybrany = listLoty.getSelectionModel().getSelectedItem();
        if (wybrany == null) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialogB.setContentText("Usuwając lot należy wpierw wybrać lot.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        for (Bilet b : wybrany.getBilety()) {
            b.zajety = false;
            for (Klient k : NaszaFirma.getInstance().obslugaKlientow.getKlienci()) {
                k.getBilety().remove(b);
            }
        }
        NaszaFirma.getInstance().obslugaLotow.loty.remove(wybrany);
        refresh();
    }

}