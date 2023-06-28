package model;

import utility.FileUpload;
import annotation.*;
import etu1866.framework.ModelView;

@Scope(pattern="singleton")
public class Voiture {

    Integer id;
    String immatriculation;
    int ct;

    public Voiture() {
        ct = 0;
    }

    @Url(valeur="voiture")
    public ModelView index(){
        ModelView mv = new ModelView();
        mv.setUrl("voiture.jsp");
        ct++;
        return mv;
    }

    @Url(valeur="savevoiture")
    public ModelView save(){
        ModelView mv = new ModelView();
        ct++;
        System.out.println(ct);
        // mv.setUrl();
        return mv;
    }
    
}
