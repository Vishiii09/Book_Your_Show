<%-- 
    Document   : signout
    Created on : 25 Jun, 2020, 2:37:33 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%
session.removeAttribute("admin");
response.sendRedirect("../login.jsp");
%>
