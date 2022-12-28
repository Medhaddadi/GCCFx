package com.gccfx.Controllers;

import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import com.gccfx.Model.Parametre;

import com.gccfx.dataBase.data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.gccfx.Controllers.StageController.indexCat;
import static com.gccfx.Controllers.StageController.indexParam;

public class CategorieStage  implements Initializable {
    @FXML
    private  GridPane params;

    @FXML
    private  Label nameCat=new Label();
    public void setLabel(String name){
        nameCat.setText(name);
    }


   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Categorie categorie = AddCategorieController.categories.get(StageController.indexCat);
        System.out.println(categorie.getName());
        nameCat.setText(categorie.getName());

        //LinkedList<Parametre> parametres = categorie.getParametres();
        int col = 0;
        int row = 1;
        try {
            for (Parametre parametre : categorie.getParametres()) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                VBox vBox = fxmlLoader.load(Main.class.getResource("views/parametre.fxml"));
                ParametreStage parametreStage = fxmlLoader.getController();
                System.out.println("hi i passed parametreStage.setData(parametre);");
                col++;
                if (col == 2) {
                    col = 0;
                    row++;
                }
                params.add(vBox, col, row);
                GridPane.setMargin(vBox, new Insets(10));
                indexParam++;
            }
            indexParam = 0;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LinkedList<Parametre>  parametres = data.categories.get(StageController.indexCat).getParametres();
        //New label and textfield for parametres
        nameCat.setText(data.categories.get(indexCat).getName());
        //set id for each nameCat
        nameCat.setId("nameCat");
        params.setId("params");
        int col = 0;
        int row = 1;
        for (Parametre parametre : parametres) {
            Label label = new Label(parametre.getName());
            //label set with 150

            //set label bold
            label.setStyle("-fx-font-weight: bold");
            label.setStyle("-fx-font-weight: bold");
            // set id for label
            label.setId("nameParam");
            TextField textField = new TextField();
            // set with  textfield

            textField.setId("valueParam");
            HBox vBox = new HBox();
            //element center
            vBox.setAlignment(Pos.CENTER);
            //border to vBox black

            //set spacing between label and textfield
            vBox.setSpacing(20);
            vBox.getChildren().addAll(label, textField);
            if (col ==1) {
                col = 0;
                row++;
            }
            params.add(vBox, col++, row);
            indexParam++;
        }
    }

}
