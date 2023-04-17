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
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import utility.Util;

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
            ModelView mv1 = this.getView(map);
            
            RequestDispatcher disp = request.getRequestDispatcher("/jsp/" + mv1.getView());
            disp.forward(request, response);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public ModelView getView(Mapping map) throws Exception {
        try {
            String classname = map.getClassName();
            String method = map.getMethod();

            Object obj = Class.forName(classname).newInstance();

            Method m = obj.getClass().getDeclaredMethod(method, null);
            m.setAccessible(true);
            ModelView mv = (ModelView) m.invoke(obj, null);

            return mv;

        } catch (Exception e) {
            throw e;
        }

    }

    /*
        fonction maka anle mapping mifanaraka
        amle slug(url), oh: emp-add
        slug indice 4 ilay ao arinanle anarnle projet
        amle lien
    */ 
    public Mapping getMapping(String url) throws Exception {
        String[] slug = Util.lien(url);
        for (Map.Entry<String, Mapping> all : mappingUrls.entrySet()) {
            if (slug[4].compareToIgnoreCase(all.getKey()) == 0) {
                return all.getValue();
            }
        }
        throw new Exception("Tsy misy");
    }

    @Override
    public void init() throws ServletException {
        try {
            Class[] all = Fonction.getAllClasses();
            for (Class a : all) {
                Method[] mtd = Fonction.getMethodsWithAnnotation(a, Url.class);
                for (int i = 0; i < mtd.length; i++) {
                    Url m = (Url) mtd[i].getAnnotation(Url.class);
                    this.mappingUrls.put(m.valeur(), new Mapping(a.getName(), mtd[i].getName()));
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
