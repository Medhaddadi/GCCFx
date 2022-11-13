package com.gccfx.Controllers;

import com.gccfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainStart {

    @FXML
    private Button start;

    private  Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void start(ActionEvent event)  {
        try{
            Parent root = FXMLLoader.load((Objects.requireNonNull(Main.class.getResource("views/AddCategorie.fxml"))));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Ajouter une catégorie");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
