package com.gccfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Objects;

    public class Launcher  extends Application {


    @Override
    public void start(Stage stage)  {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/Main.fxml")));
            stage.setTitle("GCC");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}