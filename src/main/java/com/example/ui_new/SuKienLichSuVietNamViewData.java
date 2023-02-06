package com.example.ui_new;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.example.objects.SuKien;

public class SuKienLichSuVietNamViewData extends HelloController {
    @FXML
    private Label contentLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label peopleLabel;
    @FXML
    public ComboBox<String> ListMusic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src\\main\\resources\\json\\SuKien.json"));
            List<SuKien> events = new Gson().fromJson(reader, new TypeToken<List<SuKien>>() {
            }.getType());
            // festivals.forEach(tmp -> System.out.println(tmp.getFestivalName()));
            int i = 0;
            boolean found = false;
            if (!SukienLichSuVietNamView.findString.equals(""))
                for (; i < events.size(); i++) {
                    String name = events.get(i).getName().toUpperCase();
                    if (name.contains(SukienLichSuVietNamView.findString)) {
                        found = true;
                        break;
                    }
                }
            if (found) {
                contentLabel.setText(events.get(i).getContent());
                String[] tmp = events.get(i).getLocation();
                String s = "";
                for (String l : tmp) {
                    s = s + l + "\n";
                }
                locationLabel.setText(s);
                tmp = events.get(i).getPeople();
                s = "";
                for (String l : tmp) {
                    s = s + l + "\n";
                }
                nameLabel.setText(events.get(i).getName());
                peopleLabel.setText(s);
            } else {
                contentLabel.setText("Không rõ");
                locationLabel.setText("Không rõ");
                nameLabel.setText("Không rõ");
                peopleLabel.setText("Không rõ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListMusic.setItems(list);
    }

    @FXML
    public Button GoBack;

    public void GoBackAction(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuKienLichSuVietNamView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Sự Kiện Lịch Sử Việt Nam");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}