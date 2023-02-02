package com.example.ui_new;

import com.example.ui_new.ErrorScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SuKienLichSuVietNamView implements Initializable {

    @FXML
    public ComboBox<String> ListMusic;
    public Button Intro;

    ObservableList<String> list = FXCollections.observableArrayList("Kitaro - KOI", "Kitaro - Matsuri", "Nhạc baroque không lời ", "Dòng máu lạc hồng", "Giải phóng Miền Nam", "Đoàn vệ quốc quân", "Bác đang cùng chúng cháu hành quân", "Hào khí Việt Nam");
    public void comboBoxOnAction (ActionEvent event){
        System.out.println( "Nhạc : " + ListMusic.getValue() );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListMusic.setItems(list);
    }
    @FXML
    public Button TrieuDaiLichSu;
    public void TrieuDaiLichSuAction(ActionEvent event) {
        System.out.println(TrieuDaiLichSu.getText());
    }
    @FXML
    public Button HuyenSuCacViVua;
    public void HuyenSuCacViVuaAction(ActionEvent event) {
        System.out.println(HuyenSuCacViVua.getText());
    }
    @FXML
    public Button TraCuuLeHoi;
    public void TraCuuLeHoiAction(ActionEvent event) {
        System.out.println(TraCuuLeHoi.getText());
    }
    @FXML
    public Button DiaDiemDiTich;
    public void DiaDiemDiTichAction(ActionEvent event) {
        System.out.println(DiaDiemDiTich.getText());
        // tạo ra 1 màn hình mới
    }
    @FXML
    public Button SuKienLichSuVietNam;
    public void SuKienLichSuVietNamAction(ActionEvent event) {
        System.out.println(SuKienLichSuVietNam.getText());
    }

    @FXML
    public Button DarkMode;
    // khi ấn nút DarkMode thì đưa ra màn hình ErrorScreen
    public void DarkModeAction(ActionEvent event)  throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ErrorScreen.fxml"));
        Parent ErrorScreenDarkMode = loader.load();
        Scene scene = new Scene(ErrorScreenDarkMode);
        ErrorScreen errorScreen = loader.getController();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public Button DenVang;
    public void DenVangAction(ActionEvent event)  throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ErrorScreen.fxml"));
        Parent denvang = loader.load();
        Scene scene = new Scene(denvang);
        ErrorScreen errorScreen = loader.getController();
        stage.setScene(scene);
        stage.show();
    }
    // biến tắt nhạc
    @FXML
    public Button TatNhac; // id

    // on Action
    public void TatNhacAction(ActionEvent event)  throws IOException {
        // mở ra màn hình ErrorScreen
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ErrorScreen.fxml"));
        Parent tatnhac = loader.load();
        Scene scene = new Scene(tatnhac);
        ErrorScreen errorScreen = loader.getController();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public Button NextWeb;

    public void NextWebAction(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WebScreen.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("test.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("WebScreen");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button GoBack;
    public void GoBackAction(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Hello");
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
        System.out.println(Search.getText());
    }




}
