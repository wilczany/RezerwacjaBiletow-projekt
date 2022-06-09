package loty;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import main.Controller;

import java.io.DataInput;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LotyController extends Controller {

    ArrayList<Lot>loty=new ArrayList();

    @FXML
    ListView listLoty;

    @FXML
    void initialize(){

    }
    @FXML
    public void dodajLot(){

    }


    @FXML
    public void refresh(){

    }
    public LocalDateTime wyborDaty(){
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/fxml/DateTimePicker"));
        try{DialogPane dialog=fxml.load();}
        catch (IOException e) {
            throw new RuntimeException(e);
        } ;
        DatyController daty=fxml.getController();

        Dialog dialog=new Dialog();
        //dialog.setDialogPane(DialogPane);
        return LocalDateTime.of(2000,11,10,12,20);
    }
}
