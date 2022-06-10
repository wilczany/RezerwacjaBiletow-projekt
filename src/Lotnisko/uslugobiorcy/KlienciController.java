package uslugobiorcy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import loty.Bilet;
import loty.Lot;
import Glowny.Controller;
import Glowny.NaszaFirma;

import java.util.ArrayList;
import java.util.Optional;


public class KlienciController extends Controller {
    @FXML
    ListView<Klient> listKlienci;
    @FXML
    ListView<Bilet> listBilety;
    ArrayList<Klient> klienci;

    @FXML
    void initialize() {
        klienci = NaszaFirma.getInstance().obslugaKlientow.getKlienci();
        for (Klient k : klienci) {
            listKlienci.getItems().add(k);
        }
        listKlienci.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                listBilety.getItems().clear();
                Klient k = listKlienci.getSelectionModel().getSelectedItem();
                for (Bilet b : k.getBilety()) {
                    listBilety.getItems().add(b);
                }
            }
        });
    }

    void wyswietlBilety(MouseEvent event) {

    }

    @FXML
    void dodajKlienta(ActionEvent event) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz typ klienta");
        dialog.getItems().addAll("Klient indywidualny", "Firma pośredniczna");
        Optional<String> result_typ = dialog.showAndWait();
        System.out.println(result_typ);
        if (result_typ.toString().equals("Optional.empty")) {
            Dialog<String> dialog3 = new Dialog<String>();
            dialog3.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog3.setContentText("Należy wybrać któryś z dostępnych typów.");
            dialog3.getDialogPane().getButtonTypes().add(bOk);
            dialog3.showAndWait();
            return;
        }
        String typ = result_typ.get();
        Dialog<String> dialog2 = new TextInputDialog();
        if (typ.equals("Klient indywidualny")) {
            dialog2.setHeaderText("Podaj imię klienta:");
            dialog2.setContentText("Imię: ");
        } else {
            dialog2.setHeaderText("Podaj NIP firmy:");
            dialog2.setContentText("NIP: ");
        }
        Optional<String> result_pierwszy = dialog2.showAndWait();
        String pierwszy = result_pierwszy.get();
        if (pierwszy == "") {
            dialog2 = new Dialog<String>();
            dialog2.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog2.setContentText("Należy podać imię.");
            dialog2.getDialogPane().getButtonTypes().add(bOk);
            dialog2.showAndWait();
            return;
        }

        dialog2 = new TextInputDialog();
        if (typ.equals("Klient indywidualny")) {
            dialog2.setHeaderText("Podaj nazwisko klienta:");
            dialog2.setContentText("Nazwisko: ");
        } else {
            dialog2.setHeaderText("Podaj nazwę firmy:");
            dialog2.setContentText("Nazwa: ");
        }
        Optional<String> result_drugi = dialog2.showAndWait();
        String drugi = result_drugi.get();
        if (drugi == "" || NaszaFirma.getInstance().obslugaKlientow.sprawdzKlienta(pierwszy, drugi)) {
            dialog2 = new Dialog<String>();
            dialog2.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            if (drugi == "") dialog2.setContentText("Należy podać nazwisko.");
            else dialog2.setContentText("Dany klient już istnieje.");
            dialog2.getDialogPane().getButtonTypes().add(bOk);
            dialog2.showAndWait();
            return;
        }
        if (typ.equals("Klient indywidualny")) {
            Klient k = new KlientIndywidualny(pierwszy, drugi);
            klienci.add(k);
            refresh();
        } else {
            Klient f = new Firma(pierwszy, drugi);
            klienci.add(f);
            refresh();
        }
    }

    @FXML
    void usunKlienta() {
        Klient wybrany = listKlienci.getSelectionModel().getSelectedItem();
        if (wybrany == null) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialogB.setContentText("Usuwając klienta należy wpierw wybrać klienta.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        NaszaFirma.getInstance().obslugaKlientow.usunKlienta(wybrany);
        refresh();
    }

    @FXML
    void dodajBilet() {
        Klient wybrany = listKlienci.getSelectionModel().getSelectedItem();
        if (wybrany == null) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialogB.setContentText("Do dodania biletu musi być wpierw wybrany klient.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        ChoiceDialog<Lot> dialog = new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz lot");
        dialog.getItems().addAll(NaszaFirma.getInstance().obslugaLotow.getLoty());
        Optional<Lot> wynik = dialog.showAndWait();
        if (wynik.toString().equals("Optional.empty")) {
            Dialog<String> dialog3 = new Dialog<String>();
            dialog3.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog3.setContentText("Należy wybrać któryś z dostępnych lotów.");
            dialog3.getDialogPane().getButtonTypes().add(bOk);
            dialog3.showAndWait();
            return;
        }
        Lot lot = wynik.get();
        if (!(lot.zajmijBilet(wybrany))) {
            Dialog<String> dialog3 = new Dialog<String>();
            dialog3.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog3.setContentText("Niestety brak dostępnych biletów dla danego lotu.");
            dialog3.getDialogPane().getButtonTypes().add(bOk);
            dialog3.showAndWait();
            return;
        }
        listBilety.getItems().clear();
    }

    @FXML
    void usunBilet() {
        Bilet wybrany = listBilety.getSelectionModel().getSelectedItem();
        if (wybrany == null) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialogB.setContentText("Usuwając bilet należy wpierw wybrać bilet.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            return;
        }
        wybrany.anuluj();
        for (Klient k : klienci) {
            for (Bilet b : k.getBilety()) {
                if (b.equals(wybrany)) {
                    k.getBilety().remove(wybrany);
                    listBilety.getItems().remove(wybrany);
                    return;
                }
            }
        }
        refresh();
    }

    public void refresh() {
        listKlienci.getItems().clear();
        klienci = NaszaFirma.getInstance().obslugaKlientow.getKlienci();
        for (Klient k : klienci) {
            listKlienci.getItems().add(k);
        }
    }
}
