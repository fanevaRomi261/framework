    <%-- 
    Document   : test
    Created on : 28 mars 2023, 09:10:03
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,model.*"%>
<%
    Vector<Etudiant> emp = (Vector<Etudiant>) request.getAttribute("list");
    out.println(emp.get(0).getNom());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>mety</h1>
    </body>
</html>
