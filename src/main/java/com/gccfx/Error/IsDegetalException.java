package com.gccfx.Error;

import javafx.scene.control.Alert;

public class IsDegetalException extends Exception {
    public IsDegetalException(String message,int i) {
        super(message);
        //alert message give number between i and j
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisir un nombre");
        alert.setHeaderText("Erreur de saisir un nombre");
        alert.setContentText("Veuillez entrer un nombre moins de  "+i);
        alert.showAndWait();
    }


}

