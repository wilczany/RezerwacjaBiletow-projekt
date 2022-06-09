package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import loty.LotyController;
import samoloty.SamolotyController;
import trasy.*;
import uslugobiorcy.KlienciController;

import java.io.IOException;

public class MenuController {



    @FXML
    MainController mainController;
    LotyController lotyController;
    TrasyController trasyController;
    KlienciController klienciController;
    SamolotyController samolotyController;



    @FXML
    public void openTrasy() {
        Parent root= null;
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/trasy.fxml"));
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        trasyController =fxml.getController();

        trasyController.setMainController(mainController);

        mainController.setScreen(root);
    }

    @FXML
    public void openLoty(){
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/loty.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lotyController=fxml.getController();

        lotyController.setMainController(mainController);

        mainController.setScreen(root);
    }

    public void openSamoloty(){
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/Samoloty.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        samolotyController =fxml.getController();
        samolotyController.setMainController(mainController);
        mainController.setScreen(root);
    }

    public void openObsluga(){
        FXMLLoader fxml=new FXMLLoader(this.getClass().getResource("/fxml/ObslugaKlientow.fxml"));
        Parent root= null;
        try{
            root=fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        klienciController =fxml.getController();
        klienciController.setMainController(mainController);
        mainController.setScreen(root);
    }

    @FXML
    public void exit(){
        try {
            NaszaFirma.getInstance().zapis();
            Platform.exit();
        }catch (Exception e){

        }
        }


    public void setMainController(MainController mainController){
        this.mainController=mainController;
    }

}
/*
public class ListViewExperiments extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView Experiment 1");

        ListView listView = new ListView();

        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");


        Button button = new Button("Read Selected Value");

        button.setOnAction(event -> {
            ObservableList selectedIndices = listView.getSelectionModel().getSelectedIndices();

            for(Object o : selectedIndices){
                System.out.println("o = " + o + " (" + o.getClass() + ")");
            }
        });


        VBox vBox = new VBox(listView, button);

        Scene scene = new Scene(vBox, 300, 120);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}*/
