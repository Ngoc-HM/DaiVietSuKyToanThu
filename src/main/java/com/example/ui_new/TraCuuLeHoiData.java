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
import com.example.objects.Festival;

public class TraCuuLeHoiData extends HelloController{
    @FXML
    private Label figureLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label timeLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src\\main\\resources\\json\\Festival.json"));
            List<Festival> festivals = new Gson().fromJson(reader, new TypeToken<List<Festival>>() {
            }.getType());
            // festivals.forEach(tmp -> System.out.println(tmp.getFestivalName()));
            int i = 0;
            boolean found = false;
            if (!HelloApplication.findString.equals(""))
                for (; i < festivals.size(); i++) {
                    String name = festivals.get(i).getFestivalName().toUpperCase();
                    if (name.contains(HelloApplication.findString)) {
                        found = true;
                        break;
                    }
                }
            if (found) {
                nameLabel.setText(festivals.get(i).getFestivalName());
                timeLabel.setText(festivals.get(i).getLunarDate());
                locationLabel.setText(festivals.get(i).getFestivalLocation());
                figureLabel.setText(festivals.get(i).getRelatedFigure());
            } else {
                nameLabel.setText("Không rõ");
                timeLabel.setText("Không rõ");
                locationLabel.setText("Không rõ");
                figureLabel.setText("Không rõ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(TraCuuLeHoi.findString);
        ListMusic.setItems(list);
    }

    @FXML
    public Button GoBack;
    public void GoBackAction(ActionEvent event) throws IOException {
    	super.TraCuuLeHoiAction(event);
    }

}