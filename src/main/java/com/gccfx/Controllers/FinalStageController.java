package com.gccfx.Controllers;

import com.gccfx.Alters;
import com.gccfx.dataBase.data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;

public class FinalStageController implements Initializable {

    @FXML
    private TextField Ev;


    @FXML
    private TextField Mv;

    private String transaction="";
    @FXML
    private Label P1;

    @FXML
    private Label P2;

    @FXML
    private Label P3;
    @FXML
    private Button action;
    @FXML
    private TextField Pv;
@FXML
private Label vers;
    @FXML
    private Button neg;
    private int indexMax;
    @FXML
    private Button pos;
    @FXML
    private ListView<String> operation;

    @FXML
    private ListView<Double> resultat;

    @FXML
    void negative(ActionEvent event) {
        //Mv set modif disabeld
        Mv.setEditable(false);
        //Ev set modif disabeld
        Ev.setEditable(false);
        //Pv set modif disabeld
        Pv.setEditable(false);
        action.setDisable(false);
        resultat.getItems().set(indexMax, resultat.getItems().get(indexMax)-data.mapM.get(transaction));
        afficheScore();
        pos.setDisable(true);
        neg.setDisable(true);

    }
    public void afficheScore(){
        if (transaction.charAt(3)=='M') {
            Mv.setText(String.valueOf(resultat.getItems().get(indexMax)));
            Alters.showErrorDialog("Resultat","resultat","le score de l'etat "+transaction.charAt(0)+" est "+resultat.getItems().get(indexMax));
        }else if (transaction.charAt(3)=='E'){
            Ev.setText(String.valueOf(resultat.getItems().get(indexMax)));
            Alters.showErrorDialog("Resultat","resultat","le score de l'etat "+transaction.charAt(0)+" est "+resultat.getItems().get(indexMax));
        }else {
            Pv.setText(String.valueOf(resultat.getItems().get(indexMax)));
            Alters.showErrorDialog("Resultat","resultat","le score de l'etat "+transaction.charAt(0)+" est "+resultat.getItems().get(indexMax));
        }
    }
    private final double[] pourcentage = {data.ensignant,data.pair,data.machine};
    @FXML
    void positive(ActionEvent event) {
        //Mv set modif disabeld
        Mv.setEditable(false);
        //Ev set modif disabeld
        Ev.setEditable(false);
        Pv.setEditable(false);
        //Pv set modif disabeld
        action.setDisable(false);
        resultat.getItems().set(indexMax, resultat.getItems().get(indexMax)+data.mapP.get(transaction));
        afficheScore();

        pos.setDisable(true);
        neg.setDisable(true);
    }
    @FXML
    void Action(ActionEvent event) {
        selectMax(getList());
        pos.setDisable(false);
        neg.setDisable(false);
        data.afficherMap();
        action.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Mv.setText("2");
        Ev.setText("1");
        Pv.setText("3");
        //set botun action non clicable
        action.setDisable(true);
        //sort the array
        Arrays.sort(pourcentage);
        P1.setText(String.valueOf(pourcentage[0]));
        P2.setText(String.valueOf(pourcentage[1]));
        P3.setText(String.valueOf(pourcentage[2]));

      // diciser tout les elements de pourcentage sur 100
        for(int i=0;i<pourcentage.length;i++){
            pourcentage[i]=pourcentage[i]/100;
        }

        selectMax( getList());

    }


