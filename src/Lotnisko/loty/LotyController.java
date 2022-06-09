package loty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Controller;
import main.NaszaFirma;
import samoloty.Samolot;
import trasy.Trasa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;

public class LotyController extends Controller {

    ArrayList<Lot>loty;

    @FXML
    ListView listLoty;

    @FXML
    void initialize(){
    refresh();
    }
    @FXML
    public void dodajLot(ActionEvent AE){
        LocalDateTime data= null;
        try {
            data = wyborDaty();
        } catch (Exception e) {
            return;
        }
        Samolot s;
        Trasa t;
        ChoiceDialog<Samolot>dialog=new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz samolot");
        dialog.getItems().addAll(NaszaFirma.getInstance().obslugaSamolotow.getSamoloty());
        Optional<Samolot>wynik=dialog.showAndWait();
        s=wynik.get();
        ChoiceDialog<Trasa> dialog2=new ChoiceDialog<>();
        dialog2.setHeaderText("Wybierz trasę");
        dialog2.getItems().addAll(NaszaFirma.getInstance().obslugaTras.getTrasy());
        Optional<Trasa>wynik2=dialog2.showAndWait();
        t=wynik2.get();

        try {
            NaszaFirma.getInstance().obslugaLotow.dodajLot(t,s,data);
        } catch (LotyException e) {
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            Optional<ButtonType> result=alert.showAndWait();
            return;
        }
        refresh();
    }


    @FXML
    public void refresh(){
        listLoty.getItems().clear();
        for(Lot l:NaszaFirma.getInstance().obslugaLotow.getLoty())
        {
            listLoty.getItems().add(String.valueOf(l));
        }
    }
    public LocalDateTime wyborDaty()throws Exception {
        LocalDateTime localDateTime;
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");
            Dialog<String> dialog = new TextInputDialog();
            dialog.setHeaderText("Podaj datę w formacie DD.MM.YYYY hh:mm");
            dialog.setContentText("Data:");
            Optional<String> result_data = dialog.showAndWait();
            String data = result_data.get();

        if(!dobryFormat(data,format)){
            dialog.close();
           Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Zły format daty!");
            Optional<ButtonType> result=alert.showAndWait();
            throw new Exception("Niepoprawna data");
        }

            localDateTime=LocalDateTime.parse(data,format);

            return localDateTime;

    }




    public void dodajKolejnyLot(ActionEvent event){}
    public void dodajPowrotnyLot(ActionEvent event){}
    public void anulujLot(ActionEvent event){}

    public static boolean dobryFormat(String inputValue,DateTimeFormatter format) {
       // DateTimeFormatter format=DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
        try {
            format.parse(inputValue);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}