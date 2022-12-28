package com.gccfx.Controllers;

import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import com.gccfx.Model.Interval;
import com.gccfx.Model.Niveau;

import com.gccfx.dataBase.data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import com.jfoenix.controls.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class IntervallesController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label error;
    @FXML
    public static Button btnNext;
    @FXML
    private VBox intervales;


    @FXML
    private VBox vboxAdd;


    @FXML
    void Next(ActionEvent event) throws IOException, ParseException {
        //check if the textfield is empty
        if (checkEmpty()) {
            error.setText("Veuillez ajouter tous les intervalles");
        } else {
            error.setText("");
            getIntervalles();

            System.out.println(data.niveau);
            for (Categorie categorie : data.categories) {
                System.out.println(categorie);
            }
            Stage s = AddCategorieController.switchToNext(event, "views/NiveauxBlade.fxml", "GCC simulation");
            s.show();
        }
    }

    private boolean checkEmpty() {
        //check if the textfield is empty by chearing the textfield by his id
        for (int i = 0; i < data.nbIntervalles; i++) {
            TextField textField = (TextField) intervales.lookup("#bornInf" + i);
            TextField textField1 = (TextField) intervales.lookup("#bornSup" + i);
            if (textField.getText().isEmpty() || textField1.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void getIntervalles() {
        //get all the textfields and store each one in a INterval class and add it to the list of intervalles
        for (int i = 1; i <= data.nbIntervalles; i++) {
            //get text field of each hbox in the vbox
            HBox hBox = (HBox) intervales.getChildren().get(i);
            TextField min = (TextField) hBox.getChildren().get(1);
            TextField max = (TextField) hBox.getChildren().get(2);
            Interval interval = new Interval(Integer.parseInt(min.getText()), Integer.parseInt(max.getText()));
            data.intervalles.add(interval);
        }
        System.out.println(data.intervalles);
    }

    //add event  whent typing to conrol the textfield bornInf and bornSup between 0-100 and bornInf<bornSup and bornSup egqual to the next bornInf
    public void addEvent() {
        for (int i = 0; i < data.nbIntervalles; i++) {
            TextField textField = (TextField) intervales.lookup("#bornInf" + i);
            TextField textField1 = (TextField) intervales.lookup("#bornSup" + i);
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (Integer.parseInt(newValue) > 100) {
                    textField.setText("100");
                    error.setText("Veuillez saisir un nombre entre 0 et 100");
                }
                if (Integer.parseInt(newValue) < 0) {
                    textField.setText("0");
                    error.setText("Veuillez saisir un nombre positif");
                }
                if (Integer.parseInt(newValue) > Integer.parseInt(textField1.getText())) {
                    error.setText("Born inférieur doit être inférieur à born supérieur");
                }
            });
            textField1.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    textField1.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (Integer.parseInt(newValue) > 100) {
                    textField1.setText("100");
                    error.setText("Born supérieur doit être inférieur à 100");
                }
                if (Integer.parseInt(newValue) < 0) {
                    textField1.setText("0");
                    error.setText("Born supérieur doit être supérieur à 0");
                }
                if (Integer.parseInt(newValue) < Integer.parseInt(textField.getText())) {
                    error.setText("Born supérieur doit être supérieur à born inférieur");
                }
            });
        }
    }
    //affect this event to all the textfield en typing

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      /* int col=0;
       int row= 1;
       try {
              for (int i = 0; i < data.nbIntervalles; i++) {
               FXMLLoader fxmlLoader = new FXMLLoader();
               HBox hBox = fxmlLoader.load(Main.class.getResource("views/IntervalleIntem.fxml"));
                IntervalleItem intervalleItem = fxmlLoader.getController();
                  if (col == 1) {
                     col = 0;
                     row++;
                }
                grid.add(hBox, col++, row);
                  GridPane.setMargin(hBox, new javafx.geometry.Insets(10));


              }
           //put value 0  in the first textfield and 100 in the last textfield

       } catch (IOException e) {
           throw new RuntimeException(e);
       }*/
        error.setText("");
        //create hbox contient tree lables define the contient of the hbox
        HBox hBox1 = new HBox();
        Label label1 = new Label("Intervalle name");
        Label label2 = new Label("Intervalle min");
        Label label3 = new Label("Intervalle max");
        //all lebel in the hbox have the same size and the same space between them color blue and bold
        label1.setPrefWidth(200);
        label2.setPrefWidth(200);
        label3.setPrefWidth(200);
        label1.setStyle("-fx-font-weight: bold;-fx-text-fill: blue");
        label2.setStyle("-fx-font-weight: bold;-fx-text-fill: blue");
        label3.setStyle("-fx-font-weight: bold;-fx-text-fill: blue");

        hBox1.getChildren().addAll(label1, label2, label3);
        hBox1.setSpacing(20);
        //intervales spacinge 30
        intervales.setSpacing(30);
        //inervalles padding 20 and content center
        intervales.setPadding(new javafx.geometry.Insets(20));
        //intervales alignement center
        //intervales.setAlignment(javafx.geometry.Pos.CENTER);
        intervales.getChildren().add(hBox1);
        for (int i = 0; i < data.nbIntervalles; i++) {
            //create hbox contient name intervale and textfield for value borninf and bornsup
            HBox hBox = new HBox();
            hBox.setSpacing(35);
            //create label for name intervale
            Label label = new Label("Intervalle " + (i + 1));
            //create textfield for borninf
            TextField bornInf = new TextField();
            //set prompt text for borninf
            bornInf.setPromptText("Born inf");
            //add id for borninf
            bornInf.setId("bornInf" + i);
            //create textfield for bornsup
            TextField bornSup = new TextField();
            //set prompt text for bornsup
            bornSup.setPromptText("Born sup");
            //add id for bornsup
            bornSup.setId("bornSup" + i);
            //add label and textfield to hbox
            hBox.getChildren().addAll(label, bornInf, bornSup);
            //add hbox to vbox
            intervales.getChildren().add(hBox);
        }

        //put value 0  in the first textfield and 100 in the last textfield
        ((TextField) ((HBox) intervales.getChildren().get(1)).getChildren().get(1)).setText("0");
        ((TextField) ((HBox) intervales.getChildren().get(data.nbIntervalles)).getChildren().get(2)).setText("100");
        addEvent();
    }
    //add event on typing in textfield and check if the value is correct and if borninf<bornsup and bornsup egal to next borninf


}
