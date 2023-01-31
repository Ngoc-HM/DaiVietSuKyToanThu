module com.example.ui_new {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.ui_new to javafx.fxml;
    exports com.example.ui_new;
    exports com.example.ui_new.Controller;
    opens com.example.ui_new.Controller to javafx.fxml;
}