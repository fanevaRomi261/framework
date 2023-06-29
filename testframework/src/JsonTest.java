package olona;

import utility.FileUpload;
import annotation.*;
import etu1866.framework.ModelView;
import java.util.HashMap;
import java.util.Map;
import model.*;

public class JsonTest {

    @Url(valeur = "test-json")
    public ModelView getJson(){
        ModelView mv = new ModelView();

        mv.setJson(true);


        // mv.setUrl("test.jsp");

        mv.addItem("eleve1",new Etudiant(1,"un"));
        mv.addItem("eleve2",new Etudiant(1,"deux"));
        mv.addItem("eleve3",new Etudiant(1,"trois"));

        return mv;
    }
    
}
