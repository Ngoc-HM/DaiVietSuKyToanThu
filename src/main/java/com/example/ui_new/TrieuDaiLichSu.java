package com.example.ui_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class TrieuDaiLichSu extends HelloController {
    @FXML
    public Button GoBack;
    public void GoBackAction(ActionEvent event) throws IOException {
        super.IntrolAction(event);
    }

    @FXML
    public Button TimKiem;
    @FXML
    public TextField Search;

    public void TimKiemAction(ActionEvent event) throws IOException {
        try {
            HelloApplication.findString = Search.getText().toUpperCase().trim();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TrieuDaiLichSuData.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Triều Đại Lịch Sử");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}