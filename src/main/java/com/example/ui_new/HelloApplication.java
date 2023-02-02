package com.example.ui_new;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.nio.file.Paths;
import org.json.simple.parser.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Phát nhạc hào khí Việt Nam
          Media media = new Media(Paths.get("src/main/resources/assets/music/HaoKhiVietNam.mp3").toUri().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setMute(false);
            mediaPlayer.play();
        // chạy cửa sổ menu
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Đại Việt Sử Ký Toàn Thư - Project Lập Trình Hướng Đối Tượng !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}