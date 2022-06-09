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
                listLotniska.getItems().add(String.valueOf(l));
            }


    }

    @FXML
    public void dodajLotnisko(ActionEvent event) {
        Dialog<String> dialog = new TextInputDialog();
        dialog.setHeaderText("Podaj nazwę dla lotniska:");
        dialog.setContentText("Nazwa: ");
        Optional<String> result_nazwa = dialog.showAndWait();
        String nazwa = result_nazwa.get();


        dialog=new TextInputDialog();
        dialog.setHeaderText("Podaj Koordynaty:");
        dialog.setContentText("X= ");
        Optional<String> result_X = dialog.showAndWait();
        int x= Integer.parseInt(result_X.get());

        dialog=new TextInputDialog();
        dialog.setContentText("Y=");
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

    }
}
