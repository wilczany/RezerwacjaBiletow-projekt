module IdeaProjects {
    requires javafx.controls;
    requires javafx.fxml;

    opens main to javafx.fxml;
    exports main;
    opens trasy to javafx.fxml;
    exports trasy;

}