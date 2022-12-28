package com.gccfx.Model;

import java.util.LinkedList;
import java.util.List;

public class catIntervalle {
    private String nomCategorie;
    private List<String> IntervalesValue=new LinkedList<>();


    public catIntervalle(String nomCategorie, LinkedList<String> intervalesValue) {
        this.nomCategorie = nomCategorie;
        IntervalesValue = intervalesValue;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<String> getIntervalesValue() {
        return IntervalesValue;
    }

    public void setIntervalesValue(List<String> intervalesValue) {
        IntervalesValue = intervalesValue;
    }

    public void addIntervale(String intervale){
        IntervalesValue.add(intervale);
    }
}
