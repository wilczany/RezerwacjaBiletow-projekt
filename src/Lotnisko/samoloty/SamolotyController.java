package samoloty;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import main.Controller;
import main.NaszaFirma;
import trasy.Lotnisko;

import java.util.ArrayList;
import java.util.Optional;

public class SamolotyController extends Controller {
    ArrayList<Samolot> samoloty;

    @FXML
    ListView<Samolot> listSamoloty;

    @FXML
    void initialize() {
        samoloty = NaszaFirma.getInstance().obslugaSamolotow.getSamoloty();
        for (Samolot s : samoloty) {
            listSamoloty.getItems().add(s);
        }
    }

    @FXML
    void addSamolot() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz typ samolotu");
        dialog.getItems().addAll("Boeing","ATR","Airbus");
        Optional<String> result_typ = dialog.showAndWait();
        if(result_typ.toString().equals("Optional.empty")){
            Dialog<String> dialog3 = new Dialog<String>();
            dialog3.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog3.setContentText("Należy wybrać któryś z dostępnych typów.");
            dialog3.getDialogPane().getButtonTypes().add(bOk);
            dialog3.showAndWait(); return;
        }
        String typ = result_typ.get();
        Dialog<String> dialog2 = new TextInputDialog();
        dialog2.setHeaderText("Podaj ID Samolotu:");
        dialog2.setContentText("ID: ");
        Optional<String> result_id = dialog2.showAndWait();
        String id = result_id.get();
        if (id == "" || NaszaFirma.getInstance().obslugaSamolotow.sprawdzID(id)) {
            dialog2 = new Dialog<String>();
            dialog2.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            if(id == "") dialog2.setContentText("Należy podać unikalne ID.");
            else dialog2.setContentText("Podane ID jest już zajęte.");
            dialog2.getDialogPane().getButtonTypes().add(bOk);
            dialog2.showAndWait(); return;
        }
        Samolot sss;
        if(typ.equals("Boeing")){
            sss = new Boeing(id);
        }else if(typ.equals("ATR")){
            sss = new ATR(id);
        }else{
            sss = new Airbus(id);
        }
        NaszaFirma.getInstance().obslugaSamolotow.getSamoloty().add(sss);
        refresh();
    }

    @FXML
    void delSamolot(){
        Samolot wybrany = listSamoloty.getSelectionModel().getSelectedItem();
        if(wybrany == null){
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Usuwając samolot należy wpierw wybrać samolot.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh(); return;
        }
        if( !(NaszaFirma.getInstance().obslugaSamolotow.usunSamolot(wybrany))){
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Dana samolot nie może zostać usunięty, gdyż jest używany przez istniejący lot lub loty.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh(); return;
        }
        refresh();
    }

    public void refresh(){
        listSamoloty.getItems().clear();
        for (Samolot s:NaszaFirma.getInstance().obslugaSamolotow.getSamoloty()
        ) {
            listSamoloty.getItems().add(s);
        }

    }
}
