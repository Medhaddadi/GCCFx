package com.gccfx.Controllers;

import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import com.gccfx.Model.Parametre;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.*;

public class CategorieStage{
    @FXML
    private  GridPane params=new GridPane();

    public CategorieStage() {
    }
    LinkedList<Parametre> parametres = new LinkedList<>();
    @FXML
    private  Label nameCat=new Label();
    public void setLabel(String name){
        nameCat.setText(name);
    }


    public void setData(Categorie categorie) {

        System.out.println(categorie.getName());
        parametres = categorie.getParametres();
        int col = 0;
        int row = 1;
        try {
            for (Parametre parametre : parametres) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                VBox vBox = fxmlLoader.load((Objects.requireNonNull(Main.class.getResource("views/parametre.fxml"))));
                ParametreStage parametreStage = new ParametreStage();
                parametreStage.setData(parametre);
                System.out.println("hi i passed parametreStage.setData(parametre);");
                col++;
                if (col == 2) {
                    col = 0;
                    row++;
                }
                params.add(vBox, col, row);
                GridPane.setMargin(vBox, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
