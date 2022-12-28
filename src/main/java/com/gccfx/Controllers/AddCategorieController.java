package com.gccfx.Controllers;

import com.gccfx.Error.*;
import com.gccfx.Main;
import com.gccfx.Model.Categorie;

import com.gccfx.dataBase.data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.module.Configuration;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddCategorieController implements Initializable {



    @FXML
    private TextField catName;
    @FXML
    private Spinner<Integer> nbParam;
    @FXML
    private Label nbrCat;
    @FXML
    private Spinner<Integer> nbIntervalle;
    protected static Integer nbParametre=0;


    @FXML
    void AddCat(ActionEvent event) throws FieledIsEmptyException {
        try {
            String name = catName.getText();
             nbParametre = this.nbParam.getValue();
            //check if the field is empty
            if (name.isEmpty()) {
                throw new FieledIsEmptyException("Le champ est vide");
            }
            Categorie categorie = new Categorie(name, nbParametre);
            data.categories.add(categorie);
            catName.setText("");
            //open the AddParametres view
           Stage s= switchToParametres(event);
           s.show();
           //add categorie to database
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void Next(ActionEvent event) throws IOException {
        //add confirmation alert if the user want to add another categorie or not
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Voulez aller to next page Add intervales? ");
        alert.showAndWait();
        if (alert.getResult().getText().equals("OK")) {
            data.nbIntervalles=nbIntervalle.getValue();
            Stage s = AddCategorieController.switchToNext(event,"views/IntervallesController.fxml" ,"Interval");
            s.show();
        }
    }
    //return nb de parametres

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set the value of the spinner
        nbIntervalle.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 1));
        nbrCat.setText( Integer.toString(data.categories.size())) ;
        //initialize snipper from 1 to 15
        nbParam.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 1));
    }



    public Stage switchToParametres(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Main.class.getResource("views/AddParametres.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter des Parametres");
        stage.setScene(new Scene(root));
        return stage;
    }
    public static Stage switchToNext(ActionEvent event,String fxml,String name) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(Main.class.getResource(fxml))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(name);
        stage.setScene(new Scene(root));
        return stage;
    }
}
