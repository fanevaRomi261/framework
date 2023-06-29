package olona;

import utility.FileUpload;
import annotation.*;
import etu1866.framework.ModelView;
import java.util.HashMap;
import java.util.Map;

public class SessionTest {
    HashMap<String,Boolean> session = new HashMap();
    
    @Session
    @Url(valeur = "get-session")
    public ModelView getSession(){
        ModelView mv = new ModelView();

        System.out.println("session ggg");
        for (Map.Entry<String, Boolean> all : this.session.entrySet()) {
            System.out.println("key :"+all.getKey()+" value :"+all.getValue());
        }

        return mv;
    }
    
}
