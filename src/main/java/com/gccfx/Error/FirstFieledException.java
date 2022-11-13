package com.gccfx.Error;

import javafx.scene.control.Alert;

public class FirstFieledException extends Exception {
    public FirstFieledException(String message) {
        super(message);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisir ");
        alert.setHeaderText("Veuillez saisir le premier champ");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

