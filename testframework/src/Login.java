package olona;

import utility.FileUpload;
import annotation.*;
import etu1866.framework.ModelView;

public class Login {
    String user;
    String pass;
    

    @Url(valeur="login")
    public ModelView login(){
        ModelView mv = new ModelView();
        mv.setUrl("login.jsp");

        return mv;
    }


    @Url(valeur="accueil")
    public ModelView redirect(){
        ModelView mv = new ModelView();

        

        if(this.user.compareTo("admin") == 0 && this.pass.compareTo("1234") == 0){
            this.addSessionToMv(mv);
            mv.setUrl("accueil.jsp");
        } else if(this.user.compareTo("user") == 0 && this.pass.compareTo("1234") == 0){
            this.addSessionToMv1(mv);
            mv.setUrl("accueil.jsp");    
        }

        return mv;
    }

    @Auth(profil = "admin")
    @Url(valeur="log-test")
    public ModelView test(){
        ModelView mv = new ModelView();

        mv.setUrl("test.jsp");

        return mv;
    }




    public void addSessionToMv(ModelView mv){
        mv.addSession("isConnected", true);
        mv.addSession("admin", true);
    }

    
    public void addSessionToMv1(ModelView mv){
        mv.addSession("isConnected", true);
        mv.addSession("admin", false);
    }


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public String getPass() {
        return pass;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
