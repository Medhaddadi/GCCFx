package com.gccfx.Controllers;
import com.gccfx.Error.*;
import com.gccfx.Model.Niveau;
import com.gccfx.dataBase.data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NiveauController implements Initializable {



    @FXML
    private TextField niveau1;

    @FXML
    private Button ADDNiveau;

    @FXML
    private Button ADDNiveau1;

    @FXML
    private Button ADDNiveau2;
    private boolean Niveau1ISAdded=false;
    private boolean Niveau2ISAdded=false;
    private boolean Niveau3ISAdded=false;
    @FXML
    private TextField niveau2;

    @FXML
    private TextField niveau3;

    private boolean validerCamp=false;

    @FXML
    private Button btnNext;


    @FXML
    void Next(ActionEvent event) {
        try {
            //test if niveau1 is added
            if (Niveau3ISAdded && Niveau2ISAdded && Niveau1ISAdded) {
                Stage s=AddCategorieController.switchToNext(event,"views/Stage1.fxml","Stage 1");
                s.setX(0);
                s.setY(0);
                s.show();

                data.afficher();
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }



    @FXML
    void ADDNiveau(ActionEvent event) throws FieledIsEmptyException,IsDegetalException{
        String niveau = niveau1.getText();
        if (niveau.isEmpty()) {
            throw new FieledIsEmptyException("Le chap est vide");
        }//match double value
           else if (!niveau.matches("[0-9]*.[0-9]*")) {
            throw new IsDegetalException("Le champ doit etre un nombre mois de ",1);
        }else{
            data.niveau.setNiveau1(Double.parseDouble(niveau));
            niveau2.setText(""+(double)(100-data.niveau.getNiveau1()));
            Niveau1ISAdded=true;
            ADDNiveau.setDisable(true);
        }
    }
    @FXML
    void ADDNiveau1(ActionEvent event) throws FieledIsEmptyException, IsDegetalException {
        String niveau = niveau2.getText();
        double rest= (double) (100-data.niveau.getNiveau1());
        if (niveau.isEmpty()) {
            throw new FieledIsEmptyException("Le chap est vide");
        }else if (!niveau.matches("[0-9]*.[0-9]*")) {
            throw new IsDegetalException("Le champ doit etre un nombre",rest);
        }else if (!Niveau1ISAdded){
            throw new FieledIsEmptyException("Le niveau 1 n'est pas ajouté");
        }
            else if(Double.parseDouble(niveau) > rest){
                throw new IsDegetalException("Le champ doit etre un nombre mois de ",rest);

        }else{

            data.niveau.setNiveau2(Double.parseDouble(niveau));
            niveau3.setText(""+(double)(100-data.niveau.getNiveau1()-data.niveau.getNiveau2()));
            Niveau2ISAdded=true;
            ADDNiveau1.setDisable(true);
        }
    }
    @FXML
    void ADDNiveau2(ActionEvent event) throws IsDegetalException, FieledIsEmptyException {
        String niveau = niveau3.getText();
        double  rest= (double) (100-data.niveau.getNiveau1()-data.niveau.getNiveau2());
        if (niveau.isEmpty()) {
            throw new FieledIsEmptyException("Le chap est vide");
        }else if (!niveau.matches("[0-9]*.[0-9]*")) {
            throw new IsDegetalException("Le champ doit etre un nombre",rest);
        }
        else if (!Niveau2ISAdded){
            throw new FieledIsEmptyException("Le niveau 2 n'est pas ajouté");
        }
        else if(Double.parseDouble(niveau) > rest) {
            throw new IsDegetalException("Le champ doit etre un nombre mois de ", rest);
        }
        else{
            data.niveau.setNiveau3(Double.parseDouble(niveau));
            Niveau3ISAdded=true;
            ADDNiveau2.setDisable(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
