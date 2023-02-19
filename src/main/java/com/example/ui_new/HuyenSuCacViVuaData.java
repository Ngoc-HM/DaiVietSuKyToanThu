package com.example.ui_new;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.objects.Character;

public class HuyenSuCacViVuaData extends HelloController {

	@FXML
    private Button Intro;
    @FXML
    private Label bornYearLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label diedYearLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label periodLabel;
    @FXML
    public ComboBox<String> ListMusic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src\\main\\resources\\json\\Character.json"));
            List<Character> characters = new Gson().fromJson(reader, new TypeToken<List<Character>>() {
            }.getType());
            int i = 0;
            boolean found = false;
            if (!HelloApplication.findString.equals(""))
                for (; i < characters.size(); i++) {
                    String name = characters.get(i).getName().toUpperCase();
                    if (name.contains(HelloApplication.findString)) {
                        found = true;
                        break;
                    }
                }
            if (found) {
                bornYearLabel.setText(characters.get(i).getBornYear());
                descriptionLabel.setWrapText(true);
                descriptionLabel.setMaxWidth(650);
                descriptionLabel.setText(characters.get(i).getDescription());
                diedYearLabel.setText(characters.get(i).getDiedYear());
                locationLabel.setText(characters.get(i).getLocation());
                nameLabel.setText(characters.get(i).getName());
                periodLabel.setText(characters.get(i).getPeriod());
            } else {
                bornYearLabel.setText("Không rõ");
                descriptionLabel.setText("Không rõ");
                diedYearLabel.setText("Không rõ");
                locationLabel.setText("Không rõ");
                nameLabel.setText("Không rõ");
                periodLabel.setText("Không rõ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListMusic.setItems(list);
    }

    @FXML
    public Button GoBack;
    public void GoBackAction(ActionEvent event) throws IOException {
        super.HuyenSuCacViVuaAction(event);
    }

}