    public int getList ( ){
        ObservableList<String> MPE = FXCollections.observableArrayList(
                "M-p-e","M-e-p","P-m-e","P-e-m","E-m-p","E-p-m"
        );
        ObservableList<String> operations = FXCollections.observableArrayList(
        );
        String s1="v("+MPE.get(0)+")="+pourcentage[0]+"*"+Mv.getText()+"+"+pourcentage[1]+"*"+Pv.getText()+"+"+pourcentage[2]+"*"+Ev.getText()+" = ";
        String s2="v("+MPE.get(1)+")="+pourcentage[0]+"*"+Mv.getText()+"+"+pourcentage[1]+"*"+Ev.getText()+"+"+pourcentage[2]+"*"+Pv.getText()+" = ";
        String s3="v("+MPE.get(2)+")="+pourcentage[0]+"*"+Pv.getText()+"+"+pourcentage[1]+"*"+Mv.getText()+"+"+pourcentage[2]+"*"+Ev.getText()+" = ";
        String s4="v("+MPE.get(3)+")="+pourcentage[0]+"*"+Pv.getText()+"+"+pourcentage[1]+"*"+Ev.getText()+"+"+pourcentage[2]+"*"+Mv.getText()+" = ";
        String s5="v("+MPE.get(4)+")="+pourcentage[0]+"*"+Ev.getText()+"+"+pourcentage[1]+"*"+Mv.getText()+"+"+pourcentage[2]+"*"+Pv.getText()+" = ";
        String s6="v("+MPE.get(5)+")="+pourcentage[0]+"*"+Ev.getText()+"+"+pourcentage[1]+"*"+Pv.getText()+"+"+pourcentage[2]+"*"+Mv.getText()+" = ";
        operations.addAll(s1,s2,s3,s4,s5,s6);
        operation.setItems(operations);
        double res1=pourcentage[0]*Double.parseDouble(Mv.getText())+pourcentage[1]*Double.parseDouble(Pv.getText())+pourcentage[2]*Double.parseDouble(Ev.getText());
        double res2=pourcentage[0]*Double.parseDouble(Mv.getText())+pourcentage[1]*Double.parseDouble(Ev.getText())+pourcentage[2]*Double.parseDouble(Pv.getText());
        double res3=pourcentage[0]*Double.parseDouble(Pv.getText())+pourcentage[1]*Double.parseDouble(Mv.getText())+pourcentage[2]*Double.parseDouble(Ev.getText());
        double res4=pourcentage[0]*Double.parseDouble(Pv.getText())+pourcentage[1]*Double.parseDouble(Ev.getText())+pourcentage[2]*Double.parseDouble(Mv.getText());
        double res5=pourcentage[0]*Double.parseDouble(Ev.getText())+pourcentage[1]*Double.parseDouble(Mv.getText())+pourcentage[2]*Double.parseDouble(Pv.getText());
        double res6=pourcentage[0]*Double.parseDouble(Ev.getText())+pourcentage[1]*Double.parseDouble(Pv.getText())+pourcentage[2]*Double.parseDouble(Mv.getText());
        ObservableList<Double> result = FXCollections.observableArrayList(
        );
        result.addAll(res1,res2,res3,res4,res5,res6);
        resultat.setItems(result);
        //give bagroud green color to the max value of result ond to his operation
        int indexMa=0;
        double maxRes=0;
        for(int i=0;i<result.size();i++){
            if(result.get(i)>maxRes){
                maxRes=result.get(i);
                indexMa=i;
            }
        }
        //get the string of the operation of indexmax
        String operationMax=operations.get(indexMa);
        //test si l'operation [2] == "M" or "P" or "E"
        if(operationMax.charAt(2)=='M'){
            vers.setText("Machine");
            if (transaction.equals(""))
                transaction="M->M";
            else
                transaction=transaction.charAt(3)+"->M";
        }else if(operationMax.charAt(2)=='P'){
            vers.setText("Pair");
            if (transaction.equals(""))
                transaction="M->P";
            else
                transaction=transaction.charAt(3)+"->P";
        }
        else {
            vers.setText("Ensignant");
            if (transaction.equals(""))
                transaction="M->E";
            else
                transaction=transaction.charAt(3)+"->E";
        }
        indexMax=indexMa;
        return indexMa;
    }
    public void selectMax(int indexMax){
        resultat.getSelectionModel().select(indexMax);
        resultat.getFocusModel().focus(indexMax);
        resultat.scrollTo(indexMax);
        operation.getSelectionModel().select(indexMax);
        operation.getFocusModel().focus(indexMax);
        operation.scrollTo(indexMax);
        resultat.setStyle("-fx-control-inner-background: green;");
        operation.setStyle("-fx-control-inner-background: green;");
        //color of selected item green
    }


}
