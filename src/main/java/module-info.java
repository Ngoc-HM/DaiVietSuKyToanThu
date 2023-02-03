module com.example.ui_new {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires json.simple;
    requires gson;
    requires java.sql;


    opens com.example.ui_new to javafx.fxml;
    opens com.example.objects to gson;
    exports com.example.ui_new;
}
