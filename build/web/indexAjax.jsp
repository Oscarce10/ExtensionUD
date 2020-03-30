<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<% HttpSession sesion = request.getSession(); %>
<%
    if (request.getParameter("pid") == null || sesion.getAttribute("id") == null && sesion.getAttribute("tipo") != null && !sesion.getAttribute("tipo").equals("coordinador")) {
        request.getRequestDispatcher("404.html").forward(request, response);
        return;
    } else {
        
        String p;
        byte[] byteArray = Base64.decodeBase64(request.getParameter("pid").getBytes());
        p = new String(byteArray); 
        %>
         <jsp:include page='<%=p%>'></jsp:include>
    <% } %>
