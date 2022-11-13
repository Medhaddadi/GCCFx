package com.gccfx.Controllers;

import com.gccfx.Model.Parametre;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ParametreStage {

    @FXML
    private Label nameParam=new Label();

    @FXML
    private TextField valueParam;

    public void setData(Parametre parametre){
        ParametreStage parametreStage=this;
        parametreStage.nameParam.setText(parametre.getName());
        nameParam.setText(parametre.getName());
    }
    public int getValue(){
       return Integer.parseInt(valueParam.getText());
    }
}
