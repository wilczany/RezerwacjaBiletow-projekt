package trasy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.text.Text;
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
    ListView listLotniska;
    @FXML
    ListView listTrasy;
    ArrayList<Lotnisko>lotniska;
    ArrayList<Trasa> trasy;

    @FXML
    void initialize(){

            lotniska=NaszaFirma.getInstance().obslugaTras.getLotniska();
            //listLotniska.getItems().clear();
            for (Lotnisko l:lotniska
            ) {
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
        if(NaszaFirma.getInstance().obslugaTras.sprawdzNazwe(nazwa) || nazwa==""){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Podana nazwa jest już zajęta.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }

        dialog=new TextInputDialog();
        dialog.setHeaderText("Podaj koordynaty:");
        dialog.setContentText("x=");
        Optional<String> result_X = dialog.showAndWait();
        int x= Integer.parseInt(result_X.get());

        dialog=new TextInputDialog();
        dialog.setContentText("y=");
        Optional<String> result_Y=dialog.showAndWait();
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
    }


/*
    public void dodajTrase(ActionEvent event){
        Dialog<String> dialog = new TextInputDialog();
        Lotnisko l1, l2;

        dialog.setHeaderText("Podaj nazwę lotniska startowego:");
        dialog.setContentText("Nazwa: ");
        Optional<String> result_nazwa1 = dialog.showAndWait();
        String nazwa1 = result_nazwa1.get();
        for(Lotnisko l : lotniska){
            if(nazwa.equals(l.getNazwa()){
                l1=l;
            }
        }
        if(l1 == null){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Lotnisko o podanej nazwie nie istnieje. Przejrzyj listę lotnisk.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }


        dialog.setHeaderText("Podaj nazwę lotniska końcowego:");
        Optional<String> result_nazwa2 = dialog.showAndWait();
        String nazwa2 = result_nazwa2.get();
        for(Lotnisko l : lotniska){
            if(nazwa.equals(l.getNazwa()){
                l2=l;
            }
        }
        if(l2 == null){
            dialog = new Dialog<String>();
            dialog.setTitle("Błąd");
            ButtonType bOk = new ButtonType("OK", ButtonData.OK_DONE);
            dialog.setContentText("Lotnisko o podanej nazwie nie istnieje. Przejrzyj listę lotnisk.");
            dialog.getDialogPane().getButtonTypes().add(bOk);
            dialog.showAndWait();
            return;
        }

        Trasa ttt = new Trasa(l1,l2)
        NaszaFirma.getInstance().obslugaTras.getTrasy().add(ttt);

    }*/

    //public void usunLotnisko(ActionEvent event){}

    public void refresh(){
        listLotniska.getItems().clear();
        for (Lotnisko l:NaszaFirma.getInstance().obslugaTras.getLotniska()
        ) {
            listLotniska.getItems().add(String.valueOf(l));
        }
        listTrasy.getItems().clear();
        for(Trasa t:NaszaFirma.getInstance().obslugaTras.getTrasy()){
            listTrasy.getItems().add(String.valueOf(t));
        }

    }
}
