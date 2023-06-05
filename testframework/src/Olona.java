package olona;

import utility.FileUpload;
import annotation.Url;
import etu1866.framework.ModelView;

public class Olona {
    String nom;
    FileUpload photo;
    
    @Url(valeur = "index")
    public ModelView index(){
        ModelView view = new ModelView();
        view.setUrl("upload.jsp");

        return view;
    }


    @Url(valeur = "save")
    public ModelView save(){
        ModelView view = new ModelView();
        System.out.println("nom olona: "+this.nom);
        System.out.println("file name: " + this.photo.getName()+" | byte length :"+this.photo.getFile().length);
        return view;
    }
    
}
