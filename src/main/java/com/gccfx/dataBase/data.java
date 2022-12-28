package com.gccfx.dataBase;

import com.gccfx.Model.Categorie;
import com.gccfx.Model.Interval;
import com.gccfx.Model.Niveau;

import java.util.LinkedList;
import java.util.Map;

public class data {
    public static Double machine;
    public static Double ensignant;
    public static Double pair;
    public static LinkedList<Categorie> categories=new LinkedList<>();
    public static int nbIntervalles=0;
    public static LinkedList<Interval> intervalles = new LinkedList<Interval>();
    public static Niveau niveau=new Niveau();

    public static Map<String, Double> mapMPEValues;
    public static Map<String, Integer> mapM;
    public static Map<String, Integer> mapP;

    public static void afficher(){
        System.out.println("Niveau : "+niveau);
        for (Categorie categorie : categories) {
            System.out.println(categorie);
        }

        for (Interval interval : intervalles) {
            System.out.println(interval);
        }
    }
    public static void afficherMap(){
       //afficher mapP
        for (Map.Entry<String, Integer> entry : mapP.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //afficher mapM
        for (Map.Entry<String, Integer> entry : mapM.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //afficher mapMPEValues
        for (Map.Entry<String, Double> entry : mapMPEValues.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
