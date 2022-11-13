package com.gccfx.Controllers;

import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import com.gccfx.Model.Interval;
import com.gccfx.Model.Niveau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    public static Button btnNext;

    @FXML
    private GridPane grid;

    @FXML
    private VBox vboxAdd;


    @FXML
    void Next(ActionEvent event) throws IOException, ParseException {
        if (NiveauController.nbIntervalles>IntervalleItem.nbIntervallesAdded){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Saisir Intervalles");
            alert.setContentText("Veuillez ajouter tous les intervalles");
            alert.showAndWait();
        }else {
            for (int i = 0; i < IntervalleItem.intervalles.size(); i++) {
                System.out.println(IntervalleItem.intervalles.get(i));
            }
            System.out.println(NiveauController.niveau);
            for (Categorie categorie : AddCategorieController.categories) {
                System.out.println(categorie);
            }
            Stage s=AddCategorieController. switchToNext(event,"views/Stage1.fxml","GCC simulation");
            s.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       int col=0;
       int row= 1;
       try {
              for (int i = 0; i < NiveauController.nbIntervalles; i++) {
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
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
