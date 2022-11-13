package com.gccfx.Model;

public class Parametre {
    private String nomParametre;
    private int facteur;
    private int valeur;

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

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
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
}
