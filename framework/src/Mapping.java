/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1866.framework;

/**
 *
 * @author ITU
 */
public class Mapping {
    String className;
    String method;
    Class[] methodArgumentType; //type ny arguments anle methode no ato



    public Mapping(String className, String method, Class[] methodArgumentType) {
        this.className = className;
        this.method = method;
        this.methodArgumentType = methodArgumentType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class[] getMethodArgumentType() {
        return methodArgumentType;
    }

    public void setMethodArgumentType(Class[] methodArgumentType) {
        this.methodArgumentType = methodArgumentType;
    }

    
    
}
