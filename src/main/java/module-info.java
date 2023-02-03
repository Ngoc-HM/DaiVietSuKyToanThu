module com.example.ui_new {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires json.simple;
    requires com.google.gson;


    opens com.example.ui_new to javafx.fxml;
    opens com.example.objects to com.google.gson;
    exports com.example.ui_new;
    //opens com.example.ui_new.Controller to javafx.fxml;
}
