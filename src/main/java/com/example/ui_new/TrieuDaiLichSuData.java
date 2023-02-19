package com.example.ui_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

import com.example.objects.TrieuDai;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TrieuDaiLichSuData extends HelloController{  
    @FXML
    private Label CapitalLabel;
    @FXML
    private Label FirstEmperorLabel;
    @FXML
    private Button Intro;
    @FXML
    private Label LastEmperorLabel;
    @FXML
    private Label PeriodNameLabel;
    @FXML
    private Label PeriodPredecessorLabel;
    @FXML
    private Label PeriodSuccessorLabel;
    @FXML
    private Label PeriodTimeLabel;
    @FXML
    private Label ReligionLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src\\main\\resources\\json\\Period.json"));
            List<TrieuDai> periods = new Gson().fromJson(reader, new TypeToken<List<TrieuDai>>() {
            }.getType());
            int i = 0;
            boolean found = false;
            if (!HelloApplication.findString.equals(""))
                for (; i < periods.size(); i++) {
                    String name = periods.get(i).getPeriodName().toUpperCase();
                    if (name.contains(HelloApplication.findString)) {
                        found = true;
                        break;
                    }
                }
            if (found) {
                CapitalLabel.setText(periods.get(i).getCapital());
                FirstEmperorLabel.setText(periods.get(i).getFirstEmperor());
                LastEmperorLabel.setText(periods.get(i).getLastEmperor());
                PeriodNameLabel.setText(periods.get(i).getPeriodName());
                PeriodPredecessorLabel.setText(periods.get(i).getPeriodPredecessor());
                PeriodSuccessorLabel.setText(periods.get(i).getPeriodSuccessor());
                PeriodTimeLabel.setText(periods.get(i).getPeriodTime());
                ReligionLabel.setText(periods.get(i).getReligion());
            } else {
                CapitalLabel.setText("Không rõ");
                FirstEmperorLabel.setText("Không rõ");
                LastEmperorLabel.setText("Không rõ");
                PeriodNameLabel.setText("Không rõ");
                PeriodPredecessorLabel.setText("Không rõ");
                PeriodSuccessorLabel.setText("Không rõ");
                PeriodTimeLabel.setText("Không rõ");
                ReligionLabel.setText("Không rõ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListMusic.setItems(list);
    }

    @FXML
    public Button GoBack;
    public void GoBackAction(ActionEvent event) throws IOException {
        super.TrieuDaiLichSuAction(event);
    }

}