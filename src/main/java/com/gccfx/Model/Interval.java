package com.gccfx.Model;

public class Interval {
    private int borneInf;
    private int borneSup;

    private static int compteurInterval = 0;

    public Interval(int borneInf, int borneSup) {
        this.borneInf = borneInf;
        this.borneSup = borneSup;
        compteurInterval++;
    }

    public Interval()  {
        this.borneInf = 0;
        this.borneSup = 100;
        compteurInterval++;
    }

    public int getBorneInf() {
        return borneInf;
    }

    public void setBorneInf(int borneInf) {
        this.borneInf = borneInf;
    }

    public int getBorneSup() {
        return borneSup;
    }

    public void setBorneSup(int borneSup) {
        this.borneSup = borneSup;
    }

    //toString
    @Override
    public String toString() {
        return "Interval [borneInf=" + borneInf + ", borneSup=" + borneSup + "]";
    }

    public Integer getLowerBound() {
        return borneInf;
    }

    public Integer getUpperBound() {
        return borneSup;
    }

    public int getBornSup() {
        return borneSup;

    }

    public String getMin() {
        return String.valueOf(borneInf);
    }

    public String getMax() {
        return String.valueOf(borneSup);
    }
}
