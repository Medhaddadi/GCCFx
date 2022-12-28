package com.gccfx.Model;

import com.gccfx.Model.*;
public class Niveau {
    private double niveau1;
    private double niveau2;
    private double niveau3;

    public Niveau(double niveau1, double niveau2, double niveau3) {
        this.niveau1 = niveau1;
        this.niveau2 = niveau2;
        this.niveau3 = niveau3;
    }

    public Niveau() {
        this.niveau1 = 0;
        this.niveau2 =0;
        this.niveau3 = 0;
    }

    public double getNiveau1() {
        return niveau1;
    }

    public void setNiveau1(double niveau1) {
        this.niveau1 = niveau1;
    }

    public double getNiveau2() {
        return niveau2;
    }

    public void setNiveau2(double niveau2) {
        this.niveau2 = niveau2;
    }

    public double getNiveau3() {
        return niveau3;
    }

    public void setNiveau3(double niveau3) {
        this.niveau3 = niveau3;
    }

    //toString
    @Override
    public String toString() {
        return "Niveau [niveau1=" + niveau1 + ", niveau2=" + niveau2 + ", niveau3=" + niveau3 + "]";
    }

    public Double getNiveau(int i) {
        if (i==1) return niveau1;
        if (i==2) return niveau2;
        if (i==3) return niveau3;
        return null;
    }
}
