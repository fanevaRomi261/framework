<%@page import="model.*,java.util.Vector"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        Vector<Etudiant> etu = (Vector<Etudiant>) request.getAttribute("list");
        for (int i = 0; i < etu.size(); i++) {
            out.println("<p><a href=\"etu-detail?id=" + etu.get(i).getId() + "\">" + etu.get(i).getNom() + "</a></p>");
        }
    %>

</body>
</html>