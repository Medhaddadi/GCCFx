package com.gccfx.Model;

public class Parametre {
    private String nomParametre;
    private int facteur;
    private double valeur;

    private static int compteurPar = 0;

    public Parametre(String nomParametre, int facteur, int valeur) {
        this.nomParametre = nomParametre;
        this.facteur = facteur;
        this.valeur = valeur;
        compteurPar++;
    }

    public Parametre(String nomParametre, int facteur) {
        this.nomParametre = nomParametre;
        this.facteur = facteur;
        this.valeur = 0;
        compteurPar++;
    }

    public Parametre(String nomParametre) {
        this.nomParametre = nomParametre;
        compteurPar++;
    }

    public Parametre() {

    }

    public String getNomParametre() {
        return nomParametre;
    }

    public void setNomParametre(String nomParametre) {
        this.nomParametre = nomParametre;
    }

    public int getFacteur() {
        return facteur;
    }

    public void setFacteur(int facteur) {
        this.facteur = facteur;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    //toString
    @Override
    public String toString() {
        return "Parametre [nomParametre=" + nomParametre + ", facteur=" + facteur + ", valeur=" + valeur + "]";
    }

    public String getName() {
        return nomParametre;
    }

    public void setName(String text) {
        this.nomParametre=text;
    }


}
