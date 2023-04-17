/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

import annotation.Url;
import etu1866.framework.ModelView;

/**
 *
 * @author ITU
 */
public class Emp {

    String nom;
    
    public Emp() {
    }

    public Emp(String nom) {
        this.nom = nom;
    }

    @Url(valeur="emp-add1")
    public ModelView find(){
        ModelView mv = new ModelView();
        mv.setUrl("test.jsp");

        Vector<Emp> data = new Vector<>();
        data.add(new Emp("Faneva"));
        data.add(new Emp("Rakoto"));
        data.add(new Emp("Rakoto"));

        mv.addItem("list",data);

        return mv;
    }

    public String getNom() {
        return nom;
    } 
}
