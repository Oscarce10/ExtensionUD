<%-- 
    Document   : index
    Created on : 26/03/2020, 03:31:28 PM
    Author     : USER
--%>

<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/flatly.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="icon" href="img/logo/serverCluster.svg">

        <link
            href="https://fonts.googleapis.com/css?family=Lexend+Deca|Lexend+Giga&display=swap"
            rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        
        <% HttpSession sesion = request.getSession(); %>
        <%
            if (request.getAttribute("pid") == null && sesion.getAttribute("id") != null && sesion.getAttribute("tipo") != null) {
                String p = sesion.getAttribute("tipo").toString() + "/inicio.jsp";
        %>
            <jsp:include page='<%=p%>'></jsp:include>

            <% } else if (request.getParameter("pid") != null && sesion.getAttribute("id") != null && sesion.getAttribute("id") != "" || request.getAttribute("action") != null) {
            // Create a String.
            String p;
            // Get the bytes from the String, using getBytes() API method of String.
            byte[] byteArray = Base64.decodeBase64(request.getParameter("pid").getBytes());
            p = new String(byteArray);
            System.out.println("p: " + p);
        %>
        <jsp:include page='<%=p%>'></jsp:include>
        <%
        } else {
        %>
        <jsp:include page='inicio.jsp'></jsp:include>
        <%
            }
        %>


        
    </body>
</html>
