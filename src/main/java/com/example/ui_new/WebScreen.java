package com.example.ui_new;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import static com.example.ui_new.HelloApplication.mediaPlayer;

public class WebScreen extends HelloController {

    @FXML
    public WebView webView;
    @FXML
    public TextField addressBar;

    public void onactionweb(ActionEvent actionEvent) {
        try (Scanner scanner = new Scanner(System.in)) {
            String encodedQuery = URLEncoder.encode(String.valueOf(addressBar.getText()), StandardCharsets.UTF_8);
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.google.com/search?q=" + encodedQuery));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}