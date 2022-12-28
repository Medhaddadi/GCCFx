package com.gccfx.Controllers;

import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import com.gccfx.Model.Parametre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AddParametres implements Initializable {

    @FXML
    private Button btnNext;

    @FXML
    public static Label nbrCat=new Label();
    @FXML
    private VBox vboxAdd;
    @FXML
    private GridPane grid;

    private static int nbParametreAdded=0;

    private int param=AddCategorieController.nbParametre;

    @FXML
    public Label getNbrCat() {
        return nbrCat;
    }


    @FXML
    void Next(ActionEvent event) {
        try {
            if (nbParametreAdded<param){
                //alter the user to add all the parametres
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur");
                alert.setContentText("Veuillez ajouter tous les parametres");
                alert.showAndWait();

            }else {
            //get the parametres from the view
            //add parametres to categorie
            //open the AddCategorie view
            Stage s = switchToCategorie(event);
            s.show();

            //add categorie to database
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int colums = 0;
        int row = 1;
        try {
            for (int i = 0; i < param; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                HBox hbox = fxmlLoader.load((Main.class.getResource("views/parametreItem.fxml")));
                AddParametreItem addParametreItem = fxmlLoader.getController();

                if (colums == 1) {
                    colums = 0;
                    row++;
                }
                grid.add(hbox, colums++, row);
                GridPane.setMargin(hbox, new javafx.geometry.Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setParam(int param){
        this.param=param;
        System.out.println(this.param);
    }

    //switch to the AddCategorie view

    public Stage switchToCategorie(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Main.class.getResource("views/AddCategorie.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter des Parametres");
        stage.setScene(new Scene(root));
        return stage;
    }
    //increment the number of parametres added
    public static void incrementNbParametreAdded(){
        nbParametreAdded++;
    }
}
