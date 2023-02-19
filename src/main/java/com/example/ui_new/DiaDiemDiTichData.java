package com.example.ui_new;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.example.objects.Relic;

public class DiaDiemDiTichData extends HelloController {
    @FXML
    private Label contentLabel;
    @FXML
    private Label eventLabel;
    @FXML
    private Label nameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src\\main\\resources\\json\\Relic.json"));
            List<Relic> relics = new Gson().fromJson(reader, new TypeToken<List<Relic>>() {
            }.getType());
            // festivals.forEach(tmp -> System.out.println(tmp.getFestivalName()));
            int i = 0;
            boolean found = false;
            if (!HelloApplication.findString.equals(""))
                for (; i < relics.size(); i++) {
                    String name = relics.get(i).getRelicName().toUpperCase();
                    if (name.contains(HelloApplication.findString)) {
                        found = true;
                        break;
                    }
                }
            if (found) {
                contentLabel.setWrapText(true);
                contentLabel.setMaxWidth(650);
                contentLabel.setText(relics.get(i).getRelicDescription());
                nameLabel.setText(relics.get(i).getRelicName());
                String[] tmp = relics.get(i).getRelatedEvent();
                String s = "";
                for (String r : tmp) {
                    s += r + "\n";
                }
                eventLabel.setText(s);
            } else {
                contentLabel.setText("Không rõ");
                nameLabel.setText("Không rõ");
                eventLabel.setText("Không rõ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListMusic.setItems(list);
    }

    @FXML
    public Button GoBack;
    public void GoBackAction(ActionEvent event) throws IOException {
        super.DiaDiemDiTichAction(event);
    }
}