package com.gccfx.Controllers;

import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class StageController implements Initializable {

    @FXML
    private GridPane Cats;

    @FXML
    private GridPane catGridTotal;

    LinkedList<Categorie> categories = new LinkedList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       categories = AddCategorieController.categories;
        int col = 0;
        int row = 1;
        try {
            for (Categorie categorie : categories) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                VBox vBox =  FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("views/categorie.fxml")));
                CategorieStage categorieStage= new CategorieStage();
                categorieStage.setData(categorie);
                categorieStage.setLabel(categorie.getName());
                System.out.println("hi i passed categorieStage.setData(categorie);");
                col++;
                if (col == 2) {
                    col = 0;
                    row++;
                }
                Cats.add(vBox, col, row);
                GridPane.setMargin(vBox, new Insets(10));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
