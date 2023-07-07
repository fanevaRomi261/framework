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
        out.println(etu.get(0).getNom());
        out.println(etu.get(1).getNom());
        out.println(etu.get(2).getNom());
    %>
</body>
</html>