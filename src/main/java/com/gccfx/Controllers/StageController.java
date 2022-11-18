package com.gccfx.Controllers;

import com.gccfx.Error.FieledIsEmptyException;
import com.gccfx.Error.IsDegetalException;
import com.gccfx.Main;
import com.gccfx.Model.Categorie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class StageController implements Initializable {

    public static int indexCat = 0;
    public static int indexParam = 0;

    @FXML
    private GridPane Cats;

    @FXML
    private GridPane catGridTotal;

    LinkedList<Categorie> categories = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories = AddCategorieController.categories;
        int col = 1;
        int row = 0;
        int col1 = 0;
        int row1 = 0;
        try {
            for (Categorie categorie : categories) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                VBox vBox = FXMLLoader.load(Main.class.getResource("views/categorie.fxml"));
                CategorieStage categorieStage = fxmlLoader.getController();
                System.out.println("hi i passed categorieStage.setData(categorie);");
                indexCat++;

                if (col == 2) {
                    col = 0;
                    row++;
                }
                Cats.add(vBox, col++, row);
                GridPane.setMargin(vBox, new Insets(10));
                Label label = new Label(categorie.getName());
                TextField textField = new TextField();
                //se the textfield under the label
                VBox vBox1 = new VBox();
                textField.setId("moyenParam");
                vBox1.getChildren().addAll(label, textField);
                //add the vBox to the total grid

                if (col1 == 4) {
                    col1 = 0;
                    row1++;
                }
                catGridTotal.add(vBox1, col1++, row1);
                GridPane.setMargin(vBox1, new Insets(10));

            }
            indexParam = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    

    public void reset(ActionEvent actionEvent) {
    }

    public void CatculerCat(ActionEvent actionEvent) throws FieledIsEmptyException {
      //boucle to get categorie name by i
        for (int i = 1 ,k=0; i < Cats.getChildren().size() && k<categories.size() ; i++ , k++) {
           Label namecat =(Label) Cats.getChildren().get(i).lookup("#nameCat");
            GridPane gridPane = (GridPane) Cats.getChildren().get(i).lookup("#params");
            if (gridPane != null) {
                for (int j = 0; j < gridPane.getChildren().size(); j++) {
                    Label nameParam=(Label) gridPane.getChildren().get(j).lookup("#nameParam");
                    TextField valueParam=(TextField) gridPane.getChildren().get(j).lookup("#valueParam");
                    try {
                        if (valueParam.getText().isEmpty()) {
                          throw new FieledIsEmptyException("le champ de categorie "+namecat.getText()+" et parametre "+nameParam.getText()+" est vide");
                        }else {
                                this.categories.get(k).getParametres().get(j).setValeur(Double.parseDouble(valueParam.getText()));
                        }
                    } catch (FieledIsEmptyException e) {
                        e.printStackTrace();}
                }
            }else {
                System.out.println(gridPane);
            }
        }
        System.out.println(categories);
        for (int i = 0; i <catGridTotal.getChildren().size(); i++) {
            TextField textField = (TextField) catGridTotal.getChildren().get(i).lookup("#moyenParam");
            categories.get(i).CalculMoyenne();
            textField.setText(""+categories.get(i).getMoyenne());
            textField.setEditable(false);
        }
    }

}
