package trasy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import main.Controller;
import main.NaszaFirma;
import uslugobiorcy.Firma;

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
        //analogicznie do metody utworzLotnisko dodalem tą metodę
        //Analogicznie do wypisywania w konsoli i scannera
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
        Lotnisko lll=new Lotnisko(nazwa,x,y);
        NaszaFirma.getInstance().obslugaTras.dodajLotnisko(lll);
        refresh();
        System.out.println(lll);


    }
    public void refresh(){
        listLotniska.getItems().clear();
        for (Lotnisko l:NaszaFirma.getInstance().obslugaTras.getLotniska()
        ) {
            listLotniska.getItems().add(String.valueOf(l));
        }

    }
}
