package com.example.ui_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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