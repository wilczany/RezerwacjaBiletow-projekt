module IdeaProjects {
    requires javafx.controls;
    requires javafx.fxml;

    opens Glowny to javafx.fxml;
    exports Glowny;
    opens trasy to javafx.fxml;
    exports trasy;
    opens loty to javafx.fxml;
    exports loty;
    opens samoloty to javafx.fxml;
    exports samoloty;
    opens uslugobiorcy to javafx.fxml;
    exports uslugobiorcy;

}