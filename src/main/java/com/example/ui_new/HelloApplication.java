package com.example.ui_new;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.nio.file.Paths;
import org.json.simple.parser.*;

public class HelloApplication extends Application {
    public static MediaPlayer mediaPlayer;
    public static Scene scene;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Media media = new Media(Paths.get("src/main/resources/assets/music/HaoKhiVietNam.mp3").toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        // Phát nhạc hào khí Việt Nam
        mediaPlayer.setMute(false);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        // chạy cửa sổ menu
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Đại Việt Sử Ký Toàn Thư - Project Lập Trình Hướng Đối Tượng !");
        Image icon = new Image(Paths.get("src/main/resources/assets/image/app.png").toUri().toString());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}