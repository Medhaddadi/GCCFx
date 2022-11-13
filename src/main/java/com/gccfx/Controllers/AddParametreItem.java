package com.gccfx.Controllers;


import com.gccfx.Error.FieledIsEmptyException;
import com.gccfx.Model.Parametre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AddParametreItem implements Initializable {

    @FXML
    private ImageView btnAddParam;

    @FXML
    private Spinner<Integer> facteur;

    @FXML
    private Label labaelParam;

    private static LinkedList<Parametre> parametres = new LinkedList<Parametre>();

    @FXML
    private TextField nomParam;
    @FXML
    private Button btn;
    public void setLabel(String label){
        this.labaelParam.setText(label);
    }
    //get parametres
    public static LinkedList<Parametre> getParametres() {
        return parametres;
    }
    @FXML
    void AddParam(ActionEvent event) throws FieledIsEmptyException {
        String nom = nomParam.getText();
        if (nom.isEmpty()) {
            throw new FieledIsEmptyException("Le champ est vide");
        }
        int fact = facteur.getValue();
        Parametre parametre = new Parametre(nom,fact);
        parametres.add(parametre);
        btn.setDisable(true);
        Label nbLabel = AddParametres.nbrCat;
        //increment the number of parametres added
        AddParametres.incrementNbParametreAdded();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialize the spinner
        facteur.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20, 1));
        labaelParam.setText("Parametre");
    }

    //set lebel of the parametre


}
