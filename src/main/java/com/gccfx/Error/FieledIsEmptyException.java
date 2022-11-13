package com.gccfx.Error;

import javafx.scene.control.Alert;

public class FieledIsEmptyException extends Exception {
    public FieledIsEmptyException(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

