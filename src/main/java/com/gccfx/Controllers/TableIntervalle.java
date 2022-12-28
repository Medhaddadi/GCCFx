package com.gccfx.Controllers;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class TableIntervalle {
    private String nameCategorie;

    private ComboBox<String> inter1;
    private ComboBox<String> inter2;
    private ComboBox<String> inter3;
    private ComboBox<String> inter4;
    private ComboBox<String> inter5;
    private ComboBox<String> inter6;

    public TableIntervalle(String nameCategorie, ObservableList<String> listMpe) {
        this.nameCategorie = nameCategorie;
        inter1 = new ComboBox<>(listMpe);
        inter2 = new ComboBox<>(listMpe);
        inter3 = new ComboBox<>(listMpe);
        inter4 = new ComboBox<>(listMpe);
        inter5 = new ComboBox<>(listMpe);
        inter6 = new ComboBox<>(listMpe);
    }


    //getter and setter

    public String getNameCategorie() {
        return nameCategorie;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }

    public ComboBox<String> getInter1() {
        return inter1;
    }

    public void setInter1(ComboBox<String> inter1) {
        this.inter1 = inter1;
    }

    public ComboBox<String> getInter2() {
        return inter2;
    }

    public void setInter2(ComboBox<String> inter2) {
        this.inter2 = inter2;
    }

    public ComboBox<String> getInter3() {
        return inter3;
    }

    public void setInter3(ComboBox<String> inter3) {
        this.inter3 = inter3;
    }

    public ComboBox<String> getInter4() {
        return inter4;
    }

    public void setInter4(ComboBox<String> inter4) {
        this.inter4 = inter4;
    }

    public ComboBox<String> getInter5() {
        return inter5;
    }

    public void setInter5(ComboBox<String> inter5) {
        this.inter5 = inter5;
    }

    public ComboBox<String> getInter6() {
        return inter6;
    }

    public void setInter6(ComboBox<String> inter6) {
        this.inter6 = inter6;
    }



    @Override
    public String toString() {
        return "TableIntervalle{" +
                "nameCategorie='" + nameCategorie + '\'' +
                ", inter1=" + inter1 +
                ", inter2=" + inter2 +
                ", inter3=" + inter3 +
                ", inter4=" + inter4 +
                ", inter5=" + inter5 +
                ", inter6=" + inter6 +
                '}';
    }

    public String getInter(int i) {
        switch (i) {
            case 1:
                return inter1.getValue();
            case 2:
                return inter2.getValue();
            case 3:
                return inter3.getValue();
            case 4:
                return inter4.getValue();
            case 5:
                return inter5.getValue();
            case 6:
                return inter6.getValue();
            default:
                return null;
        }
    }
}
