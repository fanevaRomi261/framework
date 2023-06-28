/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1866.framework;

import java.util.HashMap;

/**
 *
 * @author ITU
 */
public class ModelView {
    String url;
    HashMap <String,Object> data = new HashMap<>();
    HashMap <String,Boolean> session = new HashMap<>();

    
    public ModelView() {
    }

    public ModelView(String url, HashMap<String, Object> data) {
        this.url = url;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public void addItem(String cle,Object valueur){
        this.getData().put(cle, valueur);
    }

    public HashMap<String, Boolean> getSession() {
        return session;
    }

    public void setSession(HashMap<String, Boolean> session) {
        this.session = session;
    }

    public void addSession(String cle,Boolean valeur){
        this.getSession().put(cle, valeur);
    }
    
    
    
}
