package olona;

import utility.FileUpload;
import annotation.*;
import etu1866.framework.ModelView;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import model.*;

public class RestApiTest {

    @RestApi
    @Url(valeur = "test-rest")
    public Vector getEtu(){

        Vector<Etudiant> etu = new Vector<>();

        etu.add(new Etudiant(1,"un"));
        etu.add(new Etudiant(2,"deux"));
        etu.add(new Etudiant(3,"trois"));

        return etu;
    }
    
}
