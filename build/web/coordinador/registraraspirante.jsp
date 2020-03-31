<%@include file="nav.jsp"%>
<%
    if (request.getAttribute("fail") != null && request.getAttribute("fail").toString().equals("correo")) {
%>
<div class="alert alert-danger" role="alert">
    Correo ya registrado, ingrese otro
</div>
<% }%>
<div style="margin-top: 100px;"><%@include file="../registrousuario.jsp"%></div>
