/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annotation.Url;

/**
 *
 * @author ITU
 */
public class Emp {
    
    @Url(valeur="emp-add")
    public void test(){
        System.out.println("test");
    } 
}
