package com.example.ui_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HuyenSuCacViVua extends HelloController {
    public static String searchString = "";
    @FXML
    public ComboBox<String> ListMusic;
    @FXML
    public Button Introl;

    @FXML
    public Button GoBack;

    public void GoBackAction(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Đại Việt Sử Ký Toàn Thư - Project Lập Trình Hướng Đối Tượng !");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button TimKiem;
    @FXML
    public TextField Search;

    public void TimKiemAction(ActionEvent event) throws IOException {
        try {
            searchString = Search.getText().toUpperCase().trim();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HuyenSuCacViVuaData.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Huyền Sử Các Vị Vua");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}