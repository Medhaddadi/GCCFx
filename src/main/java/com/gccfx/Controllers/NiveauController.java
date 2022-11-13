package com.gccfx.Controllers;
import com.gccfx.Error.*;
import com.gccfx.Model.Niveau;
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

    protected static int nbIntervalles=0;

    @FXML
    private TextField niveau1;
    @FXML
    private Spinner<Integer> nbIntervalle;
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
    public static Niveau niveau=new Niveau();
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

                nbIntervalles=nbIntervalle.getValue();
                System.out.println("Niveau added "+nbIntervalles);
                Stage s=AddCategorieController.switchToNext(event,"views/IntervallesController.fxml","Intervalles");
                s.show();
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
        }else if (!niveau.matches("[0-9]+")) {
            throw new IsDegetalException("Le champ doit etre un nombre mois de ",100);
        }else{
            this.niveau.setNiveau1(Integer.parseInt(niveau));
            niveau2.setText(""+(int)(100-this.niveau.getNiveau1()));
            Niveau1ISAdded=true;
            ADDNiveau.setDisable(true);
        }
    }
    @FXML
    void ADDNiveau1(ActionEvent event) throws FieledIsEmptyException, IsDegetalException {
        String niveau = niveau2.getText();
        int rest= (int) (100-this.niveau.getNiveau1());
        if (niveau.isEmpty()) {
            throw new FieledIsEmptyException("Le chap est vide");
        }else if (!niveau.matches("[0-9]+")) {
            throw new IsDegetalException("Le champ doit etre un nombre",rest);
        }else if (!Niveau1ISAdded){
            throw new FieledIsEmptyException("Le niveau 1 n'est pas ajouté");
        }
            else if(Integer.parseInt(niveau) > rest){
                throw new IsDegetalException("Le champ doit etre un nombre mois de ",rest);

        }else{

            this.niveau.setNiveau2(Integer.parseInt(niveau));
            niveau3.setText(""+(int)(100-this.niveau.getNiveau1()-this.niveau.getNiveau2()));
            Niveau2ISAdded=true;
            ADDNiveau1.setDisable(true);
        }
    }
    @FXML
    void ADDNiveau2(ActionEvent event) throws IsDegetalException, FieledIsEmptyException {
        String niveau = niveau3.getText();
        int rest= (int) (100-this.niveau.getNiveau1()-this.niveau.getNiveau2());
        if (niveau.isEmpty()) {
            throw new FieledIsEmptyException("Le chap est vide");
        }else if (!niveau.matches("[0-9]+")) {
            throw new IsDegetalException("Le champ doit etre un nombre moins ",rest);
        }else if (!Niveau2ISAdded){
            throw new FieledIsEmptyException("Le niveau 2 n'est pas ajouté");
        }
        else if(Integer.parseInt(niveau) > rest){
            throw new IsDegetalException("Le niveau 3 doit etre  moins ",rest);
        }else{
            this.niveau.setNiveau3(Integer.parseInt(niveau));
            Niveau3ISAdded=true;
            ADDNiveau2.setDisable(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nbIntervalle.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));

    }
}
