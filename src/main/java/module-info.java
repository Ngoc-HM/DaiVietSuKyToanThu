module com.example.ui_new {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires json.simple;
    requires org.jsoup;
    requires java.sql;
    requires transitive javafx.web;
    requires com.google.gson;
    requires java.desktop;


    opens com.example.ui_new to javafx.fxml;
    opens com.example.objects to com.google.gson;
    exports com.example.ui_new;
}
