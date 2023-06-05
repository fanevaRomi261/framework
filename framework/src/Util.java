/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import etu1866.framework.Mapping;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.text.SimpleDateFormat;

/**
 *
 * @author faneva
 */
public class Util {
    
    public static String[] lien(String url) throws Exception{
        String[] reg = url.split("/");
        // System.out.println(reg.length);
        if(reg.length >= 5){
           return reg;
        } else {
            throw new Exception("index");
        }     
    }

    public static Object cast(String toCast,Class typeOfCast) throws Exception{

        if (typeOfCast == int.class || typeOfCast == Integer.class) {
            return Integer.parseInt(toCast);
        } else if (typeOfCast == double.class || typeOfCast == Double.class) {
            return Double.parseDouble(toCast);
        } else if(typeOfCast == Date.class){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(toCast);
        }
            return toCast;
    }
}
