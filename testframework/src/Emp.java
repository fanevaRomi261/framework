/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

import annotation.Url;
import etu1866.framework.ModelView;
import java.util.Date;

/**
 *
 * @author ITU
 */
public class Emp {

    String nom;
    String prenom;
    Date date;
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Emp() {
    }

    public Emp(String nom,String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Url(valeur="emp-all")
    public ModelView find(){
        ModelView mv = new ModelView();
        mv.setUrl("test.jsp");

        Vector<Emp> data = new Vector<>();
        data.add(new Emp("Faneva","Prenom1"));
        data.add(new Emp("Rakoto","Prenom1"));
        data.add(new Emp("Rakoto","Prenom1"));

        mv.addItem("list",data);

        return mv;
    }

    @Url(valeur="emp-form")
    public ModelView form(){

        ModelView mv = new ModelView();
        mv.setUrl("formulaire.jsp");

        return mv;
    }

    @Url(valeur="emp-save")
    public ModelView save(){
        ModelView mv = new ModelView();

        // System.out.println("nom 1:"+this.getNom());
        mv.addItem("date",this.getDate());

        mv.setUrl("valiny.jsp");

        return mv;
    }

    public String getNom() {
        return nom;
    } 

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    } 
}
