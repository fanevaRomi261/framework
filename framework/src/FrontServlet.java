/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu1866.framework.servlet;

import annotation.Fonction;
import annotation.Url;
import etu1866.framework.Mapping;
import etu1866.framework.ModelView;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import utility.Util;
import java.util.Date;

/**
 *
 * @author faneva
 */
public class FrontServlet extends HttpServlet {

    HashMap<String, Mapping> mappingUrls = new HashMap<>();

    public HashMap<String, Mapping> getMappingUrls() {
        return mappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) {
        this.mappingUrls = mappingUrls;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String url = request.getRequestURL().toString();

            Mapping map = this.getMapping(url);

            Object obj = Class.forName(map.getClassName()).newInstance();
            this.sendData(request,obj);

            ModelView mv = this.getMv(request,map,obj);

            String urlMv = mv.getUrl();
            HashMap<String,Object> dataMv = mv.getData();
            
            this.setAllAttribut(request, dataMv);
            

            RequestDispatcher disp = request.getRequestDispatcher("/jsp/"+urlMv);
            disp.forward(request, response);
        } catch (Exception e) {
            out.println("URL :"+request.getRequestURL().toString());
            out.println("ERROR :"+e.getMessage());
            e.printStackTrace();
        }
    }

    /*
        mandefa donnees affichage --> back
    */
    public void sendData(HttpServletRequest request,Object obj) throws Exception{
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            String value = request.getParameter(fields[i].getName());
            Class inCaseToCastManually = fields[i].getType();

            if(value != null){
                fields[i].setAccessible(true);

                // if(inCaseToCastManually == "java.util.Date"){
                //     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                //     Date parsed = format.parse(value);
                //     fields[i].set(obj,parsed);
                // } else if(inCaseToCastManually == "int"){
                //     fields[i].set(obj, Integer.parseInt(value));
                // } else if(inCaseToCastManually == "double"){
                //     fields[i].set(obj, Double.parseDouble(value));
                // } else {
                //     fields[i].set(obj, fields[i].getType().cast(value));
                // }

                fields[i].set(obj, Util.cast(value, inCaseToCastManually));

            }
        }

    }

    public void setAllAttribut(HttpServletRequest request, HashMap<String, Object> data) throws Exception {
        for (Map.Entry<String, Object> alldata : data.entrySet()) {
            request.setAttribute(alldata.getKey(), alldata.getValue());
        }
    }

    public Object[] argumentValues(HttpServletRequest request, Method meth) throws Exception {
        Parameter[] param = meth.getParameters();

        Object[] values = new Object[param.length];
        for (int i = 0; i < values.length; i++) {
            Class type = param[i].getType();
            String value = request.getParameter(param[i].getName());
            values[i] = Util.cast(value, type);
        }

        return values;
    }
    

    public ModelView getMv(HttpServletRequest request,Mapping map,Object obj) throws Exception {

        String classname = map.getClassName();
        String method = map.getMethod();
        Class[] argumentType = map.getMethodArgumentType();

        Method m = obj.getClass().getDeclaredMethod(method, argumentType);
        m.setAccessible(true);

        Object[] argValues = this.argumentValues(request, m);
        ModelView mv = (ModelView) m.invoke(obj, argValues);
        // System.out.println("SIZE : "+mv.getData().size());

        return mv;

    }
    

    /*
     * fonction maka anle mapping mifanaraka
     * amle slug(url), oh: emp-add
     * slug indice 4 ilay ao arinanle anarnle projet
     * amle lien
     */
    public Mapping getMapping(String url) throws Exception {
        String[] slug = Util.lien(url);
        for (Map.Entry<String, Mapping> all : mappingUrls.entrySet()) {
            if (slug[4].compareToIgnoreCase(all.getKey()) == 0) {
                return all.getValue();
            }
        }
        throw new Exception("Lien tsy misy");
    }

    @Override
    public void init() throws ServletException {
        try {
            Class[] all = Fonction.getAllClasses();
            for (Class a : all) {
                Method[] mtd = Fonction.getMethodsWithAnnotation(a, Url.class);
                for (int i = 0; i < mtd.length; i++) {
                    Url m = (Url) mtd[i].getAnnotation(Url.class);
                    this.mappingUrls.put(m.valeur(), new Mapping(a.getName(), mtd[i].getName(), mtd[i].getParameterTypes()));
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
