package com.gccfx.Model;

import com.gccfx.Model.*;
import java.util.LinkedList;

public class Categorie {
    private String nomCategorie;
    private int nbrParametres;
    LinkedList<Parametre> parametres;

    private static int compteurCat = 0;

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
        return "Categorie [nomCategorie=" + nomCategorie + ", nbrParametres=" + nbrParametres + ", parametres=" + parametres
                + "]";
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
}
