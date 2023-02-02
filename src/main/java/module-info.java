module com.example.ui_new {
    //requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;


    opens com.example.ui_new to javafx.fxml;
    exports com.example.ui_new;
    //opens com.example.ui_new.Controller to javafx.fxml;
}