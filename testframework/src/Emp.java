/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annotation.Url;
import etu1866.framework.ModelView;

/**
 *
 * @author ITU
 */
public class Emp {
    
    @Url(valeur="emp-add1")
    public ModelView test(){
        return new ModelView("test.jsp");
    } 
}
