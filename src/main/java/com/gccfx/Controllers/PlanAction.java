package com.gccfx.Controllers;

import javafx.beans.property.SimpleStringProperty;

public class PlanAction {
    private SimpleStringProperty probabilite;
    private SimpleStringProperty purcentage;
    private SimpleStringProperty x;

    public PlanAction(String probabilite, String purcentage, String x) {
        this.probabilite = new SimpleStringProperty(probabilite);
        this.purcentage = new SimpleStringProperty(purcentage);
        this.x = new SimpleStringProperty(x);
    }

    public String getProbabilite() {
        return probabilite.get();
    }

    public void setProbabilite(String probabilite) {
        this.probabilite.set(probabilite);
    }

    public String getPurcentage() {
        return purcentage.get();
    }

    public void setPurcentage(String purcentage) {
        this.purcentage.set(purcentage);
    }

    public String getX() {
        return x.get();
    }

    public void setX(String x) {
        this.x.set(x);
    }

}
