package com.gccfx.Controllers;

import com.gccfx.Error.FieledIsEmptyException;

import com.gccfx.Model.Interval;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class IntervalleItem implements Initializable {

    @FXML
    private TextField BornInf;

    @FXML
    private TextField BornSup;


    public static LinkedList<Interval> intervalles = new LinkedList<Interval>();
    @FXML
    private Button btn;


    @FXML
    private static Label labaelParam;

    public static int nbIntervallesAdded = 0;

    @FXML
    void AddParam(ActionEvent event) throws FieledIsEmptyException {
        if (nbIntervallesAdded < NiveauController.nbIntervalles) {
            if (BornInf.getText().isEmpty() || BornSup.getText().isEmpty()) {
                throw new FieledIsEmptyException("Le champ est vide");
            } else {
                int borneInf = Integer.parseInt(BornInf.getText());
                int borneSup = Integer.parseInt(BornSup.getText());
                if (borneInf > borneSup) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("La borne inférieure doit être inférieure à la borne supérieure");
                    alert.showAndWait();
                } else {
                    if (borneInf == borneSup) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Erreur");
                        alert.setContentText("La borne inférieure doit être différente de la borne supérieure");
                        alert.showAndWait();
                    } else {
                        if (intervalles.size() > 0 && intervalles.get(nbIntervallesAdded - 1).getBornSup() > borneInf) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Erreur");
                            alert.setHeaderText("Erreur");
                            alert.setContentText("La borne inférieure doit être supérieure à la borne supérieure de l'intervalle précédent");
                            alert.showAndWait();
                        } else {
                            Interval interval = new Interval(borneInf, borneSup);
                            intervalles.add(interval);
                            nbIntervallesAdded++;
                            btn.setDisable(true);
                        }
                    }
                }
            }
        }
    }




public static void setLabal(String label){
        labaelParam.setText(label);
        }

@Override public void initialize(URL url,ResourceBundle resourceBundle){
        }
        }
