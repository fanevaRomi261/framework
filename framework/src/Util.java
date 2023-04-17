/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import etu1866.framework.Mapping;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author faneva
 */
public class Util {
    
    public static String[] lien(String url) throws Exception{
        String[] reg = url.split("/");
        System.out.println(reg.length);
        if(reg.length >= 5){
           return reg;
        } else {
            throw new Exception("tsy misy lien");
        }     
    }
}
