package com.gccfx.Controllers;

import com.gccfx.Model.Parametre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.gccfx.Controllers.StageController.indexParam;

public class ParametreStage implements Initializable {

    @FXML
    private Label nameParam=new Label();

    @FXML
    private TextField valueParam;

    public void setData(Parametre parametre) {
        nameParam.setText(parametre.getName());
    }

    public int getValue(){
        return Integer.parseInt(valueParam.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parametre parametre = AddCategorieController.categories.get(StageController.indexCat).getParametres().get(indexParam);
        nameParam.setText(parametre.getName());
    }

}
