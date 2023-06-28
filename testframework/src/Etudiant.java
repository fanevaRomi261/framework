package model;

import annotation.Url;
import etu1866.framework.ModelView;
import java.util.Vector;

public class Etudiant {
    int id;
    String nom;

    public Etudiant() {
    }

    public Etudiant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    

    @Url(valeur="etu-all")
    public ModelView all(){
        ModelView mv = new ModelView();
        mv.setUrl("test.jsp");

        Vector<Etudiant> data = new Vector<>();
        data.add(new Etudiant(1,"Prenom1"));
        data.add(new Etudiant(2,"Prenom1"));
        data.add(new Etudiant(3,"Prenom1"));

        mv.addItem("list",data);

        return mv;
    }

    @Url(valeur="etu-detail")
    public ModelView detail(int id,String test){
        ModelView mv = new ModelView();
        mv.setUrl("detail.jsp");

        Vector<Etudiant> data = new Vector<>();
        data.add(new Etudiant(1,"Prenom1"));
        data.add(new Etudiant(2,"Prenom2"));
        data.add(new Etudiant(3,"Prenom3"));

        for (int i = 0; i < data.size(); i++) {
            if(id == data.get(i).getId()){
                mv.addItem("detail",data.get(i));
            }
        }
        mv.addItem("test",test);

        return mv;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    
}
