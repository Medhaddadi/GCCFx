package com.gccfx.Model;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Categorie {
    private String nomCategorie;
    private int nbrParametres;
    LinkedList<Parametre> parametres;
    private double moyenneparametre;

    LinkedList<Pair<Interval,String>> Intervales=new LinkedList<>();

    private static int compteurCat = 0;

    public void setIntervales(LinkedList<Pair<Interval,String>> intervales) {
        Intervales = intervales;
    }
    public void getInterval(){
        for (Pair<Interval,String> interval : Intervales) {
            System.out.println(interval.getKey().getBorneInf()+" "+interval.getKey().getBorneSup()+" "+interval.getValue());
        }
    }
    //constructor
    public Categorie(String nomCategorie, int nbrParametres) {
        this.nomCategorie = nomCategorie;
        this.nbrParametres = nbrParametres;
        parametres = new LinkedList<Parametre>();
        compteurCat++;
    }
    //get compteurCAT
    public static int getCompteurCat() {
        return compteurCat;
    }

    //constructor
    public Categorie() {
        parametres = new LinkedList<Parametre>();
        compteurCat++;
    }


    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getNbrParametres() {
        return nbrParametres;
    }

    public void setNbrParametres(int nbrParametres) {
        this.nbrParametres = nbrParametres;
    }

    public LinkedList<Parametre> getParametres() {
        return parametres;
    }

    public void setParametres(LinkedList<Parametre> parametres) {
        this.parametres = parametres;
    }

    public void addParametre(Parametre p) {
        parametres.add(p);
    }

    public void addParametre(String nomParametre, int facteur) {
        parametres.add(new Parametre(nomParametre, facteur));
    }

    public void removeParametre(Parametre parametre) {
        parametres.remove(parametre);
    }

    public void setParam(LinkedList<Parametre> parametres) {
        this.parametres = parametres;
    }

    //toString
    @Override
    public String toString() {
        return "Categorie [nomCategorie=" + nomCategorie +",moynneParametre="+moyenneparametre+", nbrParametres=" + nbrParametres + ", parametres=" + parametres + "]";
    }
    //get  name
    public String getName() {
        return nomCategorie;
    }
    //get  number of parameters
    public int getNbrParam() {
        return parametres.size();
    }
    //get  parameters
    public LinkedList<Parametre> getParam() {
        return parametres;
    }
    //get parametre of i index
    public Parametre getParametre(int i) {
        return parametres.get(i);
    }

    public void setName(String name) {
        this.nomCategorie = name;
    }

    public void setNbParam(int nbParam) {
        this.nbrParametres = nbParam;
    }
    public void CalculMoyenne() {
        double somme = 0;
        for (int i = 0; i < parametres.size(); i++) {
            somme += parametres.get(i).getValeur() * parametres.get(i).getFacteur();
        }
       moyenneparametre = somme / parametres.size();
    }
    public double getMoyenne() {
        return moyenneparametre;
    }

    public String nameProperty() {
        return getName();
    }
}
