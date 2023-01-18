package com.example.proyectjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private String namePlayer1="Player 1";

    private String namePlayer2="Player 2";

    public String getNamePlayer1() {
        return namePlayer1;
    }

    public void setNamePlayer1(String namePlayer1) {
        this.namePlayer1 = namePlayer1;
    }

    public String getNamePlayer2() {
        return namePlayer2;
    }

    public void setNamePlayer2(String namePlayer2) {
        this.namePlayer2 = namePlayer2;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tik tak toe by Jonathan");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}