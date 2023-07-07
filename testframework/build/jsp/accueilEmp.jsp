<!DOCTYPE html>
<html lang="en">
<%@page import="model.*"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        Emp inserer = (Emp) request.getAttribute("emp");
        out.println("<p>"+inserer.getNom()+"</p>");
        out.println("<p>"+inserer.getAge()+"</p>");
        out.println("<p>"+inserer.getDate()+"</p>");
        out.println("<p>"+"FILE SIZE " +inserer.getPhoto().getName()+" byte length"+inserer.getPhoto().getFile().length+"</p>");

    %>
</body>
</html>