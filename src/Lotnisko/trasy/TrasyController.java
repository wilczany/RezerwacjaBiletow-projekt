package trasy;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.text.Text;
import loty.Lot;
import main.Controller;
import main.NaszaFirma;
import samoloty.ATR;
import samoloty.Samolot;
import uslugobiorcy.Firma;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class TrasyController extends Controller {
    @FXML
    ListView<Lotnisko> listLotniska;
    @FXML
    ListView<Trasa> listTrasy;
    ArrayList<Lotnisko>lotniska;
    ArrayList<Trasa> trasy;

    @FXML
    void initialize(){

        lotniska=NaszaFirma.getInstance().obslugaTras.getLotniska();
        for (Lotnisko l:lotniska){
            listLotniska.getItems().add(l);
        }
        trasy=NaszaFirma.getInstance().obslugaTras.getTrasy();
        for (Trasa t:trasy)
            listTrasy.getItems().add(t);
        }



    @FXML
    public void dodajLotnisko(ActionEvent event) {
        Dialog<String> dialog = new TextInputDialog();
        dialog.setHeaderText("Podaj nazwę dla lotniska:");
        dialog.setContentText("Nazwa: ");
        Optional<String> result_nazwa = dialog.showAndWait();
        String nazwa = result_nazwa.get();
        if(NaszaFirma.getInstance().obslugaTras.sprawdzNazwe(nazwa) || nazwa.equals("")){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            if(nazwa.equals("")) dialog.setContentText("Proszę wpierw podać nazwę.");
            else dialog.setContentText("Podana nazwa jest już zajęta.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }

        dialog=new TextInputDialog();
        dialog.setHeaderText("Podaj koordynaty:");
        dialog.setContentText("x=");
        Optional<String> result_X = dialog.showAndWait();
        if(result_X.get().equals("") || !(result_X.get().matches("[0-9]+"))){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Proszę podać prawidłową liczbę całkowitą.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }
        int x= Integer.parseInt(result_X.get());

        dialog=new TextInputDialog();
        dialog.setHeaderText("Podaj koordynaty:");
        dialog.setContentText("y=");
        Optional<String> result_Y=dialog.showAndWait();
        if(result_Y.get().equals("") || !(result_Y.get().matches("[0-9]+"))){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Proszę podać prawidłową liczbę całkowitą.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }
        int y=Integer.parseInt(result_Y.get());

        if(NaszaFirma.getInstance().obslugaTras.sprawdzKoordynaty(x,y)){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Podane koordynaty są już zajęte.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }

        Lotnisko lll = new Lotnisko(nazwa,x,y);
        NaszaFirma.getInstance().obslugaTras.getLotniska().add(lll);
        refresh();
    }
    @FXML
    public void usunLotnisko(ActionEvent event){
        Lotnisko wybrane = listLotniska.getSelectionModel().getSelectedItem();
        if(wybrane == null){
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Usuwając lotnisko należy wybrać lotnisko.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        if(!(NaszaFirma.getInstance().obslugaTras.usunLotnisko(wybrane))){
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Dane lotnisko nie może zostać usunięte, gdyż jest używane przez istniejący lot lub loty.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        refresh();
    }
    @FXML
    public void usunTrase(ActionEvent event){
        Trasa wybrana = listTrasy.getSelectionModel().getSelectedItem();
        if(wybrana == null){
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Usuwając trasę należy wybrać trasę.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        if( !(NaszaFirma.getInstance().obslugaTras.usunTrase(wybrana))){
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Dana trasa nie może zostać usunięta, gdyż jest używana przez istniejący lot lub loty.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            refresh();
            return;
        }
        refresh();
    }
    @FXML
    public void dodajTrase(ActionEvent event){
        if(NaszaFirma.getInstance().obslugaTras.getLotniska().size()==0) return;
        Lotnisko l1, l2;
        ChoiceDialog<Lotnisko> dialog = new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz lotnisko startowe");
        dialog.getItems().addAll(NaszaFirma.getInstance().obslugaTras.getLotniska());
        Optional<Lotnisko> wynik = dialog.showAndWait();
        //lotnisko poczatkowe
        l1=wynik.get();

        //lista pod wybor lotniska koncowego
        ArrayList<Lotnisko> lotpow = new ArrayList<Lotnisko>();
        for(Lotnisko lt : NaszaFirma.getInstance().obslugaTras.getLotniska()){
            if(!(l1.equals(lt))) lotpow.add(lt);
        }

        //wybor lotniska koncowego
        dialog = new ChoiceDialog<>();
        dialog.setHeaderText("Wybierz lotnisko końcowe");
        dialog.getItems().addAll(lotpow);
        wynik = dialog.showAndWait();
        l2=wynik.get();
        Trasa ttt = new Trasa(l1,l2);
        if(NaszaFirma.getInstance().obslugaTras.sprawdzTrase(ttt)) {
            Dialog<String> dialogB = new Dialog<String>();
            dialogB.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialogB.setContentText("Taka trasa już istnieje.");
            dialogB.getDialogPane().getButtonTypes().add(bOk);
            dialogB.showAndWait();
            return;
        }
        trasy.add(ttt);
        refresh();
    }

    public void refresh(){
        listLotniska.getItems().clear();
        for (Lotnisko l:NaszaFirma.getInstance().obslugaTras.getLotniska()
        ) {
            listLotniska.getItems().add(l);
        }
        listTrasy.getItems().clear();
        for(Trasa t:NaszaFirma.getInstance().obslugaTras.getTrasy()){
            listTrasy.getItems().add(t);
        }

    }
}
